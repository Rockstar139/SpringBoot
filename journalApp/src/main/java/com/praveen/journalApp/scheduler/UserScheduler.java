package com.praveen.journalApp.scheduler;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.angus.mail.handlers.message_rfc822;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.praveen.journalApp.cache.AppCache;
import com.praveen.journalApp.entity.JournalEntry;
import com.praveen.journalApp.entity.User;
import com.praveen.journalApp.enums.Sentiment;
import com.praveen.journalApp.repository.UserRepositoryImpl;
import com.praveen.journalApp.service.EmailService;
import com.praveen.journalApp.service.SendMsgWhatsapp;
import com.praveen.journalApp.service.SentimentAnalysisService;

@Component
public class UserScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    // @Autowired
    // private SentimentAnalysisService sentimentAnalysisService;

    @Autowired
    private SendMsgWhatsapp sendMsgWhatsapp;

    @Autowired
    private AppCache appCache;
    // @Scheduled(cron = "0 0 9 ? * SUN *")
    // @Scheduled(cron = "0 * * ? * *")
    public void fetchUsersAndSendSAMail(){
        List<User> users = userRepositoryImpl.getUserForSA();
        for(User user: users){
            List<Sentiment> sentiments = user.getJournalEntries().stream().filter(x->x.getDate().isAfter(LocalDateTime.now().minus(7,ChronoUnit.DAYS))).map(x->x.getSentiment()).collect(Collectors.toList());
            Map<Sentiment, Integer> sentimentCounts = new HashMap<>();
            for(Sentiment sentiment: sentiments){
                if(sentiment != null){
                    sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment, 0)+1);
                }
            }
            Sentiment mostFrquentSentiment = null;
            int maxCount = 0;
            for(Map.Entry<Sentiment, Integer> entry: sentimentCounts.entrySet()){
                if (entry.getValue()>maxCount){
                    maxCount = entry.getValue();
                    mostFrquentSentiment = entry.getKey();
                }
            }
            if(mostFrquentSentiment !=null){
                emailService.sendEmail(user.getEmail(), "Sentiment For Last 7 Days", mostFrquentSentiment.toString());
            }
        }

    }

    // @Scheduled(cron = "5 * * ? * *")
    public void clearAppCache(){
        appCache.init();
    }

    public void sendMessage(String to, String message){
        sendMsgWhatsapp.sendMessage(to,message);
    }

}

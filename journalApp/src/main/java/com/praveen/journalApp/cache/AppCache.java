package com.praveen.journalApp.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.praveen.journalApp.entity.ConfigJournalAppEntity;
import com.praveen.journalApp.repository.ConfigJournalAppRepository;

import jakarta.annotation.PostConstruct;

@Component
public class AppCache {

    public enum keys{
        JOURNAL_API
    }

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String, String> appCache;

    @PostConstruct
    public void init(){
        appCache = new HashMap<>();
        List<ConfigJournalAppEntity> ls =  configJournalAppRepository.findAll();
        for(ConfigJournalAppEntity config: ls){
            appCache.put(config.getKey(),config.getValue());
        }
    }
}

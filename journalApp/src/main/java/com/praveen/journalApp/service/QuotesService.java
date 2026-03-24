package com.praveen.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.praveen.journalApp.apiResponse.QuoteResponse;
import com.praveen.journalApp.cache.AppCache;

@Component
public class QuotesService {
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AppCache appCache;

    @Value("${quotes.apiKey}")
    public String apiKey;

    // String api = "https://dummyjson.com/quotes/1";


    public QuoteResponse getQuote(){
        ResponseEntity<QuoteResponse> response = restTemplate.exchange(appCache.appCache.get(AppCache.keys.JOURNAL_API.toString()), HttpMethod.GET, null, QuoteResponse.class);
        QuoteResponse body = response.getBody();
        return body;
    }

}

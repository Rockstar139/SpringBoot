package com.praveen.journalApp.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {
    @Autowired
    private EmailService emailService;
    
    @Test
    @Disabled
    void testSendEmail(){
        emailService.sendEmail("praveenshakya786@hotmail.com","testing", "Hi praveen just testing");
    }
}

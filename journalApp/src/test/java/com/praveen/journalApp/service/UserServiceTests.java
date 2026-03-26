package com.praveen.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.praveen.journalApp.entity.User;
import com.praveen.journalApp.repository.UserRepository;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserRepository userRepository;
    @Disabled
    @Test
    public void testFindByUserName(){
        User user = userRepository.findByUserName("admin");
        assertTrue(user.getJournalEntries().isEmpty());
        assertNotNull(userRepository.findByUserName("Ram"));
    }

    @ParameterizedTest
    @CsvSource({
        "1,1,2","2,12,3","3,3,6"
    })
    @Disabled
    public void test(int a, int b, int expected){
        assertEquals(expected, a+b);
    }

    @ParameterizedTest
    @ValueSource(strings={
        "Ram","Shyam","admin"
    })
    @Disabled
    public void testFindByUserNameParameterized(String userName){
        assertNotNull(userRepository.findByUserName(userName));
    }
}

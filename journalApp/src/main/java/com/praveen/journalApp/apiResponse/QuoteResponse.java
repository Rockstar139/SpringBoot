package com.praveen.journalApp.apiResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuoteResponse {
    private int id;
    private String quote;
    private String author;
}

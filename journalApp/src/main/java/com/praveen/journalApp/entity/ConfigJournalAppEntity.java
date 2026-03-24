package com.praveen.journalApp.entity;


import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "config_journal_app")
public class ConfigJournalAppEntity {

    private String key;
    private String value;
}

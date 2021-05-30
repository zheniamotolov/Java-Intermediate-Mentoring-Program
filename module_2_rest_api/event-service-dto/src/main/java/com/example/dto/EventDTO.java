package com.example.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EventDTO {
    private Long id;
    private String title;
    private String place;
    private String speaker;
    private String eventType;
    private Date dateTime;
}

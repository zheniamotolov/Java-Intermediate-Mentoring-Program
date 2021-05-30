package com.example.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "place")
    private String place;
    @Column(name = "speaker")
    private String speaker;
    @Column(name = "eventType")
    private String eventType;
    @Column(name = "dataTime")
    private Date dateTime;
}

package com.cosmos.wibet.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`match`")
@Data
public class MatchEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "date_creation")
    private String dateCreation;

    @Column(name = "play_date")
    private String playDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "teams")
    private String teams;

    @Column(name = "bets")
    private String bets;
}

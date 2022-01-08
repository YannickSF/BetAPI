package com.cosmos.wibet.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pool")
@Data
public class PoolEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "cote")
    private Integer cote;

    @Column(name = "bets")
    private String bets;

    @Column(name = "`result`")
    private String result;

    @Column(name = "state")
    private String state ;
}

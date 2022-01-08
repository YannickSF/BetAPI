package com.cosmos.wibet.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bet")
@Data
public class BetEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "cote")
    private Integer cote;

    @Column(name = "value")
    private Integer value;

    @Column(name = "pool_id")
    private String poolId;
}

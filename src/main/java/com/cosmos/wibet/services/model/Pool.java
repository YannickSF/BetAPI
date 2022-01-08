package com.cosmos.wibet.services.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
public class Pool {

    private UUID id;
    private String title;
    private Integer cote;
    private List<Bet> bets;
    private String result;
    private String state;

}

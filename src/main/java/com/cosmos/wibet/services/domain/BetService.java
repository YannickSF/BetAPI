package com.cosmos.wibet.services.domain;

import com.cosmos.wibet.persistence.entity.BetEntity;
import com.cosmos.wibet.services.model.Bet;
import com.cosmos.wibet.services.rest.model.BetRest;

import java.util.List;
import java.util.UUID;

public interface BetService {

    Bet createBet(BetRest createBet);

    Bet getBet(String betId);

    List<Bet> getBets();

    Bet updateBet(BetRest updateBet);

    Bet deleteBet(String betId);

}

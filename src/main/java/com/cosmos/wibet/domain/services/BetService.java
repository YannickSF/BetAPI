package com.cosmos.wibet.domain.services;

import com.cosmos.wibet.domain.model.Bet;
import com.cosmos.wibet.rest.model.BetRest;

import java.util.List;

public interface BetService {

    Bet createBet(BetRest createBet);

    Bet getBet(String betId);

    List<Bet> findBetByPoolId(String poolId);

    List<Bet> findBetsByUserId(String userId);

    List<Bet> getBets();

    Bet updateBet(String betId, BetRest updateBet);

    Bet deleteBet(String betId);

}

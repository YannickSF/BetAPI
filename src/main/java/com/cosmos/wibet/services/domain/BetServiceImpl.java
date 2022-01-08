package com.cosmos.wibet.services.domain;

import com.cosmos.wibet.persistence.entity.BetEntity;
import com.cosmos.wibet.persistence.repository.BetRepository;
import com.cosmos.wibet.services.model.Bet;
import com.cosmos.wibet.services.rest.model.BetRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BetServiceImpl implements BetService{

    @Autowired
    private BetRepository betRepository;


    public Bet betEntityToBet(BetEntity betEntity) {
        Bet bet = new Bet();
        bet.setId(UUID.fromString(betEntity.getId()));
        bet.setUserId(UUID.fromString(betEntity.getUserId()));
        bet.setPoolId(UUID.fromString(betEntity.getPoolId()));
        bet.setCote(betEntity.getCote());
        bet.setValue(betEntity.getValue());

        return bet;
    }

    public BetEntity betToBetEntity(Bet bet) {
        BetEntity betEntity = new BetEntity();
        betEntity.setId(bet.getId().toString());
        betEntity.setUserId(bet.getUserId().toString());
        betEntity.setPoolId(bet.getPoolId().toString());
        betEntity.setCote(bet.getCote());
        betEntity.setValue(bet.getValue());

        return betEntity;
    }

    @Override
    public Bet createBet(BetRest createBet) {
        Bet newBet = new Bet();
        newBet.setId(UUID.randomUUID());
        newBet.setCote(createBet.getCote());
        newBet.setValue(createBet.getValue());
        newBet.setUserId(UUID.fromString(createBet.getUserId()));
        newBet.setPoolId(UUID.fromString(createBet.getPoolId()));

        return betEntityToBet(betRepository.save(betToBetEntity(newBet)));
    }

    @Override
    public Bet getBet(String betId) {
        return betEntityToBet(betRepository.findById(betId).get());
    }

    @Override
    public List<Bet> getBets() {
        List<BetEntity> betEntities = (List<BetEntity>) betRepository.findAll();
        return betEntities.stream().map(this::betEntityToBet).collect(Collectors.toList());
    }

    @Override
    public Bet updateBet(BetRest updateBet) {
        return null;
    }

    @Override
    public Bet deleteBet(String betId) {
        return null;
    }

}

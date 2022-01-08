package com.cosmos.wibet.services.rest.controller;

import com.cosmos.wibet.services.domain.BetService;
import com.cosmos.wibet.services.model.Bet;
import com.cosmos.wibet.services.rest.model.BetRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bets")
public class BetController {

    @Autowired
    private BetService betService;

    @PostMapping
    Bet postBet(@RequestBody BetRest betRest){
        return betService.createBet(betRest);
    }

    @GetMapping
    List<Bet> getBetList(){
        return betService.getBets();
    }
}

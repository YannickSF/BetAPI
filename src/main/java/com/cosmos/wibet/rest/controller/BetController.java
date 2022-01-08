package com.cosmos.wibet.rest.controller;

import com.cosmos.wibet.domain.services.BetService;
import com.cosmos.wibet.domain.model.Bet;
import com.cosmos.wibet.rest.model.BetRest;
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

    @GetMapping(value = "/{betId}")
    Bet getBet(@PathVariable String betId){
        return betService.getBet(betId);
    }

    @GetMapping(value = "/{poolId}")
    List<Bet> getBetByPoolId(@PathVariable String poolId){
        return betService.findBetByPoolId(poolId);
    }

    @GetMapping(value = "/{userId}")
    List<Bet> getBetByUserId(@PathVariable String userId){
        return betService.findBetsByUserId(userId);
    }

    @GetMapping
    List<Bet> getBetList(){
        return betService.getBets();
    }

    @PutMapping(value = "/{betId}")
    Bet putBet(@PathVariable String betId, @RequestBody BetRest updateBet){
        return betService.updateBet(betId, updateBet);
    }

    @DeleteMapping(value = "/{betId}")
    Bet deleteBet(@PathVariable String betId){
        return betService.deleteBet(betId);
    }
}

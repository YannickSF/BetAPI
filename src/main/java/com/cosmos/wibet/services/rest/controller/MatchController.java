package com.cosmos.wibet.services.rest.controller;

import com.cosmos.wibet.services.domain.MatchService;
import com.cosmos.wibet.services.model.Match;
import com.cosmos.wibet.services.rest.model.MatchRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matchs")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping
    Match postMatch(@RequestBody MatchRest matchRest){
        return matchService.createMatch(matchRest);
    }

    @GetMapping
    List<Match> getMatchList(){
        return matchService.getMatchs();
    }
}

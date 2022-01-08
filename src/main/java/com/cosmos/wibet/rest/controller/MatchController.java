package com.cosmos.wibet.rest.controller;

import com.cosmos.wibet.domain.services.MatchService;
import com.cosmos.wibet.domain.model.Match;
import com.cosmos.wibet.rest.model.MatchRest;
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

    @GetMapping("/{matchId}")
    Match getMatch(@PathVariable String matchId){
        return matchService.getMatch(matchId);
    }

    @GetMapping
    List<Match> getMatchList(){
        return matchService.getMatchs();
    }

    @PutMapping(value = "/{matchId}")
    Match updateMatch(@PathVariable String matchId, @RequestBody MatchRest matchRest){
        return matchService.updateMatch(matchId, matchRest);
    }

    @DeleteMapping("/{matchId}")
    Match deleteMatch(@PathVariable String matchId){
        return matchService.deleteMatch(matchId);
    }

    @GetMapping("/{matchId}/close")
    Match closeMatch(@PathVariable String matchId){
        return matchService.closeMatch(matchId);
    }

    @GetMapping("/{matchId}/end")
    Match endMatch(@PathVariable String matchId){
        return matchService.endMatch(matchId);
    }

}

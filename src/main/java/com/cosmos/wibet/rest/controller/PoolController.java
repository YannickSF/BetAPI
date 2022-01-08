package com.cosmos.wibet.rest.controller;

import com.cosmos.wibet.domain.services.PoolService;
import com.cosmos.wibet.domain.model.Pool;
import com.cosmos.wibet.rest.model.PoolRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pools")
public class PoolController {

    @Autowired
    private PoolService poolService;

    @PostMapping
    Pool postPool(@RequestBody PoolRest poolRest){
        return poolService.createPool(poolRest);
    }

    @GetMapping(value = "/{matchId}")
    List<Pool> getPool(@PathVariable("matchId") String matchId){
        return poolService.findPoolByMatchId(matchId);
    }


    @PutMapping(value = "/{poolId}")
    Pool putPool(@PathVariable("poolId") String poolId, @RequestBody PoolRest poolRest){
        return poolService.updatePool(poolId, poolRest);
    }

    @DeleteMapping(value = "/{poolId}")
    Pool deletePool(@PathVariable String poolId){
        return poolService.deletePool(poolId);
    }
}

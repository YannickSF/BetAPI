package com.cosmos.wibet.services.rest.controller;

import com.cosmos.wibet.services.domain.PoolService;
import com.cosmos.wibet.services.model.Pool;
import com.cosmos.wibet.services.rest.model.PoolRest;
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

    @GetMapping
    List<Pool> getPoolList(){
        return poolService.getPools();
    }
}

package com.cosmos.wibet.domain.services;

import com.cosmos.wibet.domain.model.Pool;
import com.cosmos.wibet.rest.model.PoolRest;

import java.util.List;

public interface PoolService {

    Pool createPool(PoolRest createPool);

    Pool getPool(String poolId);

    List<Pool> findPoolByMatchId(String matchId);

    List<Pool> getPools();

    Pool updatePool(String poolId, PoolRest updatePool);

    Pool deletePool(String UUID);

    Pool closePool(String poolId);

    Pool endPool(String poolId);
}

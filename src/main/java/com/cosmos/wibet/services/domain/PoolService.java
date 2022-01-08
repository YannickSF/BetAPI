package com.cosmos.wibet.services.domain;

import com.cosmos.wibet.persistence.entity.PoolEntity;
import com.cosmos.wibet.services.model.Pool;
import com.cosmos.wibet.services.rest.model.PoolRest;

import java.util.List;

public interface PoolService {

    Pool createPool(PoolRest createPool);

    Pool getPool(String poolId);

    List<Pool> getPools();

    Pool updatePool(PoolRest updatePool);

    Pool deletePool(String UUID);
}

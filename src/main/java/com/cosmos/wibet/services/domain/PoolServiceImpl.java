package com.cosmos.wibet.services.domain;

import com.cosmos.wibet.persistence.entity.PoolEntity;
import com.cosmos.wibet.persistence.repository.PoolRepository;
import com.cosmos.wibet.services.model.Pool;
import com.cosmos.wibet.services.rest.model.PoolRest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PoolServiceImpl implements PoolService {

    @Autowired
    private PoolRepository poolRepository;


    public Pool poolEntityToPool(PoolEntity poolEntity) {
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        final Pool pool = new Pool();

        pool.setId(UUID.fromString(poolEntity.getId()));
        pool.setTitle(poolEntity.getTitle());
        pool.setCote(poolEntity.getCote());
        pool.setBets(gson.fromJson(poolEntity.getBets(), ArrayList.class));
        pool.setResult(poolEntity.getResult());
        pool.setState(poolEntity.getState());

        return pool;
    }

    public PoolEntity poolToPoolEntity(Pool pool) {
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        final PoolEntity poolEntity = new PoolEntity();

        poolEntity.setId(pool.getId().toString());
        poolEntity.setTitle(pool.getTitle());
        poolEntity.setCote(pool.getCote());
        poolEntity.setBets(gson.toJson(pool.getBets()));
        poolEntity.setResult(pool.getResult());
        poolEntity.setState(pool.getState());

        return poolEntity;
    }

    @Override
    public Pool createPool(PoolRest createPool) {
        Pool newPool = new Pool();
        newPool.setId(UUID.randomUUID());
        newPool.setTitle(createPool.getTitle());
        newPool.setCote(createPool.getCote());
        newPool.setResult("NONE");
        newPool.setState("EN_COUR");
        newPool.setBets(new ArrayList<>());

        return poolEntityToPool(poolRepository.save(poolToPoolEntity(newPool)));
    }

    @Override
    public Pool getPool(String poolId) {
        return poolEntityToPool(poolRepository.findById(poolId).get());
    }

    @Override
    public List<Pool> getPools() {
        List<PoolEntity> poolEntities = (List<PoolEntity>) poolRepository.findAll();
        return poolEntities.stream().map(this::poolEntityToPool).collect(Collectors.toList());
    }

    @Override
    public Pool updatePool(PoolRest updatePool) {
        return null;
    }

    @Override
    public Pool deletePool(String UUID) {
        return null;
    }
}

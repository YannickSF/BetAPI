package com.cosmos.wibet.domain.services;

import com.cosmos.wibet.domain.model.enums.ResultEnum;
import com.cosmos.wibet.domain.model.enums.StateEnum;
import com.cosmos.wibet.persistence.entity.PoolEntity;
import com.cosmos.wibet.persistence.repository.PoolRepository;
import com.cosmos.wibet.domain.model.Pool;
import com.cosmos.wibet.rest.model.PoolRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PoolServiceImpl implements PoolService {

    @Autowired
    private PoolRepository poolRepository;


    public Pool poolEntityToPool(PoolEntity poolEntity) {
        final Pool pool = new Pool();

        pool.setId(UUID.fromString(poolEntity.getId()));
        pool.setTitle(poolEntity.getTitle());
        pool.setCote(poolEntity.getCote());
        pool.setResult(ResultEnum.fromCode(poolEntity.getResult()));
        pool.setState(StateEnum.fromCode(poolEntity.getState()));
        pool.setMatchId(UUID.fromString(poolEntity.getMatchId()));

        return pool;
    }

    public PoolEntity poolToPoolEntity(Pool pool) {
        final PoolEntity poolEntity = new PoolEntity();

        poolEntity.setId(pool.getId().toString());
        poolEntity.setTitle(pool.getTitle());
        poolEntity.setCote(pool.getCote());
        poolEntity.setResult(pool.getResult().toString());
        poolEntity.setState(pool.getState().toString());
        poolEntity.setMatchId(pool.getMatchId().toString());

        return poolEntity;
    }

    @Override
    public Pool createPool(PoolRest createPool) {
        Pool newPool = new Pool();
        newPool.setId(UUID.randomUUID());
        newPool.setTitle(createPool.getTitle());
        newPool.setCote(createPool.getCote());
        newPool.setResult(ResultEnum.NONE);
        newPool.setState(StateEnum.A_VENIR);
        newPool.setMatchId(UUID.fromString(createPool.getMatchId()));

        return poolEntityToPool(poolRepository.save(poolToPoolEntity(newPool)));
    }

    @Override
    public Pool getPool(String poolId) {
        return poolEntityToPool(poolRepository.findById(poolId).get());
    }

    public List<Pool> findPoolByMatchId(String matchId){
        return poolRepository.findByMatchId(matchId)
                .stream()
                .map(this::poolEntityToPool)
                .collect(Collectors.toList());
    }

    @Override
    public List<Pool> getPools() {
        List<PoolEntity> poolEntities = (List<PoolEntity>) poolRepository.findAll();
        return poolEntities.stream().map(this::poolEntityToPool).collect(Collectors.toList());
    }

    @Override
    public Pool updatePool(String poolId, PoolRest updatePool) {
        return null;
    }

    @Override
    public Pool deletePool(String UUID) {
        return null;
    }

    @Override
    public Pool closePool(String poolId) {
        Pool find = poolRepository.findById(poolId).map(this::poolEntityToPool).get();
        find.setState(StateEnum.CLOT);
        return poolEntityToPool(poolRepository.save(poolToPoolEntity(find)));
    }

    @Override
    public Pool endPool(String poolId) {
        Pool find = poolRepository.findById(poolId).map(this::poolEntityToPool).get();
        find.setState(StateEnum.TERMINE);
        return poolEntityToPool(poolRepository.save(poolToPoolEntity(find)));
    }
}

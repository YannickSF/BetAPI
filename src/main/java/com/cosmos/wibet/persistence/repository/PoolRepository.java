package com.cosmos.wibet.persistence.repository;

import com.cosmos.wibet.persistence.entity.PoolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoolRepository extends CrudRepository<PoolEntity, String> {

    List<PoolEntity> findByMatchId(String matchId);
}

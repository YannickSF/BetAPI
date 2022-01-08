package com.cosmos.wibet.persistence.repository;

import com.cosmos.wibet.persistence.entity.PoolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoolRepository extends CrudRepository<PoolEntity, String> {
}

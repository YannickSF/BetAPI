package com.cosmos.wibet.persistence.repository;

import com.cosmos.wibet.persistence.entity.BetEntity;
import com.cosmos.wibet.persistence.entity.PoolEntity;
import com.cosmos.wibet.services.model.Pool;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends CrudRepository<BetEntity, String> {

}

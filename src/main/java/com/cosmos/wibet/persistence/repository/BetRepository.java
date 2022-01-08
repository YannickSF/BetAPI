package com.cosmos.wibet.persistence.repository;

import com.cosmos.wibet.persistence.entity.BetEntity;
import com.cosmos.wibet.domain.model.Bet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends CrudRepository<BetEntity, String> {

    List<Bet> findByPoolId(String poolId);

    List<Bet> findByUserId(String userId);
}

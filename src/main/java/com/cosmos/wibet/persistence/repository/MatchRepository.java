package com.cosmos.wibet.persistence.repository;

import com.cosmos.wibet.persistence.entity.MatchEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface MatchRepository extends CrudRepository<MatchEntity, String> {

    Optional<MatchEntity> findById(final String id);

    ArrayList<MatchEntity> findAll();
}

package com.cosmos.wibet.persistence.repository;

import com.cosmos.wibet.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

    Optional<UserEntity> findByUsernameAndPassword(final String username, final String password);
}

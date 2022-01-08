package com.cosmos.wibet.domain.services;

import com.cosmos.wibet.domain.model.User;
import com.cosmos.wibet.rest.model.UserRest;

import java.util.List;

public interface UserService {

    public abstract User createUser(UserRest userRest);

    public abstract User getUser(UserRest userRest);

    public abstract List<User> getUsers();

    public abstract User updateUser(String userId, User updateUser);

    public abstract User deleteUser(String userId);
}

package com.cosmos.wibet.services.domain;

import com.cosmos.wibet.services.model.User;
import com.cosmos.wibet.services.rest.model.UserRest;

import java.util.List;

public interface UserService {

    public abstract User createUser(UserRest userRest);

    public abstract User getUser(UserRest userRest);

    public abstract List<User> getUsers();

    public abstract User updateUser(String userId, User updateUser);

    public abstract User deleteUser(String userId);
}

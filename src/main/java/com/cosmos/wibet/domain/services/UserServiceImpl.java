package com.cosmos.wibet.domain.services;

import com.cosmos.wibet.persistence.entity.UserEntity;
import com.cosmos.wibet.persistence.repository.UserRepository;
import com.cosmos.wibet.domain.model.enums.ProfilEnum;
import com.cosmos.wibet.domain.model.User;
import com.cosmos.wibet.rest.model.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User userEntityToUser(UserEntity userEntity){
        User user = new User();
        user.setId(UUID.fromString(userEntity.getId()));
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setMail(userEntity.getMail());
        user.setTokens(userEntity.getTokens());
        user.setProfilEnum(Objects.isNull(userEntity.getProfil()) ? null : ProfilEnum.fromCode(userEntity.getProfil()));

        return user;
    }

    public UserEntity userToUserEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId().toString());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setMail(user.getMail());
        userEntity.setTokens(user.getTokens());
        userEntity.setProfil(user.getProfilEnum().toString());

        return userEntity;
    }

    public User userRestToUser(UserRest userRest){
        User user = new User();
        user.setUsername(userRest.getUsername());
        user.setPassword(userRest.getPassword());
        user.setMail(userRest.getMail());
        return user;
    }

    @Override
    public User createUser(UserRest userRest) {
        User newUser = userRestToUser(userRest);
        newUser.setId(UUID.randomUUID());
        newUser.setProfilEnum(ProfilEnum.DEFAULT);
        newUser.setTokens(0);
        return userEntityToUser(userRepository.save(userToUserEntity(newUser)));
    }

    @Override
    public User getUser(UserRest userRest) {
        return userEntityToUser(userRepository.findByUsernameAndPassword(userRest.getUsername(), userRest.getPassword()).get());
    }

    @Override
    public List<User> getUsers() {
        List<UserEntity> userEntityList = (List<UserEntity>) userRepository.findAll();
        return userEntityList.stream().map(this::userEntityToUser).collect(Collectors.toList());
    }

    @Override
    public User updateUser(String userId, User updateUser) {
        return null;
    }

    @Override
    public User deleteUser(String userId) {
        return null;
    }
}

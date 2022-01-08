package com.cosmos.wibet.services.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserRest {

    private String username;
    private String password;
    private String mail;
}

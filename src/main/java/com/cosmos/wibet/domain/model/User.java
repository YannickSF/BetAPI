package com.cosmos.wibet.domain.model;

import com.cosmos.wibet.domain.model.enums.ProfilEnum;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@Data
public class User {

    private UUID id;
    private String username;
    private String password;
    private String mail;
    private Integer tokens;
    private ProfilEnum profilEnum;

}

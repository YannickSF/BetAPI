package com.cosmos.wibet.services.model;

import com.cosmos.wibet.services.model.enums.ProfilEnum;
import lombok.*;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
public class User {

    private UUID id;
    private String username;
    private String password;
    private String mail;
    private Integer tokens;
    private List<Bet> bets;
    private ProfilEnum profilEnum;

}

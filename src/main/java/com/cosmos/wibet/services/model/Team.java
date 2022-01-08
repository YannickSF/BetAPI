package com.cosmos.wibet.services.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
public class Team {

    private UUID id;
    private String name;
}

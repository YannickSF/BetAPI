package com.cosmos.wibet.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
public class Team {

    private UUID id;
    private String name;
}

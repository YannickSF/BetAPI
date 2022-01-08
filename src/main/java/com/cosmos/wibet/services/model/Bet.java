package com.cosmos.wibet.services.model;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@Data
public class Bet {

    private UUID id;
    private UUID userId;
    private Integer cote;
    private Integer value;
    private UUID poolId;
}

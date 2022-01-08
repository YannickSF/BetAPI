package com.cosmos.wibet.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BetRest {

    private String userId;
    private Integer cote;
    private Integer value;
    private String poolId;
}

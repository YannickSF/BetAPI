package com.cosmos.wibet.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MatchRest {

    private String title;
    private String playDate;
    private String endDate;
    private String teamOne;
    private String teamTwo;
}

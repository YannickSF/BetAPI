package com.cosmos.wibet.domain.model;

import com.cosmos.wibet.domain.model.enums.ResultEnum;
import com.cosmos.wibet.domain.model.enums.StateEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
public class Pool {

    private UUID id;
    private String title;
    private Integer cote;
    private ResultEnum result;
    private StateEnum state;
    private UUID matchId;

}

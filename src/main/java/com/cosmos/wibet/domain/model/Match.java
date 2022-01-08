package com.cosmos.wibet.domain.model;

import com.cosmos.wibet.domain.model.enums.StateEnum;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Data
public class Match {

    private UUID id;
    private String title;
    private LocalDate dateCreation;
    private LocalDateTime playDate;
    private LocalDateTime endDate;
    private String teamOne;
    private String teamTwo;
    private StateEnum state;
}

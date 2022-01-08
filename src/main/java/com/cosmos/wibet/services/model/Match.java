package com.cosmos.wibet.services.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
public class Match {

    private UUID id;
    private String title;
    private LocalDate dateCreation;
    private LocalDateTime playDate;
    private LocalDateTime endDate;
    private List<Team> teams;
    private List<Pool> pools;
}

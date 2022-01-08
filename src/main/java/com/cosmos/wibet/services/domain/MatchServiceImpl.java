package com.cosmos.wibet.services.domain;

import com.cosmos.wibet.persistence.entity.MatchEntity;
import com.cosmos.wibet.persistence.repository.MatchRepository;
import com.cosmos.wibet.services.model.Bet;
import com.cosmos.wibet.services.model.Match;
import com.cosmos.wibet.services.model.Team;
import com.cosmos.wibet.services.rest.model.MatchRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public Team stringToTeams(String team){
        return new Team();
    }

    public MatchEntity matchToMatchEntity(Match match){
        MatchEntity retour = new MatchEntity();
        retour.setId(match.getId().toString());
        retour.setTitle(match.getTitle());
        retour.setDateCreation(match.getDateCreation().toString());
        retour.setPlayDate(match.getPlayDate().toString());
        retour.setEndDate(match.getEndDate().toString());
        return retour;
    }

    public Match matchEntityToMatch(MatchEntity matchEntity){
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Match retour = new Match();
        retour.setId(UUID.fromString(matchEntity.getId()));
        retour.setTitle(matchEntity.getTitle());
        retour.setDateCreation(LocalDate.parse(matchEntity.getDateCreation(), formatterDate));
        retour.setPlayDate(LocalDateTime.parse(matchEntity.getPlayDate()));
        retour.setEndDate(LocalDateTime.parse(matchEntity.getEndDate()));
        return retour;
    }

    @Override
    public Match createMatch(MatchRest matchRest) {
        DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        Match match = new Match();
        match.setId(UUID.randomUUID());
        match.setTitle(matchRest.getTitle());
        match.setDateCreation(LocalDate.now());
        match.setPlayDate(LocalDateTime.parse(matchRest.getPlayDate(), formatterDateTime));
        match.setEndDate(LocalDateTime.parse(matchRest.getEndDate(), formatterDateTime));

        return matchEntityToMatch(matchRepository.save(matchToMatchEntity(match)));
    }

    @Override
    public Match getMatch(String matchId) {
        return matchRepository.findById(matchId).isEmpty() ?
                null : matchEntityToMatch(matchRepository.findById(matchId).get());
    }

    @Override
    public List<Match> getMatchs() {
        ArrayList<MatchEntity> matchEntityList = matchRepository.findAll();
        return matchEntityList.stream().map(this::matchEntityToMatch).collect(Collectors.toList());
    }

    @Override
    public Match updateMatch(String matchId, Match updateMatch) {
        return null;
    }

    @Override
    public Match deleteMatch(String matchId) {
        return null;
    }
}

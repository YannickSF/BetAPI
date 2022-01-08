package com.cosmos.wibet.domain.services;

import com.cosmos.wibet.domain.model.Pool;
import com.cosmos.wibet.domain.model.enums.StateEnum;
import com.cosmos.wibet.persistence.entity.MatchEntity;
import com.cosmos.wibet.persistence.repository.MatchRepository;
import com.cosmos.wibet.domain.model.Match;
import com.cosmos.wibet.rest.model.MatchRest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PoolService poolService;

    public MatchEntity matchToMatchEntity(Match match){
        MatchEntity retour = new MatchEntity();

        retour.setId(match.getId().toString());
        retour.setTitle(match.getTitle());
        retour.setDateCreation(match.getDateCreation().toString());
        retour.setPlayDate(match.getPlayDate().toString());
        retour.setEndDate(match.getEndDate().toString());
        retour.setTeamOne(match.getTeamOne());
        retour.setTeamTwo(match.getTeamTwo());
        retour.setState(match.getState().toString());
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
        retour.setTeamOne(matchEntity.getTeamOne());
        retour.setTeamTwo(matchEntity.getTeamTwo());
        retour.setState(StateEnum.fromCode(matchEntity.getState()));
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
        match.setTeamOne(matchRest.getTeamOne());
        match.setTeamTwo(matchRest.getTeamTwo());
        match.setState(StateEnum.A_VENIR);

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
    public Match updateMatch(String matchId, MatchRest updateMatch) {
        DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Match find = matchRepository.findById(matchId).map(this::matchEntityToMatch).get();

        find.setTitle(Objects.isNull(updateMatch.getTitle()) ? find.getTitle() : updateMatch.getTitle());
        find.setPlayDate(Objects.isNull(updateMatch.getPlayDate()) ? find.getPlayDate() : LocalDateTime.parse(updateMatch.getPlayDate(), formatterDateTime));
        find.setEndDate(Objects.isNull(updateMatch.getEndDate()) ? find.getEndDate() : LocalDateTime.parse(updateMatch.getEndDate(), formatterDateTime));
        find.setTeamOne(Objects.isNull(updateMatch.getTeamOne()) ? find.getTeamOne() : updateMatch.getTeamOne());
        find.setTeamTwo(Objects.isNull(updateMatch.getTeamTwo()) ? find.getTeamTwo() : updateMatch.getTeamTwo());

        return matchEntityToMatch(matchRepository.save(matchToMatchEntity(find)));
    }

    @Override
    public Match deleteMatch(String matchId) {
        return null;
    }

    @Override
    public Match closeMatch(String matchId) {
        List<Pool> poolList = poolService.findPoolByMatchId(matchId);
        poolList.forEach(pool -> poolService.closePool(pool.getId().toString()));
        Match find = matchRepository.findById(matchId).map(this::matchEntityToMatch).get();
        find.setState(StateEnum.CLOT);
        return matchEntityToMatch(matchRepository.save(matchToMatchEntity(find)));
    }

    @Override
    public Match endMatch(String matchId) {
        List<Pool> poolList = poolService.findPoolByMatchId(matchId);
        poolList.forEach(pool -> poolService.endPool(pool.getId().toString()));
        Match find = matchRepository.findById(matchId).map(this::matchEntityToMatch).get();
        find.setState(StateEnum.TERMINE);
        return matchEntityToMatch(matchRepository.save(matchToMatchEntity(find)));
    }
}

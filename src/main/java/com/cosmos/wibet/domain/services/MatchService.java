package com.cosmos.wibet.domain.services;

import com.cosmos.wibet.domain.model.Match;
import com.cosmos.wibet.rest.model.MatchRest;

import java.util.List;

public interface MatchService {

    public abstract Match createMatch(MatchRest matchRest);

    public abstract Match getMatch(String matchId);

    public abstract List<Match> getMatchs();

    public abstract Match updateMatch(String matchId, MatchRest updateMatch);

    public abstract Match deleteMatch(String matchId);

    public abstract Match closeMatch(String matchId);

    public abstract Match endMatch(String matchId);
}

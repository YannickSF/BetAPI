package com.cosmos.wibet.services.domain;

import com.cosmos.wibet.services.model.Match;
import com.cosmos.wibet.services.rest.model.MatchRest;

import java.util.List;

public interface MatchService {

    public abstract Match createMatch(MatchRest matchRest);

    public abstract Match getMatch(String matchId);

    public abstract List<Match> getMatchs();

    public abstract Match updateMatch(String matchId, Match updateMatch);

    public abstract Match deleteMatch(String matchId);
}

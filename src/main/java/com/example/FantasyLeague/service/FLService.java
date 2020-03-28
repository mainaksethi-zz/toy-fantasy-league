package com.example.FantasyLeague.service;


import com.example.FantasyLeague.dtos.Cab;
import com.example.FantasyLeague.dtos.Location;
import com.example.FantasyLeague.dtos.request.BuildTeamRequestDto;
import com.example.FantasyLeague.dtos.request.MatchEndRequestDto;
import com.example.FantasyLeague.dtos.request.StartMatchRequestDto;
import com.example.FantasyLeague.dtos.response.StartMatchResponseDto;
import com.example.FantasyLeague.exception.FLException;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;

import java.util.List;

public interface FLService {
    void endMatch(MatchEndRequestDto matchEndRequestDto);

    StartMatchResponseDto startMatch(StartMatchRequestDto match);

    void buildTeam(BuildTeamRequestDto buildTeamDto) throws FLException;

    Integer getPoints(Integer playerId, Integer matchId);
}

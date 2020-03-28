package com.example.FantasyLeague.repository;

import com.example.FantasyLeague.dtos.request.BuildTeamRequestDto;
import com.example.FantasyLeague.dtos.request.MatchEndRequestDto;
import com.example.FantasyLeague.dtos.request.StartMatchRequestDto;
import com.example.FantasyLeague.dtos.response.StartMatchResponseDto;
import com.example.FantasyLeague.entities.Cricketer;

import java.util.List;

public interface FLRepository {

    void endMatch(MatchEndRequestDto matchEndRequestDto);

    StartMatchResponseDto startMatch(StartMatchRequestDto match);

    List<Cricketer> getCricketerList(List<Integer> cricketerList);

    void buildTeam(BuildTeamRequestDto buildTeamDto);

    Integer getPoints(Integer playerId, Integer matchId);
}

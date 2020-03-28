package com.example.FantasyLeague.service.impl;

import com.example.FantasyLeague.dtos.Cab;
import com.example.FantasyLeague.dtos.Driver;
import com.example.FantasyLeague.dtos.Location;
import com.example.FantasyLeague.dtos.request.BuildTeamRequestDto;
import com.example.FantasyLeague.dtos.request.MatchEndRequestDto;
import com.example.FantasyLeague.dtos.request.StartMatchRequestDto;
import com.example.FantasyLeague.dtos.response.StartMatchResponseDto;
import com.example.FantasyLeague.entities.Cricketer;
import com.example.FantasyLeague.exception.FLException;
import com.example.FantasyLeague.repository.FLRepository;
import com.example.FantasyLeague.service.FLService;
import com.example.FantasyLeague.service.TeamValidationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FLServiceImpl implements FLService {

    @Autowired
    private TeamValidationStrategy teamValidationStrategy;

    @Autowired
    private FLRepository flRepository;

    @Override
    public void endMatch(MatchEndRequestDto matchEndRequestDto) {
        flRepository.endMatch(matchEndRequestDto);
    }

    @Override
    public StartMatchResponseDto startMatch(StartMatchRequestDto match) {
        return flRepository.startMatch(match);
    }

    @Override
    public void buildTeam(BuildTeamRequestDto buildTeamDto) throws FLException {
        List<Cricketer> cricketerList = flRepository.getCricketerList(buildTeamDto.getCricketerList());

        teamValidationStrategy.validateTeam(cricketerList);

        flRepository.buildTeam(buildTeamDto);
    }

    @Override
    public Integer getPoints(Integer playerId, Integer matchId) {
        return flRepository.getPoints(playerId, matchId);
    }
}

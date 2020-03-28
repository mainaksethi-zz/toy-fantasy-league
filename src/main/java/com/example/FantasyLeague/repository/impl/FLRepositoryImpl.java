package com.example.FantasyLeague.repository.impl;

import com.example.FantasyLeague.dtos.request.BuildTeamRequestDto;
import com.example.FantasyLeague.dtos.request.MatchEndRequestDto;
import com.example.FantasyLeague.dtos.request.StartMatchRequestDto;
import com.example.FantasyLeague.dtos.response.StartMatchResponseDto;
import com.example.FantasyLeague.entities.Cricketer;
import com.example.FantasyLeague.entities.CricketerType;
import com.example.FantasyLeague.repository.FLRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class FLRepositoryImpl implements FLRepository {

    //Static cricketer list.
    private Map<Integer, Cricketer> cricketerMap = new HashMap<Integer, Cricketer>() {{
        put(1, new Cricketer(1, CricketerType.BATSMAN));
    }};

    private Map<Integer, Map<Integer, Integer>> matchCricketerScore = new HashMap<>();

    private Map<Integer, Map<Integer, Integer>> playerScore = new HashMap<>();

    private Map<Integer, Map<Integer, List<Integer> >> playerTeam = new HashMap<>();


    @Override
    public void endMatch(MatchEndRequestDto matchEndRequestDto) {
        Integer matchId = matchEndRequestDto.getId();
        matchCricketerScore.put(matchId, matchEndRequestDto.getCricketerScore());
    }

    @Override
    public StartMatchResponseDto startMatch(StartMatchRequestDto match) {
        Integer matchId = new Random().nextInt();
        matchCricketerScore.put(matchId, new HashMap<>());
        playerScore.put(matchId, new HashMap<>());
        playerTeam.put(matchId, new HashMap<>());
        return new StartMatchResponseDto(matchId, match.getPlace());
    }

    @Override
    public List<Cricketer> getCricketerList(List<Integer> cricketerList) {
        return cricketerList.stream().map(id -> cricketerMap.get(id)).collect(Collectors.toList());
    }

    @Override
    public void buildTeam(BuildTeamRequestDto buildTeamDto) {
        Integer matchId = buildTeamDto.getMatchId();

        Integer playerId = buildTeamDto.getPlayerId();

        List<Integer> cricketerList = buildTeamDto.getCricketerList();

        Map<Integer, List<Integer>> playerTeamMap = playerTeam.getOrDefault(matchId, new HashMap<>());
        playerTeamMap.put(playerId, cricketerList);
        playerTeam.put(matchId, playerTeamMap);
    }

    @Override
    public Integer getPoints(Integer playerId, Integer matchId) {
        if (playerScore.get(matchId).get(playerId) != null) {
            return playerScore.get(matchId).get(playerId);
        }
        Integer score = playerTeam.get(matchId).get(playerId).stream().reduce(0, (sum, cricketerId) -> sum + playerScore.get(matchId).get(cricketerId));
        playerScore.get(matchId).put(playerId, score);
        return playerScore.get(matchId).get(playerId);
    }
}

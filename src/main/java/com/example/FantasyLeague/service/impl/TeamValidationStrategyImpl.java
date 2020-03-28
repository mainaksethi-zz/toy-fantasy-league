package com.example.FantasyLeague.service.impl;

import com.example.FantasyLeague.entities.Cricketer;
import com.example.FantasyLeague.entities.CricketerType;
import com.example.FantasyLeague.exception.FLException;
import com.example.FantasyLeague.exception.InvalidTeamException;
import com.example.FantasyLeague.service.TeamValidationStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TeamValidationStrategyImpl implements TeamValidationStrategy {

    private final Map<CricketerType, Long> playerCountMinLimit = new HashMap<CricketerType, Long>() {{
        put(CricketerType.BATSMAN, 3L);
        put(CricketerType.BOWLER, 3L);
        put(CricketerType.KEEPER, 1L);
    }};

    @Override
    public Boolean validateTeam(List<Cricketer> playerList) throws FLException {
        if (playerList.size() > 11) throw new InvalidTeamException("Total player should be below 11.");
        Map<CricketerType, Long> playerTypeCountMap = playerList.stream().collect(Collectors.groupingBy(Cricketer::getCricketerType, Collectors.counting()));

        if (playerCountMinLimit.get(CricketerType.BATSMAN) == null || playerTypeCountMap.get(CricketerType.BATSMAN) < playerCountMinLimit.get(CricketerType.BATSMAN)) {
            throw new InvalidTeamException(CricketerType.BATSMAN + " count should be atLeast " + playerCountMinLimit.get(CricketerType.BATSMAN));
        }

        if (playerCountMinLimit.get(CricketerType.BOWLER) == null || playerTypeCountMap.get(CricketerType.BOWLER) < playerCountMinLimit.get(CricketerType.BOWLER)) {
            throw new InvalidTeamException(CricketerType.BOWLER + " count should be atLeast " + playerCountMinLimit.get(CricketerType.BOWLER));
        }

        if (playerCountMinLimit.get(CricketerType.KEEPER) == null || playerTypeCountMap.get(CricketerType.KEEPER) < playerCountMinLimit.get(CricketerType.KEEPER)) {
            throw new InvalidTeamException(CricketerType.KEEPER + " count should be atLeast " + playerCountMinLimit.get(CricketerType.KEEPER));
        }
        return true;
    }
}

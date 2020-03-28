package com.example.FantasyLeague.dtos.request;

import lombok.Data;

import java.util.List;

@Data
public class BuildTeamRequestDto {

    private Integer matchId;

    private Integer playerId;

    private List<Integer> cricketerList;
}

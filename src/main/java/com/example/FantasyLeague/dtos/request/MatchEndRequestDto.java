package com.example.FantasyLeague.dtos.request;

import lombok.Data;

import java.util.Map;

@Data
public class MatchEndRequestDto {

    private Integer id;

    private Map<Integer, Integer> cricketerScore;
}

package com.example.FantasyLeague.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cricketer {

    private Integer id;

    private CricketerType cricketerType;
}

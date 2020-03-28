package com.example.FantasyLeague.dtos;

import lombok.Data;

@Data
public class Cab {

    private final String id;

    private final String colour;

    private final String number;

    private final Location location;

    private final Driver driver;
}

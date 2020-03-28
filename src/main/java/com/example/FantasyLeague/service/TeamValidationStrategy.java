package com.example.FantasyLeague.service;

import com.example.FantasyLeague.entities.Cricketer;
import com.example.FantasyLeague.exception.FLException;

import java.util.List;

public interface TeamValidationStrategy {

    Boolean validateTeam(List<Cricketer> playerList) throws FLException;
}

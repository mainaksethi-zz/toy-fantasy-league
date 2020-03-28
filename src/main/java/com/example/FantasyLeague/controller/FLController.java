package com.example.FantasyLeague.controller;

import com.example.FantasyLeague.dtos.request.BuildTeamRequestDto;
import com.example.FantasyLeague.dtos.request.MatchEndRequestDto;
import com.example.FantasyLeague.dtos.request.StartMatchRequestDto;
import com.example.FantasyLeague.dtos.response.StartMatchResponseDto;
import com.example.FantasyLeague.exception.FLException;
import com.example.FantasyLeague.service.FLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fl")
public class FLController {

    @Autowired
    private FLService flService;

    @RequestMapping(value = "/match/end", method = RequestMethod.POST)
    public void endMatch(@RequestBody MatchEndRequestDto matchEndRequestDto) {
        flService.endMatch(matchEndRequestDto);
    }

    @RequestMapping(value = "/match/start", method = RequestMethod.POST)
    public StartMatchResponseDto startMatch(@RequestBody StartMatchRequestDto match) {
        return flService.startMatch(match);
    }

    @RequestMapping(value = "/build", method = RequestMethod.POST)
    public void buildTeam(@RequestBody BuildTeamRequestDto buildTeamDto) throws FLException {
        flService.buildTeam(buildTeamDto);
    }

    @RequestMapping(value = "/player/points", method = RequestMethod.GET)
    public Integer getPoints(@RequestParam("playerId")Integer playerId, @RequestParam("matchId") Integer matchId) {
        return flService.getPoints(playerId, matchId);
    }


//    @RequestMapping(value = "/team/add", method = RequestMethod.POST)
//    public String addTeamPlayer(@RequestBody AddTeamDto buildTeamDto) {
//        return "Hello World";
//    }
//
//    @RequestMapping(value = "/team/remove", method = RequestMethod.POST)
//    public String removeTeamPlayer(@RequestBody RemoveTeamDto buildTeamDto) {
//        return "Hello World";
//    }

}

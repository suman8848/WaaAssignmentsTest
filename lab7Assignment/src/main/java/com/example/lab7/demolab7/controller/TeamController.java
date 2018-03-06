package com.example.lab7.demolab7.controller;

import com.example.lab7.demolab7.dao.TeamDao;
import com.example.lab7.demolab7.entity.Team;
import com.example.lab7.demolab7.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeamController {

    @Autowired
    TeamService teamService;

    @RequestMapping("/teams")
    public String getTeams( Model model) {

        model.addAttribute("teams", teamService.getAllTeams());
        return "teamlist";
    }


    @RequestMapping(value = "/teams/addTeam", method = RequestMethod.GET)
    public String addTeams(Model model, @ModelAttribute("team") Team team) {
        return "addteam";
    }


}

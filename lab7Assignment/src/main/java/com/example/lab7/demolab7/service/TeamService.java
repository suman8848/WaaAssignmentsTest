package com.example.lab7.demolab7.service;

import com.example.lab7.demolab7.dao.TeamDao;
import com.example.lab7.demolab7.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TeamService {
    @Autowired
    TeamDao teamDao;

    public Collection getAllTeams(){
        System.out.println("TeamList...."+teamDao.getAll().size());
        return teamDao.getAll();
    }

    public void addTeam(Team team){
        teamDao.add(team);
    }

    public Team get(int teamKey){
        return teamDao.get(teamKey);
    }

    public void update(int id, Team team) {
        teamDao.update(id,team);
    }

    public void delete(int bookId) {
        teamDao.delete(bookId);
    }
}

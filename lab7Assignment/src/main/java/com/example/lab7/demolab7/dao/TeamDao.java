package com.example.lab7.demolab7.dao;

import com.example.lab7.demolab7.NoSuchResourceException;
import com.example.lab7.demolab7.entity.Match;
import com.example.lab7.demolab7.entity.Player;
import com.example.lab7.demolab7.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TeamDao {

    private static int teamKey = 1;
    private Map<Integer, Team> teamIds = new HashMap<>();
    private List<Player> players = new ArrayList<>();
//    private List<Match> matchesAtHome = new ArrayList<>();
//    private List<Match> matchesAtVisit = new ArrayList<>();




    public TeamDao() {
//       players= addPlayers();
        add(new Team(1,"Arsenal","London","arsenal", players,"Red","Yellow"));
//        add(new Team("C#","1002","Suman",2000));
    }

//    private List<Player> addPlayers() {
//        List<Player> tempPlayer =
//        return
//    }


    public List<Team> getAll() {

        return new ArrayList<Team>(teamIds.values());
    }

    public void add(Team teamId) {
        teamId.setTeamKey(teamKey);
        teamIds.put(teamKey, teamId);
        teamKey++;
    }

    public Team get(int id) {
        Team result = teamIds.get(id);

        if (result == null) {
            throw new NoSuchResourceException("Team", id);
        }

        return result;
    }

    public void update(int teamId, Team team) {
        System.out.println(teamId);
        teamIds.put(teamId, team);
    }


    public void delete(int teamId) {
        Team removed = teamIds.remove(teamId);
        if (removed == null) {
            throw new NoSuchResourceException("Team", teamId);
        }
    }
}

package com.example.lab7.demolab7.entity;

import java.util.List;

public class Team {

    private int teamKey;
    private String name;
    private String city;
    private String mascot;
    private List<Player> players;
    private String homeUniform;
    private String visitUniform;
    private List<Match> matchesAsHome;
    private List<Match> matchesAsVisitor;

    public Team() {
    }

    public Team(int teamKey, String name, String city, String mascot, List<Player> players, String homeUniform, String visitUniform){ //List<Match> matchesAsHome, List<Match> matchesAsVisitor) {
        this.teamKey = teamKey;
        this.name = name;
        this.city = city;
        this.mascot = mascot;
        this.players = players;
        this.homeUniform = homeUniform;
        this.visitUniform = visitUniform;
//        this.matchesAsHome = matchesAsHome;
//        this.matchesAsVisitor = matchesAsVisitor;
    }

    public int getTeamKey() {
        return teamKey;
    }

    public void setTeamKey(int teamKey) {
        this.teamKey = teamKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getHomeUniform() {
        return homeUniform;
    }

    public void setHomeUniform(String homeUniform) {
        this.homeUniform = homeUniform;
    }

    public String getVisitUniform() {
        return visitUniform;
    }

    public void setVisitUniform(String visitUniform) {
        this.visitUniform = visitUniform;
    }

    public List<Match> getMatchesAsHome() {
        return matchesAsHome;
    }

    public void setMatchesAsHome(List<Match> matchesAsHome) {
        this.matchesAsHome = matchesAsHome;
    }

    public List<Match> getMatchesAsVisitor() {
        return matchesAsVisitor;
    }

    public void setMatchesAsVisitor(List<Match> matchesAsVisitor) {
        this.matchesAsVisitor = matchesAsVisitor;
    }

//    @Override
//    public String toString() {
//        return "Team{" +
//                "teamKey=" + teamKey +
//                ", name='" + name + '\'' +
//                ", city='" + city + '\'' +
//                ", mascot='" + mascot + '\'' +
//                ", players=" + players +
//                ", homeUniform='" + homeUniform + '\'' +
//                ", visitUniform='" + visitUniform + '\'' +
//                ", matchesAsHome=" + matchesAsHome +
//                ", matchesAsVisitor=" + matchesAsVisitor +
//                '}';
//    }
}

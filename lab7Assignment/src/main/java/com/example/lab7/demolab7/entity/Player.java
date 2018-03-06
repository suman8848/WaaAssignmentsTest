package com.example.lab7.demolab7.entity;

public class Player {
    private int playerId;
    private String firstName;
    private String lastName;
    private int teamKey;

    public int getTeamKey() {
        return teamKey;
    }

    public void setTeamKey(int teamKey) {
        this.teamKey = teamKey;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

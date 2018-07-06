package com.shaked.survivor;

import java.util.ArrayList;

public class Game {
    private ArrayList<Contestant> players;
    private ArrayList<Tribe> tribes;
    public Game()
    {
        this.players = new ArrayList<Contestant>();
        this.tribes = new ArrayList<Tribe>();
    }
    public void addPlayer(Contestant contestant)
    {
        this.players.add(contestant);
    }
    public void addTribe(Tribe tribe)
    {
        this.tribes.add(tribe);
    }
    public void addPlayerToATribe(Contestant player, Tribe tribe)
    {
        player.setTribeName(tribe.getName());
        tribe.addTribeMate(player);
    }

    public ArrayList<Contestant> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Contestant> players) {
        this.players = players;
    }

    public ArrayList<Tribe> getTribes() {
        return tribes;
    }

    public void setTribes(ArrayList<Tribe> tribes) {
        this.tribes = tribes;
    }

    @Override
    public String toString() {
        return "Game{" +
                "players=" + players +
                ", tribes=" + tribes +
                '}';
    }
}

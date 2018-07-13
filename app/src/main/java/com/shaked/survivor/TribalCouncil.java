package com.shaked.survivor;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TribalCouncil {
    private Tribe tribe;
    private ArrayList<Contestant> votesList;
    private ArrayList<Contestant> totalVotes; //List of all the tribe members names, every player has extra votes depending on their GamePlay Points and Social Game Points.
    private ArrayList<Contestant> revote; //If there is a tie, there will be a revote, the tied players won't be able to vote.
    private Boolean isFireChallenge;
    private Contestant evictedPlayer;
    public TribalCouncil(Tribe tribe)
    {
        this.tribe = tribe;
        this.votesList = new ArrayList<Contestant>();
        this.totalVotes = new ArrayList<Contestant>();
        this.revote = new ArrayList<Contestant>();
        isFireChallenge = false;
        this.evictedPlayer = null;
    }

    public Tribe getTribe() {
        return tribe;
    }

    public ArrayList<Contestant> getVotesList() {
        return votesList;
    }

    public ArrayList<Contestant> getTotalVotes() {
        return totalVotes;
    }

    public Contestant getEvictedPlayer() {
        return evictedPlayer;
    }

    public void voteTime()
    {
        ArrayList<Contestant> tribeMembers = new ArrayList<Contestant>();
        for(Integer i = 0; i<this.tribe.getTribeMatesList().size();i++)
            tribeMembers.add(this.tribe.getTribeMatesList().get(i));
        setTotalVotes();
        for(Integer i = 0; i<tribe.getNumberOfTribeMates();i++)
        {
            Contestant vote;
            Random random = new Random();
            ArrayList<Contestant> temp = new ArrayList<Contestant>();
            for(Integer t = 0; t<this.totalVotes.size();t++)
                if(!this.totalVotes.get(t).getId().equals(tribeMembers.get(i).getId()))
                    temp.add(this.totalVotes.get(t));
            Integer rand = random.nextInt(temp.size());
            vote = temp.get(rand);
            this.votesList.add(vote);
        }
        sortVotes(false);

    }
    public void sortVotes(boolean isrevote)
    {
        if(isrevote)
        {
            ArrayList<Contestant> sortedVotes = new ArrayList<Contestant>();
            ArrayList<Contestant> playersWithMostVotes = new ArrayList<Contestant>();
            playersWithMostVotes.add(this.revote.get(0));
            Integer mostVotes = this.countVotesForPlayer(playersWithMostVotes.get(0),true);
            ArrayList<Contestant> temp = new ArrayList<Contestant>();
            for (Integer i = 0; i < this.revote.size(); i++)
                temp.add(this.revote.get(i));
            for (Integer i = 0; i < temp.size(); i++) {
                if (!sortedVotes.contains(temp.get(i))) {
                    if (this.countVotesForPlayer(temp.get(i),true) == mostVotes)
                        if (!playersWithMostVotes.contains(temp.get(i)))
                            playersWithMostVotes.add(temp.get(i));
                    if (this.countVotesForPlayer(temp.get(i),true) > mostVotes) {
                        for (Integer t = 0; t < playersWithMostVotes.size(); t++)
                            for (Integer s = 0; s < mostVotes; s++)
                                sortedVotes.add(playersWithMostVotes.get(t));

                        playersWithMostVotes.clear();
                        playersWithMostVotes.add(temp.get(i));
                        mostVotes = countVotesForPlayer(temp.get(i),true);
                    }
                    if (this.countVotesForPlayer(temp.get(i),true) < mostVotes)
                        for (Integer t = 0; t < countVotesForPlayer(temp.get(i),true); t++)
                            sortedVotes.add(temp.get(i));
                    ;
                }
            }
            for (Integer i = 0; i < playersWithMostVotes.size(); i++)
                for (Integer t = 0; t < mostVotes; t++)
                    sortedVotes.add(playersWithMostVotes.get(i));
            this.revote.clear();
            for (Integer i = 0; i < sortedVotes.size(); i++)
                this.revote.add(sortedVotes.get(i));
            if (playersWithMostVotes.size() == 1)
            {
                this.evictedPlayer = playersWithMostVotes.get(0);
                this.evictedPlayer.setAlive(false);
                this.evictedPlayer.setTribeName("No Tribe");
                this.tribe.getTribeMatesList().remove(this.evictedPlayer);
            }
            else
                fireChallenge(playersWithMostVotes);
        }
        else {
            ArrayList<Contestant> sortedVotes = new ArrayList<Contestant>();
            ArrayList<Contestant> playersWithMostVotes = new ArrayList<Contestant>();
            playersWithMostVotes.add(this.votesList.get(0));
            Integer mostVotes = this.countVotesForPlayer(playersWithMostVotes.get(0),false);
            ArrayList<Contestant> temp = new ArrayList<Contestant>();
            for (Integer i = 0; i < this.votesList.size(); i++)
                temp.add(this.votesList.get(i));
            for (Integer i = 0; i < temp.size(); i++) {
                if (!sortedVotes.contains(temp.get(i))) {
                    if (this.countVotesForPlayer(temp.get(i),false) == mostVotes)
                        if (!playersWithMostVotes.contains(temp.get(i)))
                            playersWithMostVotes.add(temp.get(i));
                    if (this.countVotesForPlayer(temp.get(i),false) > mostVotes) {
                        for (Integer t = 0; t < playersWithMostVotes.size(); t++)
                            for (Integer s = 0; s < mostVotes; s++)
                                sortedVotes.add(playersWithMostVotes.get(t));

                        playersWithMostVotes.clear();
                        playersWithMostVotes.add(temp.get(i));
                        mostVotes = countVotesForPlayer(temp.get(i),false);
                    }
                    if (this.countVotesForPlayer(temp.get(i),false) < mostVotes)
                        for (Integer t = 0; t < countVotesForPlayer(temp.get(i),false); t++)
                            sortedVotes.add(temp.get(i));
                    ;
                }
            }
            for (Integer i = 0; i < playersWithMostVotes.size(); i++)
                for (Integer t = 0; t < mostVotes; t++)
                    sortedVotes.add(playersWithMostVotes.get(i));
            this.votesList.clear();
            for (Integer i = 0; i < sortedVotes.size(); i++)
                this.votesList.add(sortedVotes.get(i));
            if (playersWithMostVotes.size() == 1)
            {
                this.evictedPlayer = playersWithMostVotes.get(0);
                this.evictedPlayer.setAlive(false);
                this.evictedPlayer.setTribeName("No Tribe");
                this.tribe.getTribeMatesList().remove(this.evictedPlayer);
            }
            else
                revoteTime(playersWithMostVotes);
        }
    }
     public void setTotalVotes()
    {
        ArrayList<Contestant> tribeMembers = new ArrayList<Contestant>();
        for(Integer i = 0; i<this.tribe.getTribeMatesList().size();i++)
            tribeMembers.add(this.tribe.getTribeMatesList().get(i));
        for(Integer i = 0; i<tribeMembers.size();i++)
        {
            Contestant x = tribeMembers.get(i);
            Integer SocialGame = x.getSocialGame();
            Integer GamePlay = x.getGameplay();
            Integer TotalVotes = ((10-(SocialGame+GamePlay)) / 2) + 1; //Each name appears x times according to the formula of [10-(socialgame+gameplay)]/2 +1 (a starter vote)
            for(Integer t = 0; t<TotalVotes;t++)
                this.totalVotes.add(x);
        }
    }
    public Integer countVotesForPlayer(Contestant player, boolean isRevote)
    {
        if(isRevote)
        {
            Integer counter = 0;
            for(Integer i =0;i<this.revote.size();i++)
                if(this.revote.get(i).equals(player))
                    counter++;
            return counter;
        }
        else
            {
            Integer counter = 0;
            for (Integer i = 0; i < this.votesList.size(); i++)
                if (this.votesList.get(i).equals(player))
                    counter++;
            return counter;
        }
    }
    public void revoteTime(ArrayList<Contestant> tiedPlayers)
    {
        ArrayList<Contestant> tribeMembers = new ArrayList<Contestant>();
        for(Integer i = 0; i<this.tribe.getTribeMatesList().size();i++)
            if(!tiedPlayers.contains(this.tribe.getTribeMatesList().get(i)))
                tribeMembers.add(this.tribe.getTribeMatesList().get(i));
        setTotalVotes();
        for(Integer i = 0; i<tribeMembers.size();i++)
        {
            Contestant vote;
            Random random = new Random();
            ArrayList<Contestant> temp = new ArrayList<Contestant>();
            for(Integer t = 0; t<this.totalVotes.size();t++)
                if(!tribeMembers.contains(this.totalVotes.get(t)))
                    temp.add(this.totalVotes.get(t));
            Integer rand = random.nextInt(temp.size());
            vote = temp.get(rand);
            this.revote.add(vote);
        }
        sortVotes(true);
    }
    public void fireChallenge(ArrayList<Contestant> tiedPlayers) //In a fire challenge everyone has an even chance of getting out.
    {
        Random random = new Random();
        this.evictedPlayer = tiedPlayers.get(random.nextInt(tiedPlayers.size()));
        this.evictedPlayer.setAlive(false);
        this.evictedPlayer.setTribeName("No Tribe");
        this.tribe.getTribeMatesList().remove(this.evictedPlayer);
        this.isFireChallenge = true;
    }

    public Boolean getFireChallenge() {
        return isFireChallenge;
    }

    public ArrayList<Contestant> getRevote() {
        return revote;
    }
}

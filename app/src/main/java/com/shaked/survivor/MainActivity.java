package com.shaked.survivor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Game game = new Game();
        Contestant Shaked = new Contestant("Shaked", "Shaked Shlosberg");
        Contestant Eli = new Contestant("Eli", "Eli Kozinetz");
        Contestant Ilan = new Contestant("Ilan", "Ilan Moshayev");
        Contestant May = new Contestant( "May" , "May Gurevich");
        Contestant Artemy = new Contestant("Artemy","Artemy Lemberg");
        Contestant Ruslan = new Contestant("Ruslan", "Ruslan Gareev");
        Contestant Vova = new Contestant("Vova", "Vova Truba");
        Contestant Rafi = new Contestant("Rafi", "Rafi Olaro");
        Contestant Ron = new Contestant("Ron", "Ron Katz");
        Contestant Mazal = new Contestant("Mazal", "Alex Mazal");
        Contestant Alex = new Contestant("Alex", "Alex Levin");
        Contestant Maxim = new Contestant("Maxim", "Maxim Ivanov");
        Tribe Fire = new Tribe("Fire Tribe");
        Tribe Water = new Tribe("Water Tribe");
        game.addPlayer(Shaked);
        game.addPlayer(Eli);
        game.addPlayer(Ilan);
        game.addPlayer(May);
        game.addPlayer(Artemy);
        game.addPlayer(Ruslan);
        game.addPlayer(Vova);
        game.addPlayer(Rafi);
        game.addPlayer(Ron);
        game.addPlayer(Mazal);
        game.addPlayer(Alex);
        game.addPlayer(Maxim);
        game.addTribe(Fire);
        game.addTribe(Water);
        game.addPlayerToATribe(Shaked,Water);
        game.addPlayerToATribe(Eli,Water);
        game.addPlayerToATribe(Ilan,Water);
        game.addPlayerToATribe(May,Water);
        game.addPlayerToATribe(Artemy,Water);
        game.addPlayerToATribe(Ruslan,Water);
        game.addPlayerToATribe(Vova,Fire);
        game.addPlayerToATribe(Rafi,Fire);
        game.addPlayerToATribe(Ron,Fire);
        game.addPlayerToATribe(Mazal,Fire);
        game.addPlayerToATribe(Alex,Fire);
        game.addPlayerToATribe(Maxim,Fire);
        TwoTribesChallenge challenge = new TwoTribesChallenge();
        challenge.startChallenge(Fire, Water);
        Log.d("data2", challenge.getType() + " Challenge has been chosen.");
        Log.d("data2", challenge.getWinnerTribe() + " wins immunity!");
        TribalCouncil tribal;
        if(challenge.getWinnerTribe().equals(Fire.getName()))
            tribal = new TribalCouncil(Water);
        else
            tribal = new TribalCouncil(Fire);
        tribal.voteTime();
        Log.d("data2", tribal.getTribe().getName() + " goes to tribal council.");
//        Log.d("data2", "I'll read the votes: ");
//        for(int i = 0; i < tribal.getVotesList().size();i++)
//        {
//            Log.d("data2", tribal.getVotesList().get(i).getName() + " "+Integer.toString(i+1));
//        }
//        Log.d("data2",tribal.getVotesList().toString());
//        tribal.sortVotes();
        Log.d("data2", "I'll read the votes: ");
        for(int i = 0; i < tribal.getVotesList().size();i++)
        {
            Log.d("data2", tribal.getVotesList().get(i).getName() +" "+ Integer.toString(i+1));
        }
        if(tribal.getRevote().size()!=0)
        {
           Log.d("data2", "there is a tie, we will go to revote.");
           Log.d("data2", "I'll read the votes: ");
           for(int i = 0; i < tribal.getRevote().size();i++)
           {
                Log.d("data2", tribal.getRevote().get(i).getName() +" "+ Integer.toString(i+1));
           }
           if(tribal.getFireChallenge())
           {
               Log.d("data2", "There is another tie, we will get to the fire challenge.");
               Log.d("data2", tribal.getEvictedPlayer().getName() + " couldn't make fire and is evicted from the game.");
           }
           else
               Log.d("data2", "After a revote, " + tribal.getEvictedPlayer().getName() + " is evicted from the game.");

        }
        else
            Log.d("data2", tribal.getEvictedPlayer().getName() + " is evicted from the game.");


    }
}

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
        Contestant Roie = new Contestant("Roie", "Roie Shlosberg");
        Contestant Almog = new Contestant("Almog", "Almog Shlosberg");
        Contestant Michael = new Contestant("Michael", "Michael Shlosberg");
        Tribe aloha = new Tribe("Aloha");
        Tribe booba = new Tribe("Booba");
        game.addPlayer(Shaked);
        game.addPlayer(Roie);
        game.addPlayer(Almog);
        game.addPlayer(Michael);
        game.addTribe(aloha);
        game.addTribe(booba);
        game.addPlayerToATribe(Shaked,aloha);
        game.addPlayerToATribe(Roie,booba);
        game.addPlayerToATribe(Almog,aloha);
        game.addPlayerToATribe(Michael,booba);
        Log.d("data2", "aloha s: " + aloha.getTotalStrengthPoints().toString());
        Log.d("data2", "aloha i: " +aloha.getTotalIntelligencePoints().toString());
        Log.d("data2", "aloha s&i: " +aloha.getTotalStrengthAndIntelligencePoints().toString());
        Log.d("data2", "booba s: " +booba.getTotalStrengthPoints().toString());
        Log.d("data2", "booba i: " +booba.getTotalIntelligencePoints().toString());
        Log.d("data2", "booba s&i: " +booba.getTotalStrengthAndIntelligencePoints().toString());
        TwoTribesChallenge challenge = new TwoTribesChallenge();
        Log.d("data2", "challenge info: " + challenge.getType());
        challenge.startChallenge(aloha, booba);
        Log.d("data2", "challenge info: " + challenge.getFirstTribePoints());
        Log.d("data2", "challenge info: " + challenge.getSecondTribePoints());
        Log.d("data2", "winner odds: " + challenge.getWinnerArrayList().toString());
        Log.d("data2", "winner is: " + challenge.getWinnerTribe());
    }
}

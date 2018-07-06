package com.shaked.survivor;

import java.util.ArrayList;
import java.util.Random;

public class TwoTribesChallenge {
    private Integer type; //0 = Strength Challenge, 1  = Intelligence Challenge, 2 = Strength & Intelligence Challenge
    private String winnerTribe;
    private Integer firstTribePoints;
    private Integer secondTribePoints;
    private ArrayList<String> winnerArrayList;
    public TwoTribesChallenge()
    {
        this.type = new Random().nextInt(3);
        this.winnerTribe = null;
        this.firstTribePoints = 0;
        this.secondTribePoints = 0;
        this.winnerArrayList = new ArrayList<String>();
    }
    public void startChallenge(Tribe firstTribe, Tribe secondTribe)
    {

        if(this.type == 0)
        {
            strengthChallenge(firstTribe,secondTribe);
        }
        if(this.type == 1)
        {
            intelligenceChallenge(firstTribe,secondTribe);
        }
        if(this.type == 2)
        {
            strengthAndIntelligenceChallenge(firstTribe,secondTribe);
        }
    }
    public void strengthChallenge(Tribe firstTribe, Tribe secondTribe)
    {
        this.firstTribePoints = firstTribe.getTotalStrengthPoints();
        this.secondTribePoints = secondTribe.getTotalStrengthPoints();
        finishChallenge(firstTribe.getName(),secondTribe.getName(),this.firstTribePoints,this.secondTribePoints);
    }
    public void intelligenceChallenge(Tribe firstTribe, Tribe secondTribe)
    {
        this.firstTribePoints = firstTribe.getTotalIntelligencePoints();
        this.secondTribePoints = secondTribe.getTotalIntelligencePoints();
        finishChallenge(firstTribe.getName(),secondTribe.getName(),this.firstTribePoints,this.secondTribePoints);
    }
    public void strengthAndIntelligenceChallenge(Tribe firstTribe, Tribe secondTribe)
    {
        this.firstTribePoints = firstTribe.getTotalStrengthAndIntelligencePoints();
        this.secondTribePoints = secondTribe.getTotalStrengthAndIntelligencePoints();
        finishChallenge(firstTribe.getName(),secondTribe.getName(),this.firstTribePoints,this.secondTribePoints);
    }
    public void finishChallenge(String tribe1,String tribe2, Integer odds1, Integer odds2)
    {
        ArrayList<String> winner = new ArrayList<String>();
        for(Integer i = 0; i<odds1;i++)
            winner.add(tribe1);
        for(Integer i = 0; i<odds2;i++)
            winner.add(tribe2);
        for(Integer i = 0; i<winner.size();i++)
            this.winnerArrayList.add(winner.get(i));

        Random random = new Random();
        this.winnerTribe = winner.get(random.nextInt(winner.size()));
    }

    public String getType() {
        if(this.type==0)
            return "Strength";
        if(this.type==1)
            return "Intelligence";
        else
            return"Strength and Intelligence";
    }

    public String getWinnerTribe() {
        return winnerTribe;
    }

    public Integer getFirstTribePoints() {
        return firstTribePoints;
    }

    public Integer getSecondTribePoints() {
        return secondTribePoints;
    }

    public ArrayList<String> getWinnerArrayList() {
        return winnerArrayList;
    }
}

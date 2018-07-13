package com.shaked.survivor;

import java.util.ArrayList;
import java.util.Random;

public class TwoTribesChallenge {
    private Integer type; //0 = Strength Challenge, 1  = Intelligence Challenge, 2 = Strength & Intelligence Challenge
    private String winnerTribe;
    private Integer firstTribePoints;
    private Integer secondTribePoints;
    private ArrayList<String> winnerArrayList;
    private ArrayList<Contestant> sittersArrayList;
    private String sittingTribe;
    public TwoTribesChallenge()
    {
        this.type = new Random().nextInt(3);
        this.winnerTribe = null;
        this.firstTribePoints = 0;
        this.secondTribePoints = 0;
        this.winnerArrayList = new ArrayList<String>();
        this.sittersArrayList = new ArrayList<Contestant>();
        this.sittingTribe = "None";
    }
    public void startChallenge(Tribe firstTribe, Tribe secondTribe)
    {
        whoSitsTheChallenge(firstTribe,secondTribe);
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
        if(this.sittingTribe.equals(firstTribe.getName()))
            for(Integer i = 0; i<this.sittersArrayList.size();i++)
                this.firstTribePoints = this.firstTribePoints-this.sittersArrayList.get(i).getStrength();
        if(this.sittingTribe.equals(secondTribe.getName()))
            for(Integer i = 0; i<this.sittersArrayList.size(); i++)
                this.secondTribePoints = this.secondTribePoints-this.sittersArrayList.get(i).getStrength();
        finishChallenge(firstTribe.getName(),secondTribe.getName(),this.firstTribePoints,this.secondTribePoints);
    }
    public void intelligenceChallenge(Tribe firstTribe, Tribe secondTribe)
    {
        this.firstTribePoints = firstTribe.getTotalIntelligencePoints();
        this.secondTribePoints = secondTribe.getTotalIntelligencePoints();
        if(this.sittingTribe.equals(firstTribe.getName()))
            for(Integer i = 0; i<this.sittersArrayList.size();i++)
                this.firstTribePoints = this.firstTribePoints-this.sittersArrayList.get(i).getIntellegence();
        if(this.sittingTribe.equals(secondTribe.getName()))
            for(Integer i = 0; i<this.sittersArrayList.size(); i++)
                this.secondTribePoints = this.secondTribePoints-this.sittersArrayList.get(i).getIntellegence();
        finishChallenge(firstTribe.getName(),secondTribe.getName(),this.firstTribePoints,this.secondTribePoints);
    }
    public void strengthAndIntelligenceChallenge(Tribe firstTribe, Tribe secondTribe)
    {
        this.firstTribePoints = firstTribe.getTotalStrengthAndIntelligencePoints();
        this.secondTribePoints = secondTribe.getTotalStrengthAndIntelligencePoints();
        if(this.sittingTribe.equals(firstTribe.getName()))
            for(Integer i = 0; i<this.sittersArrayList.size();i++)
                this.firstTribePoints = this.firstTribePoints-this.sittersArrayList.get(i).getStrengthAndIntelligence();
        if(this.sittingTribe.equals(secondTribe.getName()))
            for(Integer i = 0; i<this.sittersArrayList.size(); i++)
                this.secondTribePoints = this.secondTribePoints-this.sittersArrayList.get(i).getStrengthAndIntelligence();
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

    public ArrayList<Contestant> getSittersArrayList() {
        return sittersArrayList;
    }

    public String getSittingTribe() {
        return sittingTribe;
    }

    public void whoSitsTheChallenge(Tribe firstTribe, Tribe secondTribe)
    {
        Integer diff = firstTribe.getNumberOfTribeMates() - secondTribe.getNumberOfTribeMates();
        if(diff == 0)
            return;
        while(diff > 0 )
        {
            this.sittingTribe = firstTribe.getName();
            Random random = new Random();
            Contestant temp = firstTribe.getTribeMatesList().get(random.nextInt(firstTribe.getTribeMatesList().size()));
            if (!this.sittersArrayList.contains(temp))
            {
                this.sittersArrayList.add(temp);
                diff--;
            }
        }
        while (diff < 0)
        {
            this.sittingTribe = secondTribe.getName();
            Random random = new Random();
            Contestant temp = secondTribe.getTribeMatesList().get(random.nextInt(secondTribe.getTribeMatesList().size()));
            if(!this.sittersArrayList.contains(temp))
            {
                this.sittersArrayList.add(temp);
                diff++;
            }
        }
    }
}

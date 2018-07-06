package com.shaked.survivor;

import java.util.ArrayList;

public class Tribe {
    private String name;
    private ArrayList<Contestant> tribeMatesList;
    private ArrayList<Item> itemList;
    public Tribe(String name)
    {
        this.name = name;
        this.tribeMatesList = new ArrayList<Contestant>();
        this.itemList = new ArrayList<Item>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Contestant> getTribeMatesList() {
        return tribeMatesList;
    }

    public void setTribeMatesList(ArrayList<Contestant> tribeMatesList) {
        this.tribeMatesList = tribeMatesList;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public void addTribeMate(Contestant contestant)
    {
        this.tribeMatesList.add(contestant);
    }

    public Integer getTotalStrengthPoints()
    {
        Integer sum = 0;
        for(Integer i = 0; i<this.tribeMatesList.size();i++)
            if(this.tribeMatesList.get(i).getAlive()&&this.tribeMatesList.get(i).getTribeName().equals(this.name))
                sum+=this.tribeMatesList.get(i).getStrength();
        return sum;
    }
    public Integer getTotalIntelligencePoints()
    {
        Integer sum = 0;
        for(Integer i = 0; i<this.tribeMatesList.size();i++)
            if(this.tribeMatesList.get(i).getAlive()&&this.tribeMatesList.get(i).getTribeName().equals(this.name))
                sum+=this.tribeMatesList.get(i).getIntellegence();
        return sum;
    }
    public Integer getTotalStrengthAndIntelligencePoints()
    {
        return this.getTotalIntelligencePoints() + this.getTotalStrengthPoints();
    }

    public Integer getNumberOfTribeMates()
    {
        return this.tribeMatesList.size();
    }
    @Override
    public String toString() {
        return "Tribe{" +
                "name='" + name + '\'' +
                ", tribeMatesList=" + tribeMatesList +
                ", itemList=" + itemList +
                '}';
    }
}

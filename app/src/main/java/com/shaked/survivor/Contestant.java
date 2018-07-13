package com.shaked.survivor;

import java.util.ArrayList;
import java.util.UUID;

public class Contestant {
    private String name;
    private String fullName;
    private String id;
    private String tribeName;
    private ArrayList<Item> itemList;
    private Boolean isAlive;
    private Integer Place;
    private Integer strength;
    private Integer intellegence;
    private Integer gameplay;
    private Integer socialGame;

    public Contestant(String name, String fullName, String id, Integer strength, Integer intellegence, Integer gameplay, Integer socialGame) {
        this.name = name;
        this.fullName = fullName;
        this.id = id;
        this.tribeName = null;
        this.itemList = new ArrayList<Item>();
        this.isAlive = true;
        this.Place = null;
        this.strength = strength;
        this.intellegence = intellegence;
        this.gameplay = gameplay;
        this.socialGame = socialGame;
    }
    public Contestant(String name, String fullName) {
        this.name = name;
        this.fullName = fullName;
        this.id = UUID.randomUUID().toString();
        this.tribeName = null;
        this.itemList = new ArrayList<Item>();
        this.isAlive = true;
        this.Place = null;
        this.strength = (int)(Math.random()*5+1);
        this.intellegence = (int)(Math.random()*5+1);
        this.gameplay = (int)(Math.random()*5+1);
        this.socialGame = (int)(Math.random()*5+1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public Integer getPlace() {
        return Place;
    }

    public void setPlace(Integer place) {
        Place = place;
    }


    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getIntellegence() {
        return intellegence;
    }

    public void setIntellegence(Integer intellegence) {
        this.intellegence = intellegence;
    }

    public Integer getGameplay() {
        return gameplay;
    }

    public void setGameplay(Integer gameplay) {
        this.gameplay = gameplay;
    }

    public Integer getSocialGame() {
        return socialGame;
    }

    public void setSocialGame(Integer socialGame) {
        this.socialGame = socialGame;
    }

    public String getTribeName() {
        return tribeName;
    }

    public void setTribeName(String tribeName) {
        this.tribeName = tribeName;
    }

    public Integer getStrengthAndIntelligence()
    {
        return this.strength + this.intellegence;
    }

    @Override
    public String toString() {
        return "Contestant{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", id='" + id + '\'' +
                ", tribeName='" + tribeName + '\'' +
                ", itemList=" + itemList +
                ", isAlive=" + isAlive +
                ", Place=" + Place +
                ", strength=" + strength +
                ", intellegence=" + intellegence +
                ", gameplay=" + gameplay +
                ", socialGame=" + socialGame +
                '}';
    }
}

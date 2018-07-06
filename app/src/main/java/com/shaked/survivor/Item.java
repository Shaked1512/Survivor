package com.shaked.survivor;

public class Item {
    private String name;
    private String itemID;
    private String ownerID;
    public Item(String name, String itemID)
    {
        this.name = name;
        this.itemID = itemID;
        this.ownerID = null;
    }

    public String getName() {
        return name;
    }

    public String getItemID() {
        return itemID;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", itemID='" + itemID + '\'' +
                ", ownerID='" + ownerID + '\'' +
                '}';
    }
}

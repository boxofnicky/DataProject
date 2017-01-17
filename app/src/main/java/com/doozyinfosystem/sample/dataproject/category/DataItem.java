package com.doozyinfosystem.sample.dataproject.category;

/**
 * Created by Doozy on 15-01-2017.
 */

public class DataItem {

    private String itemId;
    private String itemName;
    private String itemDescription;
    private String category;
    private int sortId;
    private double itemPrice;
    private String itemImage;

    public DataItem() {
    }

    public DataItem(String itemId, String itemName, String category, String itemDescription, int sortId, double itemPrice, String itemImage) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.category = category;
        this.sortId = sortId;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public int getSortId() {
        return sortId;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemImage() {
        return itemImage;
    }


    @Override
    public String toString() {
        return "DataItem{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", sortId=" + sortId +
                ", itemPrice=" + itemPrice +
                ", itemImage='" + itemImage + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

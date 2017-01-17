package com.doozyinfosystem.sample.dataproject.category;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

/**
 * Created by Doozy on 15-01-2017.
 */

public class DataItem implements Parcelable {

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
        if (itemId != null) {
            this.itemId = itemId;
        } else {
            this.itemId = UUID.randomUUID().toString();
        }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemId);
        dest.writeString(this.itemName);
        dest.writeString(this.itemDescription);
        dest.writeString(this.category);
        dest.writeInt(this.sortId);
        dest.writeDouble(this.itemPrice);
        dest.writeString(this.itemImage);
    }

    protected DataItem(Parcel in) {
        this.itemId = in.readString();
        this.itemName = in.readString();
        this.itemDescription = in.readString();
        this.category = in.readString();
        this.sortId = in.readInt();
        this.itemPrice = in.readDouble();
        this.itemImage = in.readString();
    }

    public static final Parcelable.Creator<DataItem> CREATOR = new Parcelable.Creator<DataItem>() {
        @Override
        public DataItem createFromParcel(Parcel source) {
            return new DataItem(source);
        }

        @Override
        public DataItem[] newArray(int size) {
            return new DataItem[size];
        }
    };
}

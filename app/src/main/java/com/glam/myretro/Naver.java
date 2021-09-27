package com.glam.myretro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Naver {
    @Expose
    @SerializedName("start") private String name;

    @Expose
    @SerializedName("display") private String hobby;

    @Expose
    @SerializedName("items") private Items[] items;

    public Items[] getItems() {
        return items;
    }

    public void setItems(Items[] items) {
        this.items = items;
    }

    @Override
    public String toString()
    {
        return "PrintItems [items = "+items+"]";
    }

//    @Expose
//    @SerializedName("items") private String title;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getHobby()
    {
        return hobby;
    }

    public void setHobby(String hobby)
    {
        this.hobby = hobby;
    }

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
}

package com.example.collegeappandchatbot.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CampusList {
    private String message;
    @SerializedName("event List")
    @Expose
    private List<CampusResponse> categorylist ;


    public CampusList(){

    }

    public CampusList(String message, List<CampusResponse> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CampusResponse> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<CampusResponse> categorylist) {
        this.categorylist = categorylist;
    }
}


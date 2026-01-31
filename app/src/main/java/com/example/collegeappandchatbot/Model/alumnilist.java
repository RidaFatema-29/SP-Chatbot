package com.example.collegeappandchatbot.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class alumnilist {
    private String message;
    @SerializedName("alumini List")
    @Expose
    private List<alumniresponse> categorylist ;


    public alumnilist(){

    }

    public alumnilist(String message, List<alumniresponse> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<alumniresponse> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<alumniresponse> categorylist) {
        this.categorylist = categorylist;
    }
}
package com.example.collegeappandchatbot.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class clseventlist {

    private String message;
    @SerializedName("event List")
    @Expose
    private List<DeveventResponse> categorylist ;


    public clseventlist(){

    }

    public clseventlist(String message, List<DeveventResponse> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DeveventResponse> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<DeveventResponse> categorylist) {
        this.categorylist = categorylist;
    }
}

package com.example.collegeappandchatbot.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GSList {
    private String message;
    @SerializedName("event List")
    @Expose
    private List<GSREsponse> categorylist ;


    public GSList(){

    }

    public GSList(String message, List<GSREsponse> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<GSREsponse> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<GSREsponse> categorylist) {
        this.categorylist = categorylist;
    }
}

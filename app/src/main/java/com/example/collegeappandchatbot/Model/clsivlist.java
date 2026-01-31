package com.example.collegeappandchatbot.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class clsivlist {


    private String message;
    @SerializedName("industrial List")
    @Expose
    private List<industrivresponse> categorylist ;


    public clsivlist(){

    }

    public clsivlist(String message, List<industrivresponse> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<industrivresponse> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<industrivresponse> categorylist) {
        this.categorylist = categorylist;
    }
}

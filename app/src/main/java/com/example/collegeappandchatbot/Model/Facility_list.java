package com.example.collegeappandchatbot.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Facility_list {

    private String message;
    @SerializedName("Docter List")
    @Expose
    private List<Facility_listResponse> categorylist ;


    public Facility_list(){

    }

    public Facility_list(String message, List<Facility_listResponse> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Facility_listResponse> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<Facility_listResponse> categorylist) {
        this.categorylist = categorylist;
    }
}

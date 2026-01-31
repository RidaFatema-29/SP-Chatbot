package com.example.collegeappandchatbot.Model;

import com.example.collegeappandchatbot.Model.Facility_listResponse;
import com.example.collegeappandchatbot.Model.timetableresponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class timetablelist { private String message;
    @SerializedName("Docter List")
    @Expose
    private List<timetableresponse> categorylist ;


    public timetablelist(){

    }

    public timetablelist(String message, List<timetableresponse> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<timetableresponse> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<timetableresponse> categorylist) {
        this.categorylist = categorylist;
    }
}


package com.example.collegeappandchatbot.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeedbackResponse {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private String status;

    public FeedbackResponse (String message,String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }
    public String getStatus(){return  status;}
}

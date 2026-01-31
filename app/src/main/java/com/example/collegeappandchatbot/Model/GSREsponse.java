package com.example.collegeappandchatbot.Model;

public class GSREsponse {
    private String id;
    private String g_name;
    private String g_mobile_no;
    private String g_designation;
    private String g_photo;
    private String g_email;

    public GSREsponse(String id, String g_name, String g_mobile_no, String g_designation, String g_photo, String g_email) {
        this.id = id;
        this.g_name = g_name;
        this.g_mobile_no = g_mobile_no;
        this.g_designation = g_designation;
        this.g_photo = g_photo;
        this.g_email = g_email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getG_mobile_no() {
        return g_mobile_no;
    }

    public void setG_mobile_no(String g_mobile_no) {
        this.g_mobile_no = g_mobile_no;
    }

    public String getG_designation() {
        return g_designation;
    }

    public void setG_designation(String g_designation) {
        this.g_designation = g_designation;
    }

    public String getG_photo() {
        return g_photo;
    }

    public void setG_photo(String g_photo) {
        this.g_photo = g_photo;
    }

    public String getG_email() {
        return g_email;
    }

    public void setG_email(String g_email) {
        this.g_email = g_email;
    }
}

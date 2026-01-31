package com.example.collegeappandchatbot.Model;

public class alumniresponse {
    private String id;
    private String a_name;
    private String a_photo;
    private String a_passout_year;
    private String a_placement;
    private String a_designation;


    public alumniresponse(String id, String a_name, String a_photo, String a_passout_year, String a_placement, String a_designation) {
        this.id = id;
        this.a_name = a_name;
        this.a_photo = a_photo;
        this.a_passout_year = a_passout_year;
        this.a_placement = a_placement;
        this.a_designation = a_designation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_photo() {
        return a_photo;
    }

    public void setA_photo(String a_photo) {
        this.a_photo = a_photo;
    }

    public String getA_passout_year() {
        return a_passout_year;
    }

    public void setA_passout_year(String a_passout_year) {
        this.a_passout_year = a_passout_year;
    }

    public String getA_placement() {
        return a_placement;
    }

    public void setA_placement(String a_placement) {
        this.a_placement = a_placement;
    }

    public String getA_designation() {
        return a_designation;
    }

    public void setA_designation(String a_designation) {
        this.a_designation = a_designation;
    }
}

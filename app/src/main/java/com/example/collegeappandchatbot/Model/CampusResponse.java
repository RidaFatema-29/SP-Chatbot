package com.example.collegeappandchatbot.Model;

public class CampusResponse {

    private String id;
    private String place_name;
    private String place_map;
    private String place_photo;

    public CampusResponse(String id, String place_name, String place_map, String place_photo) {
        this.id = id;
        this.place_name = place_name;
        this.place_map = place_map;
        this.place_photo = place_photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_map() {
        return place_map;
    }

    public void setPlace_map(String place_map) {
        this.place_map = place_map;
    }

    public String getPlace_photo() {
        return place_photo;
    }

    public void setPlace_photo(String place_photo) {
        this.place_photo = place_photo;
    }
}
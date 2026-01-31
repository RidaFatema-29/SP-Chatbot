package com.example.collegeappandchatbot.Model;

public class timetableresponse {

    private String timetable_image; // Stores the relative or full image URL
    private String classteacher_id;
    private String class_name;
    private String roomno;

    // Constructor
    public timetableresponse(String timetable_image, String classteacher_id, String class_name, String roomno) {
        this.timetable_image = timetable_image;
        this.classteacher_id = classteacher_id;
        this.class_name = class_name;
        this.roomno = roomno;
    }

    // Getter for timetable_image
    public String getTimetable_image() {
        // If the image URL is relative, prepend the base URL
        if (!timetable_image.startsWith("http")) {
            String baseUrl = "http://lggp.in/student_fees/HOD/Admin1/upload/"; // Replace with your actual base URL
            return baseUrl + timetable_image;
        }
        return timetable_image; // Return as is if it's already a full URL
    }

    public void setTimetable_image(String timetable_image) {
        this.timetable_image = timetable_image;
    }

    // Getters and Setters for other fields
    public String getClassteacher_id() {
        return classteacher_id;
    }

    public void setClassteacher_id(String classteacher_id) {
        this.classteacher_id = classteacher_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }
}

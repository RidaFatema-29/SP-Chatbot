package com.example.collegeappandchatbot.Api;

import com.example.collegeappandchatbot.Feedback;
import com.example.collegeappandchatbot.Model.CampusList;
import com.example.collegeappandchatbot.Model.Facility_list;
import com.example.collegeappandchatbot.Model.FeedbackResponse;
import com.example.collegeappandchatbot.Model.GSList;
import com.example.collegeappandchatbot.Model.UserLoginResponse;
import com.example.collegeappandchatbot.Model.alumnilist;
import com.example.collegeappandchatbot.Model.clseventlist;
import com.example.collegeappandchatbot.Model.clsivlist;
import com.example.collegeappandchatbot.Model.dpeventlist;
import com.example.collegeappandchatbot.Model.dpivlist;
import com.example.collegeappandchatbot.Model.timetablelist;
import com.example.collegeappandchatbot.Model.timetableresponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("login.php")
    Call<UserLoginResponse> userLogin(
            @Field("phone_no") String phone_no,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("view_facility.php")
    Call<Facility_list> getallfacility(@Field("department_id") String department_id);

    @FormUrlEncoded
    @POST("view_timetable.php")
    Call<timetablelist> gettimetable(@Field("class_id") String class_id);

    @FormUrlEncoded
    @POST("view_event_departmentwise.php")
    Call<dpeventlist> getevents(@Field("department_id") String department_id);

    @GET("view_all_event.php")
    Call<clseventlist> getclsevents();

    @FormUrlEncoded
    @POST("industrial_visit_department_wise.php")
    Call<dpivlist> getdiv(@Field("department_id") String department_id);

    @GET("view_industrial.php")
    Call<clsivlist> getclsiv();

    @GET("girls_safety.php")
    Call<GSList> getalldata();

    @GET("view_campus.php")
    Call<CampusList> getallcampus();

    @FormUrlEncoded
    @POST("feedback.php")
    Call<FeedbackResponse> Feedback(
            @Field("name") String name,
            @Field("mobileno")String mobileno,
            @Field("message")String message
    );


    @GET("view_alumini.php")
    Call<alumnilist> getalalumni();
}

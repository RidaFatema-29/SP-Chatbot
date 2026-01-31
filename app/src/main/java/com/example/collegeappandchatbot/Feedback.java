package com.example.collegeappandchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.collegeappandchatbot.Api.RetrofitClient;
import com.example.collegeappandchatbot.Model.FeedbackResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Feedback extends AppCompatActivity {

    EditText idname,idmobile,idmsg;
    Button btnsub;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        idname = findViewById(R.id.idname);
        idmobile = findViewById(R.id.idmobile);
        idmsg = findViewById(R.id.idmsg);
        btnsub = findViewById(R.id.btnsub);


        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = idname.getText().toString();
                String mobile = idmobile.getText().toString();
                String msg = idmsg.getText().toString();

                if (name.isEmpty() || mobile.isEmpty() || msg.isEmpty()) {
                    Toast.makeText(Feedback.this, "Please fill all fields.", Toast.LENGTH_SHORT).show();
                } else {
                    //  Call Signup Api Here...

                    retrofit2.Call<FeedbackResponse> call = RetrofitClient
                            .getInstance()
                            .getApi()
                            .Feedback(name,mobile,msg);

                    call.enqueue(new Callback<FeedbackResponse>() {
                        @Override
                        public void onResponse(retrofit2.Call<FeedbackResponse> call, Response<FeedbackResponse> response) {
                            FeedbackResponse registerResponse = response.body();
                            System.out.println("REGISTERRESPONSE" + registerResponse.getMessage());

                            if (registerResponse != null && registerResponse.equals("Not Inserted.")) {
                                Toast.makeText(Feedback.this, "Not Inserted", Toast.LENGTH_SHORT).show();


                            } else {
                                Toast.makeText(Feedback.this, "Feedback Successfully Added", Toast.LENGTH_SHORT).show();

                                Intent i= new Intent(Feedback.this,HomeActivity.class);
                                startActivity(i);
                            }

                        }

                        @Override
                        public void onFailure(Call<FeedbackResponse> call, Throwable t) {
                            Toast.makeText(Feedback.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }

            }
        });
    }
}
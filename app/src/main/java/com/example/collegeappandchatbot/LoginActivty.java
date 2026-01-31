package com.example.collegeappandchatbot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.collegeappandchatbot.Api.RetrofitClient;
import com.example.collegeappandchatbot.Model.UserLoginResponse;
import com.example.collegeappandchatbot.fragment.Constants;
import com.example.collegeappandchatbot.fragment.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivty extends AppCompatActivity {

    private EditText editTextPhone, editTextPassword;
    private Button buttonLogin;
    private ProgressBar progressBar;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activty);

        editTextPhone = findViewById(R.id.idmobileno);
        editTextPassword = findViewById(R.id.idpass);
        buttonLogin = findViewById(R.id.Btnlogin);

        sessionManager = new SessionManager(this);

        // Check if the user is already logged in, redirect to DashboardActivity
        if (sessionManager.isLoggedIn()) {
            startActivity(new Intent(LoginActivty.this, HomeActivity.class));
            finish();
        }
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo = editTextPhone.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (phoneNo.isEmpty()) {
                    editTextPhone.setError("Phone number is required");
                    editTextPhone.requestFocus();
                    return;
                }

                if (password.isEmpty()) {
                    editTextPassword.setError("Password is required");
                    editTextPassword.requestFocus();
                    return;
                }

                loginUser(phoneNo, password);
            }
        });
    }

    private void loginUser(String phoneNo, String password) {


        Call<UserLoginResponse> call = RetrofitClient.getInstance().getApi().userLogin(phoneNo, password);

        call.enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {

                if (response.isSuccessful() && response.body() != null) {
                    UserLoginResponse userResponse = response.body();

                    if (userResponse.getMessage().equals("success")) {
                        Toast.makeText(LoginActivty.this, "Welcome " + userResponse.getStudentName(), Toast.LENGTH_SHORT).show();

                        sessionManager.setLoggedIn(true);
                        sessionManager.putStringData(Constants.CLASS_ID, userResponse.getClassId());
                        sessionManager.putStringData(Constants.DEPARTMENT_ID, userResponse.getDepartmentId());
                        sessionManager.putStringData(Constants.STUDENT_NAME, userResponse.getStudentName());
                        sessionManager.putStringData(Constants.ENROLLMENT_NO, userResponse.getEnrollmentNo());
                        sessionManager.putStringData(Constants.ROLL_NO, userResponse.getRollNo());
                        sessionManager.putStringData(Constants.CONTACT_NO, userResponse.getPhone_no());
                        sessionManager.putStringData(Constants.EMAIL, userResponse.getStudentEmail());

                        // Navigate to another activity
                        Intent intent = new Intent(LoginActivty.this, HomeActivity.class);
                        intent.putExtra("studentName", userResponse.getStudentName());
                        intent.putExtra("enrolmentno", userResponse.getEnrollmentNo());
                        intent.putExtra("rollno", userResponse.getRollNo());
                        intent.putExtra("contactno", userResponse.getPhone_no());
                        intent.putExtra("email", userResponse.getStudentEmail());
                        intent.putExtra("photo", userResponse.getStudentPhoto());

                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivty.this, userResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivty.this, "Invalid response from server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivty.this, "Failed to connect: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("LoginError", t.getMessage());
            }
        });
    }
}

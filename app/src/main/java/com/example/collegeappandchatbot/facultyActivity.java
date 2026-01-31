package com.example.collegeappandchatbot;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collegeappandchatbot.Adapter.FacilityAdapter;
import com.example.collegeappandchatbot.Api.ApiService;
import com.example.collegeappandchatbot.Api.RetrofitClient;
import com.example.collegeappandchatbot.Model.Facility_list;
import com.example.collegeappandchatbot.Model.Facility_listResponse;
import com.example.collegeappandchatbot.fragment.Constants;
import com.example.collegeappandchatbot.fragment.SessionManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class facultyActivity extends AppCompatActivity {
    String id,c_image;
    FloatingActionButton fabaddgatepass;
    ProgressDialog progressDialog;
    RecyclerView employee_list;
    LinearLayout linearnoitem;
    //SwipeRefreshLayout mSwipeRefreshLayout;
    FacilityAdapter categoryAdapter;
    BottomNavigationView bottomNavigationView;
    SessionManager sessionManager;
    List<Facility_listResponse> categorylist = new ArrayList<Facility_listResponse>();

    //OnClickShowStudentDetails onClickShowStudentDetails;
    @SuppressLint("MissingInflatedId")
    @android.support.RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        sessionManager = new SessionManager(this);
        String department_id = sessionManager.getStringData(Constants.DEPARTMENT_ID);

        Toast.makeText(this, department_id, Toast.LENGTH_SHORT).show();
        employee_list = (RecyclerView) findViewById(R.id.employee_list);

        progressDialog = new ProgressDialog(this);////
        //onClickShowStudentDetails = this;
        employee_list = (RecyclerView) findViewById(R.id.employee_list);
        linearnoitem = (LinearLayout) findViewById(R.id.linearnoitem);
        //mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipetorefresh);
        FragmentManager fragmentManager = getFragmentManager();
        loadJSONCategory(department_id);
    }



    private void loadJSONCategory(String department_id) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();


        ApiService api = retrofit.create(ApiService.class);
        Call<Facility_list> call=api.getallfacility(department_id);

        call.enqueue(new Callback<Facility_list>() {
            @Override
            public void onResponse(Call<Facility_list> call, Response<Facility_list> response) {
                if (response.isSuccessful()) {
                    List<Facility_listResponse> categoryItems = response.body().getCategorylist();
                    employee_list.removeAllViews();

                    categorylist.clear();
                    System.out.println("Data :   " + categoryItems);


                    if (categoryItems != null && categoryItems.size() > 0) {
                        for (int i = 0;i < categoryItems.size();i++){
                            categorylist.add(categoryItems.get(i));
                        }
                        linearnoitem.setVisibility(View.GONE);
                        employee_list.setVisibility(View.VISIBLE);

                        categoryAdapter = new FacilityAdapter(getApplicationContext(),categorylist);
                        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(facultyActivity.this,1);
                        employee_list.setLayoutManager(mLayoutManager);
                        employee_list.setAdapter(categoryAdapter);
                        employee_list.setLayoutManager(mLayoutManager);
                        System.out.println("ItemCount : "+categoryAdapter.getItemCount());
                        //  mSwipeRefreshLayout.setRefreshing(false);
                    }else{
                        //   mSwipeRefreshLayout.setRefreshing(false);
                        linearnoitem.setVisibility(View.VISIBLE);
                        employee_list.setVisibility(View.GONE);
                        showSnack("No Data Found");
                    }
                }
                else {
                    // error case
                    linearnoitem.setVisibility(View.VISIBLE);
                    employee_list.setVisibility(View.GONE);
                    // mSwipeRefreshLayout.setRefreshing(false);
                    showSnack("Failed to Retrive Data ");

                    System.out.println("Error : " + response.body());
                    switch (response.code()) {
                        case 404:
                            showSnack("Server Error 404");
                            //Toast.makeText(LoginActivity.this, "not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            //Toast.makeText(LoginActivity.this, "Error 500", Toast.LENGTH_SHORT).show();
                            showSnack("server broken");
                            break;
                        default:
                            showSnack("unknown error");
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<Facility_list> call, Throwable t) {

            }
        });
    }


    public void showSnack(String message){
//        TSnackbar snackbar = TSnackbar.make(findViewById(android.R.id.content), message, TSnackbar.LENGTH_LONG);
//        View snackbarView = snackbar.getView();
//        snackbarView.setBackgroundColor(getResources().getColor(R.color.black));
//        TextView textView = (TextView) snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
//        textView.setTextColor(Color.WHITE);
//        snackbar.show();

        Snackbar snack = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        View view = snack.getView();
        FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
        params.gravity = Gravity.TOP;
        view.setLayoutParams(params);
        snack.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void showToast(String message){
        Toast toast = Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}
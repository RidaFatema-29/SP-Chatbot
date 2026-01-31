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

import com.example.collegeappandchatbot.Adapter.GirlsSAdapter;
import com.example.collegeappandchatbot.Api.ApiService;
import com.example.collegeappandchatbot.Api.RetrofitClient;
import com.example.collegeappandchatbot.Model.GSList;
import com.example.collegeappandchatbot.Model.GSREsponse;
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

public class Girls_safty extends AppCompatActivity {
    FloatingActionButton fabaddgatepass;
    ProgressDialog progressDialog;
    RecyclerView employee_list;
    LinearLayout linearnoitem;
    //  SwipeRefreshLayout mSwipeRefreshLayout;
    GirlsSAdapter categoryAdapter;
    //SessionManager sessionManager;
    BottomNavigationView bottomNavigationView;
    List<GSREsponse> categorylist = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @android.support.RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls_safty);
        getSupportActionBar().setTitle("Girls Safty");

        employee_list = findViewById(R.id.employee_list);
        progressDialog = new ProgressDialog(this);
        linearnoitem = findViewById(R.id.linearnoitem);
        // mSwipeRefreshLayout = findViewById(R.id.swipetorefresh);
        FragmentManager fragmentManager = getFragmentManager();
        //sessionManager = new SessionManager(this);
        loadJSONCategory();
//        if (InternetConnection.isInternetAvailable(Suggestion.this)) {
//            mSwipeRefreshLayout.setRefreshing(true);
//            loadJSONCategory();
//        } else {
//            showSnack("Please check your Internet Connection.");
//        }

//        mSwipeRefreshLayout.setOnRefreshListener(() -> {
//            if (InternetConnection.isInternetAvailable(Suggestion.this)) {
//                mSwipeRefreshLayout.setRefreshing(true);
//                loadJSONCategory();
//            } else {
//                showSnack("Please check your Internet Connection.");
//            }
//        });
    }

    private void loadJSONCategory() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService api = retrofit.create(ApiService.class);
        Call<GSList> call = api.getalldata();

        call.enqueue(new Callback<GSList>() {
            @Override
            public void onResponse(Call<GSList> call, Response<GSList> response) {
                if (response.isSuccessful()) {
                    List<GSREsponse> categoryItems = response.body().getCategorylist();
                    employee_list.removeAllViews();
                    categorylist.clear();

                    if (categoryItems != null && !categoryItems.isEmpty()) {
                        categorylist.addAll(categoryItems);
                        linearnoitem.setVisibility(View.GONE);
                        employee_list.setVisibility(View.VISIBLE);

                        categoryAdapter = new GirlsSAdapter(getApplicationContext(), categorylist);
                        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(Girls_safty.this, 1);
                        employee_list.setLayoutManager(mLayoutManager);
                        employee_list.setAdapter(categoryAdapter);

                        //    mSwipeRefreshLayout.setRefreshing(false);
                    } else {
                        showNoDataMessage();
                    }
                } else {
                    showNoDataMessage();
                    handleResponseError(response);
                }
            }

            @Override
            public void onFailure(Call<GSList> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void showNoDataMessage() {
        //   mSwipeRefreshLayout.setRefreshing(false);
        linearnoitem.setVisibility(View.VISIBLE);
        employee_list.setVisibility(View.GONE);
        showSnack("No Data Found");
    }

    private void handleResponseError(Response<GSList> response) {
        showSnack("Failed to Retrieve Data");
        switch (response.code()) {
            case 404:
                showSnack("Server Error 404");
                break;
            case 500:
                showSnack("Server broken");
                break;
            default:
                showSnack("Unknown error");
                break;
        }
    }

    public void showSnack(String message) {
        Snackbar snack = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        View view = snack.getView();
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
        params.gravity = Gravity.TOP;
        view.setLayoutParams(params);
        snack.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void showToast(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}
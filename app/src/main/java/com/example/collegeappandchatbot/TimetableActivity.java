package com.example.collegeappandchatbot;

        import static com.example.collegeappandchatbot.Api.RetrofitClient.BASE_URL;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.GridLayoutManager;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;
        import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

        import android.annotation.SuppressLint;
        import android.app.FragmentManager;
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.FrameLayout;
        import android.widget.ImageButton;
        import android.widget.LinearLayout;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.collegeappandchatbot.Adapter.TTAdapter;
        import com.example.collegeappandchatbot.Api.ApiService;
        import com.example.collegeappandchatbot.Model.timetablelist;
        import com.example.collegeappandchatbot.Model.timetableresponse;
        import com.example.collegeappandchatbot.fragment.Constants;
        import com.example.collegeappandchatbot.fragment.SessionManager;
        import com.google.android.material.floatingactionbutton.FloatingActionButton;
        import com.google.android.material.snackbar.Snackbar;

        import java.util.ArrayList;
        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

public class TimetableActivity extends AppCompatActivity {

    FloatingActionButton fabaddgatepass;
    ProgressDialog progressDialog;
    RecyclerView employee_list;
    LinearLayout linearnoitem;
  //  SwipeRefreshLayout mSwipeRefreshLayout;
    TTAdapter categoryAdapter;

    String id="";

    /*
        List<ImageResponse> categorylist = new ArrayList<ImageResponse>();
    */
    ArrayList<timetableresponse> categorylist= new ArrayList<>();

    //OnClickShowStudentDetails onClickShowStudentDetails;



    SessionManager sessionManager;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        setTitle(intent.getStringExtra("cat"));
        getSupportActionBar().setTitle("Time Table");
        sessionManager = new SessionManager(this);

        loadJSONCategory(sessionManager.getStringData(Constants.CLASS_ID));

        employee_list = (RecyclerView) findViewById(R.id.employee_list);

        progressDialog = new ProgressDialog(this);
        //onClickShowStudentDetails = this;
        employee_list = (RecyclerView) findViewById(R.id.employee_list);
        linearnoitem = (LinearLayout) findViewById(R.id.linearnoitem);
       // mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipetorefresh);
        FragmentManager fragmentManager = getFragmentManager();

    }

    private void loadJSONCategory(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();


        ApiService api = retrofit.create(ApiService.class);

        Call<timetablelist> call = api.gettimetable(id);
        call.enqueue(new Callback<timetablelist>() {
            @Override
            public void onResponse(Call<timetablelist> call, Response<timetablelist> response) {
                if (response.isSuccessful()) {
                    List<timetableresponse> categoryItems = response.body().getCategorylist();
                    employee_list.removeAllViews();
                    categorylist.clear();
                    System.out.println(categoryItems);

                    if (categoryItems != null && categoryItems.size() > 0) {
                        linearnoitem.setVisibility(View.GONE);
                        employee_list.setVisibility(View.VISIBLE);
                        categorylist.addAll(categoryItems);
                        categoryAdapter = new TTAdapter(getApplicationContext(), categorylist,sessionManager);
                        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(TimetableActivity.this,1);

                        employee_list.setLayoutManager(mLayoutManager);
                        employee_list.setHasFixedSize(true);
                        employee_list.setAdapter(categoryAdapter);

                        System.out.println("ItemCount : " + categoryAdapter.getItemCount());
                        //mSwipeRefreshLayout.setRefreshing(false);
                    } else {
                       // mSwipeRefreshLayout.setRefreshing(false);
                        linearnoitem.setVisibility(View.VISIBLE);
                        employee_list.setVisibility(View.GONE);
                        Toast.makeText(TimetableActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // error case
                    linearnoitem.setVisibility(View.VISIBLE);
                    employee_list.setVisibility(View.GONE);
                   // mSwipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(TimetableActivity.this, "Failed to Retrive Data ", Toast.LENGTH_SHORT).show();

                    System.out.println("Error : " + response.errorBody());
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(TimetableActivity.this, "Server Error 404", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(TimetableActivity.this, "server broken", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(TimetableActivity.this, "unknown error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<timetablelist> call, Throwable t) {

            }
        });

    }
}
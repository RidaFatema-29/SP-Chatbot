package com.example.collegeappandchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collegeappandchatbot.fragment.SessionManager;

public class HomeActivity extends AppCompatActivity {

    LinearLayout idfaculty, idttable, idevent, idiv, idvc, idgirlS, idfeed, idfec, idweb,idtwit,idinsta,idalu;
    Button btnask;
    ImageView idmenu;
    SessionManager sessionManager;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                logoutUser();
                return true;

            case R.id.idprofile:
                navigateToProfile();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        idfaculty = findViewById(R.id.idfaculti);
        idevent = findViewById(R.id.idevent);
        idttable = findViewById(R.id.idttable);
        idiv = findViewById(R.id.idiv);
        idvc = findViewById(R.id.idvc);
        idgirlS = findViewById(R.id.idgirlS);
        btnask = findViewById(R.id.btnask);
        idfeed = findViewById(R.id.idfeed);
        idfec = findViewById(R.id.idfec);
        idweb = findViewById(R.id.idweb);
        idmenu = findViewById(R.id.idmenu);
        idtwit = findViewById(R.id.idtwit);
        idinsta = findViewById(R.id.idinsta);
        idalu = findViewById(R.id.idalu);

        TextView marqueeTextView = findViewById(R.id.toolbar_text);
        marqueeTextView.setSelected(true);

        String name = getIntent().getStringExtra("studentName");
        String enno = getIntent().getStringExtra("enrolmentno");
        String roll = getIntent().getStringExtra("rollno");
        String mob = getIntent().getStringExtra("contactno");
        String email = getIntent().getStringExtra("email");
        String image = getIntent().getStringExtra("photo");

        // Set up the menu click listener
        idmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenuDialog();
            }
        });

        idfaculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, facultyActivity.class));
            }
        });
        idttable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, TimetableActivity.class));
            }
        });
        idevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, EventActivity.class));
            }
        });
        idiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, IndustrialVisit.class));
            }
        });
        idgirlS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, Girls_safty.class));
            }
        });
        idvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CampusActivity.class));
            }
        });
        btnask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, Chatbot.class));
            }
        });
        idfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, Feedback.class));
            }
        });
        idweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open a web URL
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://sp.sandipfoundation.org/")));
            }
        });

        idfec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open Facebook URL
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/SandipFoundationIndia/")));
            }
        });



        idalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, Alumni.class));
            }
        });
        idtwit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open Facebook URL
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://x.com/i/flow/login?redirect_after_login=%2Fsandipinstitute")));
            }
        });
        idinsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open Facebook URL
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/sandipfoundation/?hl=en")));
            }
        });
    }

    private void showMenuDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose an Option");
        builder.setItems(new CharSequence[]{"Profile", "Logout"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    navigateToProfile();
                } else if (which == 1) {
                    logoutUser();
                }
            }
        });
        builder.show();
    }

    private void navigateToProfile() {
        Intent intent = new Intent(getApplicationContext(), Profileactivity.class);
        startActivity(intent);
    }

    private void logoutUser() {
        new AlertDialog.Builder(HomeActivity.this)
                .setTitle("Confirmation!")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        SessionManager docSessionManager = new SessionManager(getApplicationContext());
                        docSessionManager.logoutUser();
                        Intent intent = new Intent(getApplicationContext(), LoginActivty.class);
                        startActivity(intent);
                        Toast.makeText(HomeActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}

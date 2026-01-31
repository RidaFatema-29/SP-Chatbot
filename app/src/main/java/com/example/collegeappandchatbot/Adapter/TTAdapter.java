package com.example.collegeappandchatbot.Adapter;

import static android.content.Context.DOWNLOAD_SERVICE;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.collegeappandchatbot.Model.timetableresponse;
import com.example.collegeappandchatbot.R;
import com.example.collegeappandchatbot.fragment.SessionManager;

import java.util.ArrayList;

public class TTAdapter extends RecyclerView.Adapter<TTAdapter.ViewHolder> {
    private Context mContext;
    ArrayList<timetableresponse> timeTableModels = new ArrayList<>();

    public TTAdapter(Context mContext, ArrayList<timetableresponse> timeTableModels, SessionManager sessionManager) {
        this.mContext = mContext;
        this.timeTableModels = timeTableModels;
    }

    @NonNull
    @Override
    public TTAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.timetablelayout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TTAdapter.ViewHolder viewHolder, int i) {
        timetableresponse timeTableModel = timeTableModels.get(i);
        viewHolder.text.setText(timeTableModel.getClass_name());

        // Log the URL to verify
        Log.d("TTAdapter", "Image URL: " + timeTableModel.getTimetable_image());
      //  String url = "http://projects.ayaminteractive.com/collage_app_chat_bot/image/images.png";
        // Glide image loading with error handling
        Glide.with(mContext)
                .load(timeTableModel.getTimetable_image())
//                .load(url)

                //.error(R.drawable.) // Replace with a real placeholder image
                .into(viewHolder.image);

        viewHolder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStoragePermissionGranted()) {
                    AlertDialog.Builder alertbox = new AlertDialog.Builder(v.getRootView().getContext());
                    alertbox.setMessage(" Are You Sure You Want To Download ? ");
                    alertbox.setCancelable(true);
                    alertbox.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    DownloadFile(timeTableModel.getTimetable_image());
                                }
                            }).setNegativeButton(
                            "No",
                            null);

                    alertbox.show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return timeTableModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView image;

        public ViewHolder(@NonNull View view) {
            super(view);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
        }
    }

    private void DownloadFile(String uriString) {
        try {
            DownloadManager.Request r = new DownloadManager.Request(Uri.parse(uriString));
            // This puts the download in the same directory the browser uses
            r.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "fileName");
            r.allowScanningByMediaScanner();
            r.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            DownloadManager dm = (DownloadManager) mContext.getSystemService(DOWNLOAD_SERVICE);
            dm.enqueue(r);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "Error : " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Check if the storage permission is granted
    public boolean isStoragePermissionGranted() {
        String TAG = "TimeTableAdapter";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Check if permission is granted
            if (mContext.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                return true;
            } else {
                Log.v(TAG, "Permission is revoked");

                // Check if mContext is an instance of Activity
                if (mContext instanceof Activity) {
                    ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    Log.e(TAG, "Context is not an instance of Activity, cannot request permission");
                }
                return false;
            }
        } else { // Permission is automatically granted on SDK < 23 upon installation
            Log.v(TAG, "Permission is granted");
            return true;
        }
    }
}

package com.example.collegeappandchatbot.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.collegeappandchatbot.Model.GSREsponse;
import com.example.collegeappandchatbot.R;

import java.util.ArrayList;
import java.util.List;

public class GirlsSAdapter extends RecyclerView.Adapter<GirlsSAdapter.ViewHolder> {

    private Context mContext;
    private List<GSREsponse> categoryModels = new ArrayList<>();

    public GirlsSAdapter(Context mContext, List<GSREsponse> categoryModels) {
        this.mContext = mContext;
        this.categoryModels = categoryModels;
    }

    @NonNull
    @Override
    public GirlsSAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gs_row, viewGroup, false);
        return new GirlsSAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GirlsSAdapter.ViewHolder holder, final int i) {
        final GSREsponse categoryModel = categoryModels.get(i);

        String phonenumber = categoryModel.getG_mobile_no();
        String email = categoryModel.getG_email();

        holder.idtitle.setText("Name : " + categoryModel.getG_name());
        holder.iddesi.setText("Post : " + categoryModel.getG_designation());
        holder.idmo.setText("Mo.: " + categoryModel.getG_mobile_no());
        holder.idemail.setText("Email: " + categoryModel.getG_email());

        Glide.with(mContext)
                .load(categoryModel.getG_photo())
                .into(holder.idimage);

        // Call button click listener
        holder.btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + phonenumber));
                dialIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // Ensures proper context
                mContext.startActivity(dialIntent);
            }
        });

        // Email button click listener
        holder.btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = categoryModel.getG_email();
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + email)); // Ensures only email apps handle this
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your Subject Here"); // Optional subject
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Your email body content here"); // Optional body

                if (emailIntent.resolveActivity(mContext.getPackageManager()) != null) {
                    mContext.startActivity(emailIntent);
                } else {
                    // Show a message or handle the case where no email apps are installed
                    Toast.makeText(mContext, "No email apps found on this device.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idtitle, iddesi, idmo, idemail, btnemail, btncall;
        ImageView idimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idtitle = itemView.findViewById(R.id.idtitle);
            iddesi = itemView.findViewById(R.id.iddesi);
            idmo = itemView.findViewById(R.id.idmo);
            idemail = itemView.findViewById(R.id.idemail);
            idimage = itemView.findViewById(R.id.idimage);
            btnemail = itemView.findViewById(R.id.btnemail);
            btncall = itemView.findViewById(R.id.btncall);
        }
    }
}

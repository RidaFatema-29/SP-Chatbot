package com.example.collegeappandchatbot.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.collegeappandchatbot.Model.CampusResponse;
import com.example.collegeappandchatbot.Model.GSREsponse;
import com.example.collegeappandchatbot.R;

import java.util.ArrayList;
import java.util.List;

public class campusAdapter extends RecyclerView.Adapter<campusAdapter.ViewHolder>{

    private Context mContext;
    List<CampusResponse> categoryModels = new ArrayList<CampusResponse>();

    public campusAdapter(Context mContext, List<CampusResponse> categoryModels) {
        this.mContext = mContext;
        this.categoryModels = categoryModels;
    }


    @NonNull
    @Override
    public campusAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.campus_row, viewGroup, false);
        return new campusAdapter.ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(campusAdapter.ViewHolder holder, final int i) {
        final CampusResponse categoryModel=categoryModels.get(i);


        holder.text.setText("Name : "+categoryModel.getPlace_name());

        Glide.with(mContext)
                .load(categoryModel.getPlace_photo())
                .into(holder.ivimage);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(mContext, EventDetails.class);
//                intent.putExtra("image",categoryModel.getE_image());
//                intent.putExtra("info",categoryModel.getE_description());
//
//
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                mContext.startActivity(intent);
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return categoryModels.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        ImageView ivimage,map;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.text);
            map=itemView.findViewById(R.id.map);
            ivimage=itemView.findViewById(R.id.ivimage);

            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition(); // Get the adapter position
                    if (position != RecyclerView.NO_POSITION) {
                        // Get the location URL from the dataset
                        String locationUrl = categoryModels.get(position).getPlace_map();

                        // Create an intent to open the location in Google Maps
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(locationUrl)); // Use the location URL
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                }
            });

        }
    }
}
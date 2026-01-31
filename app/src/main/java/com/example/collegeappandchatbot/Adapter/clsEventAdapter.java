package com.example.collegeappandchatbot.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.collegeappandchatbot.Model.DeveventResponse;
import com.example.collegeappandchatbot.R;

import java.util.ArrayList;
import java.util.List;

public class clsEventAdapter extends RecyclerView.Adapter<clsEventAdapter.ViewHolder>{

    private Context mContext;
    List<DeveventResponse> categoryModels = new ArrayList<DeveventResponse>();

    public clsEventAdapter(Context mContext, List<DeveventResponse> categoryModels) {
        this.mContext = mContext;
        this.categoryModels = categoryModels;
    }


    @NonNull
    @Override
    public clsEventAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_row, viewGroup, false);
        return new clsEventAdapter.ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(clsEventAdapter.ViewHolder holder, final int i) {
        final DeveventResponse categoryModel=categoryModels.get(i);


        holder.name.setText("Event - "+categoryModel.getE_title());
        holder.iddate.setText("Date - "+categoryModel.getE_date());
        holder.idtime.setText("Time - "+categoryModel.getE_time());
        holder.idadd.setText("Venue - "+categoryModel.getRoomno());
        holder.idinfo.setText("Info - "+categoryModel.getE_description());

        Glide.with(mContext)
                .load(categoryModel.getE_image())
                .into(holder.idimage);

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
        TextView name,iddate,idtime,idadd,idinfo;

        ImageView idimage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            iddate=itemView.findViewById(R.id.iddate);
            idtime=itemView.findViewById(R.id.idtime);
            idadd=itemView.findViewById(R.id.idadd);
            idimage=itemView.findViewById(R.id.idimage);

            idinfo=itemView.findViewById(R.id.idinfo);

        }
    }
}
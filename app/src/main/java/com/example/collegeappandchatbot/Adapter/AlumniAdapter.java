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
import com.example.collegeappandchatbot.Model.alumniresponse;
import com.example.collegeappandchatbot.R;

import java.util.ArrayList;
import java.util.List;

public class AlumniAdapter extends RecyclerView.Adapter<AlumniAdapter.ViewHolder> {

    private Context mContext;
    private List<alumniresponse> categoryModels = new ArrayList<>();

    public AlumniAdapter(Context mContext, List<alumniresponse> categoryModels) {
        this.mContext = mContext;
        this.categoryModels = categoryModels;
    }

    @NonNull
    @Override
    public AlumniAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.alumnilist, viewGroup, false);
        return new AlumniAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlumniAdapter.ViewHolder holder, final int i) {
        final alumniresponse categoryModel = categoryModels.get(i);


        holder.idname.setText(categoryModel.getA_name());
        holder.iddesi.setText(categoryModel.getA_designation());
        holder.idplac.setText("Placed in "+categoryModel.getA_placement());
        holder.idpy.setText("Year : " + categoryModel.getA_passout_year());

        Glide.with(mContext)
                .load(categoryModel.getA_photo())
                .into(holder.idimg);


    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idname, idplac, idpy, iddesi;
        ImageView idimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idname = itemView.findViewById(R.id.idname);
            idplac = itemView.findViewById(R.id.idplac);
            idpy = itemView.findViewById(R.id.idpy);
            iddesi = itemView.findViewById(R.id.iddesi);
            idimg = itemView.findViewById(R.id.idimg);
            }
    }
}

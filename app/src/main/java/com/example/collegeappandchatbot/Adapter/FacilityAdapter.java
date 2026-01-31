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
import com.example.collegeappandchatbot.Model.Facility_listResponse;
import com.example.collegeappandchatbot.R;

import java.util.ArrayList;
import java.util.List;

public class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.ViewHolder> {

    private Context mContext;
    List<Facility_listResponse> categoryModels = new ArrayList<Facility_listResponse>();

    public FacilityAdapter(Context mContext, List<Facility_listResponse> categoryModels) {
        this.mContext = mContext;
        this.categoryModels = categoryModels;
    }

    @NonNull
    @Override
    public FacilityAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.faculty_row, viewGroup, false);
        return new FacilityAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FacilityAdapter.ViewHolder holder, final int i) {
        final Facility_listResponse categoryModel = categoryModels.get(i);

        holder.name.setText("Name :"+categoryModel.getName());
        holder.iddepa.setText("Dep.:"+categoryModel.getDepartment_name());
        holder.idmob.setText("Mo.No.:"+categoryModel.getPhone());
        holder.idquali.setText("Qauli :"+categoryModel.getQualification());
        holder.idemail.setText("Email :"+categoryModel.getEmail());




        Glide.with(mContext)
                .load(categoryModel.getPhoto())
                .into(holder.idimage);



    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, iddepa,idquali,idmob,idemail;

        ImageView idimage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            iddepa = itemView.findViewById(R.id.iddepa);
            idquali = itemView.findViewById(R.id.idquali);
            idmob = itemView.findViewById(R.id.idmob);
            idemail = itemView.findViewById(R.id.idemail);

            idimage=itemView.findViewById(R.id.idimage);


        }
    }
}
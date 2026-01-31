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
import com.example.collegeappandchatbot.Model.industrivresponse;
import com.example.collegeappandchatbot.R;

import java.util.ArrayList;
import java.util.List;

public class dvivAdapter extends RecyclerView.Adapter<dvivAdapter.ViewHolder>{

    private Context mContext;
    List<industrivresponse> categoryModels = new ArrayList<industrivresponse>();

    public dvivAdapter(Context mContext, List<industrivresponse> categoryModels) {
        this.mContext = mContext;
        this.categoryModels = categoryModels;
    }


    @NonNull
    @Override
    public dvivAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.industrial_row, viewGroup, false);
        return new dvivAdapter.ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(dvivAdapter.ViewHolder holder, final int i) {
        final industrivresponse categoryModel=categoryModels.get(i);


        holder.idtitle.setText(categoryModel.getTitle());
        holder.idcname.setText("Name - "+categoryModel.getCompany_name());
        holder.iddate.setText("Date - "+categoryModel.getDate());
        holder.idtime.setText("time - "+categoryModel.getTime());
        holder.idadd.setText("venue - "+categoryModel.getAddress());
        holder.idinfo.setText("Info - "+categoryModel.getDescription());


        Glide.with(mContext)
                .load(categoryModel.getCompany_photo())
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
        TextView idtitle,idcname,iddate,idtime,idadd,idinfo;

        ImageView idimage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idtitle=itemView.findViewById(R.id.idtitle);
            idcname=itemView.findViewById(R.id.idcname);
            iddate=itemView.findViewById(R.id.iddate);
            idtime=itemView.findViewById(R.id.idtime);
            idadd=itemView.findViewById(R.id.idadd);
            idimage=itemView.findViewById(R.id.idimage);
            idinfo=itemView.findViewById(R.id.idinfo);


        }
    }
}
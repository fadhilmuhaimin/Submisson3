package com.tomjerry.ulangiapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.AppCompatRatingBar;

//import android.widget.Toast;
//import android.content.Intent;

import com.bumptech.glide.Glide;
import com.tomjerry.ulangiapp.Detail.DetailTv;
import com.tomjerry.ulangiapp.R;
import com.tomjerry.ulangiapp.TvList.Result;

import java.util.ArrayList;



public class ListTvAdapter extends RecyclerView.Adapter<ListTvAdapter.bidangViewHolder> {
    private ArrayList<Result> list;
    private Context context;
    private float cadda;
    private float rating;

    public ListTvAdapter(ArrayList<Result> list) {
        this.list = list;
    }

    @Override
    public bidangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_fragment, parent, false);
        this.context = parent.getContext();
        return new bidangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final bidangViewHolder holder, final int position) {
        cadda = list.get(position).getVoteAverage();
        rating = cadda/10*5;
        Uri gambar = Uri.parse("https://image.tmdb.org/t/p/w342" + list.get(position).getPosterPath());
        Glide.with(context)
                .load(gambar)
                .into(holder.imageView);
        holder.txtNama.setText(list.get(position).getName());
        holder.ratingBar.setRating(rating);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DetailTv.data = list.get(position);
                Intent intent = new Intent(context, DetailTv.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (list != null) ? list.size() : 0;
    }

    public class bidangViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama;
        private ImageView imageView;
        private AppCompatRatingBar ratingBar;


        public bidangViewHolder(View itemView) {
            super(itemView);
            txtNama =  itemView.findViewById(R.id.txt_name);
            imageView =  itemView.findViewById(R.id.img_photo);
            ratingBar =  itemView.findViewById(R.id.ratingBar);
        }
    }
}

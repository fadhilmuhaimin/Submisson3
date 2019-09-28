package com.tomjerry.ulangiapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.tomjerry.ulangiapp.Detail.DetailMovie;


import com.tomjerry.ulangiapp.R;
import com.tomjerry.ulangiapp.MovieList.Result;

import java.util.ArrayList;


public class AdapterBaru extends RecyclerView.Adapter<AdapterBaru.bidangViewHolder> {
    private ArrayList<Result> dataList;
    private Context context;
    private float cadda;
    private float rating;

    public AdapterBaru(ArrayList<Result> dataList) {
        this.dataList = dataList;
    }

    @Override
    public AdapterBaru.bidangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_fragment, parent, false);
        this.context = parent.getContext();
        return new AdapterBaru.bidangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterBaru.bidangViewHolder holder, final int position) {
        if (dataList.get(position).getVoteAverage() != null){
            cadda = dataList.get(position).getVoteAverage();
        }
        rating = cadda/10*5;
//        Log.e("foto",dataList.get(position).getPosterPath());
        Uri gambar = Uri.parse("https://image.tmdb.org/t/p/w342" + dataList.get(position).getPosterPath());
        Glide.with(context)
                .load(gambar)
                .into(holder.imageView);
        holder.txtNama.setText(dataList.get(position).getTitle());
        holder.ratingBar.setRating(rating);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DetailMovie.data= dataList.get(position);
                Intent intent = new Intent(context, DetailMovie.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class bidangViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtStatus;
        private ImageView imageView;
        private AppCompatRatingBar ratingBar;


        public bidangViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_name);
            imageView = (ImageView) itemView.findViewById(R.id.img_photo);
            ratingBar = (AppCompatRatingBar) itemView.findViewById(R.id.ratingBar);
        }
    }
}
//    List<Result> results;
//    Context context;
//    ListFragment listFragment;
//    float cad,cado;
//
//    public AdapterBaru(Context context, List<Result> results){
//        this.context = context;
//        this.results = results;
//    }
//
//    public AdapterBaru(ListFragment listFragment, List<Result> results) {
//        this.listFragment = listFragment;
//        this.results = results;
//    }
//
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_fragment, viewGroup, false);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(AdapterBaru.ViewHolder viewHolder, int i) {
//
////        Result rss = results.get(i);
////        viewHolder.tvName.setText(rss.getTitle());
//////       viewHolder.klik[0] = rss.getTitle();
////       viewHolder.klik[1] = rss.getPosterPath();
////       viewHolder.klik[3] = rss.getOverview();
////       viewHolder.klik[4] = rss.getReleaseDate();
////       viewHolder.klik[5] = rss.getBackdropPath();
//////       cado = rss.getVoteAverage();
//////       Log.i("data ",rss.getTitle());
////
////       cad = cado/10*5;
////        Log.i(TAG, String.valueOf(cad));
////       viewHolder.ratingBar.setRating(cad);
//
//
//
//
//        Uri gambar = Uri.parse("https://image.tmdb.org/t/p/w342" + viewHolder.klik[1] );
//        Glide.with(listFragment.getContext())
//                .load(gambar)
////                .apply(new RequestOptions().override(55, 55))
//                .into(viewHolder.imgPhoto);
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return results.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//        ImageButton btnLike, btnUnlike,btnFavorite;
//        ImageView imgPhoto;
//        AppCompatRatingBar ratingBar;
//        String klik[] = new String[10];
//        public View view;
//        TextView tvName;
//        public ViewHolder( View itemView) {
//            super(itemView);
//            imgPhoto = itemView.findViewById(R.id.img_photo);
//            tvName = itemView.findViewById(R.id.txt_name);
////            btnFavorite = itemView.findViewById(R.id.favorite);
////            btnLike = itemView.findViewById(R.id.like);
////            btnUnlike = itemView.findViewById(R.id.unlike);
//            ratingBar = itemView.findViewById(R.id.ratingBar);
//            itemView.setOnClickListener(this);
//            this.view = itemView;
//
//        }
//
//        @Override
//        public void onClick(View v) {
////            Toast.makeText(listFragment.getContext(), klik[1],Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(listFragment.getContext(), DetailMovie.class);
//            klik[2] = tvName.getText().toString();
//            intent.putExtra("klik", klik[2]);
//            intent.putExtra("gambar", klik[1]);
//            intent.putExtra("deskripsi",klik[3]);
//            intent.putExtra("popularity",klik[4]);
//            intent.putExtra("background",klik[5]);
//            listFragment.startActivity(intent);
//
//        }
//    }
//}

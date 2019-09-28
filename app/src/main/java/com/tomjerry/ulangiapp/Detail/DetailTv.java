package com.tomjerry.ulangiapp.Detail;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tomjerry.ulangiapp.TvList.Result;
import com.tomjerry.ulangiapp.R;


import java.util.ArrayList;
import java.util.List;

public class DetailTv extends AppCompatActivity {
    public static Result data;
    public static final String EXTRA_INFO = "extra_info";
    TextView tvJudul,tvDeskripsi;
    ImageView imgPhoto,imgCollec;
    RatingBar ratingBar;
    private float cad,rating;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_tv);
        tvJudul = findViewById(R.id.tvJudul);
        tvDeskripsi = findViewById(R.id.tvDeskripsi);
        imgPhoto = findViewById(R.id.img_Movie);
        imgCollec = findViewById(R.id.imgBackground);
        ratingBar = findViewById(R.id.ratingBar);
        //        list = getIntent().getParcelableExtra("info");
//        position = getIntent().getIntExtra("position",-1);

        String judul = data.getName();
        String detail = data.getOverview();
        cad = data.getVoteAverage();
        rating= cad/10*5;

        String photo;
        String background;
        background = data.getBackdropPath();
        photo = data.getPosterPath();
        Log.e("Data", data.getPosterPath());
        Uri gambar = Uri.parse("https://image.tmdb.org/t/p/w342" + photo);
        Glide.with(DetailTv.this)
                .load(gambar)
                .into(imgPhoto);
        tvJudul.setText(judul);
        tvDeskripsi.setText(detail);
        Uri bac = Uri.parse("https://image.tmdb.org/t/p/w780" + background);
        Glide.with(DetailTv.this)
                .load(bac)
                .into(imgCollec);
        ratingBar.setRating(rating);

    }
}

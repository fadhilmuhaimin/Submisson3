package com.tomjerry.ulangiapp.Detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tomjerry.ulangiapp.R;
import com.tomjerry.ulangiapp.MovieList.Result;

public class DetailMovie extends AppCompatActivity {
    public static Result data;

    TextView tvJudul,tvDeskripsi,tvInfo,tvRuntime,tvBudget,tvRevenue;
    ImageView imgPhoto,imgCollec;
    RatingBar ratingBar;
    private float cadda;
    private float rating;
//    int position;
//    ArrayList<Result> list;

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
        cadda = data.getVoteAverage();
        rating = cadda/10*5;
        String judul = data.getTitle();
        String detail = data.getOverview();
        String photo;
        String background;
        background = data.getBackdropPath();
        photo = data.getPosterPath();
        Log.e("Data", data.getPosterPath());
        Uri gambar = Uri.parse("https://image.tmdb.org/t/p/w342" + photo);
        Glide.with(DetailMovie.this)
                .load(gambar)
                .into(imgPhoto);
        tvJudul.setText(judul);
//        tvDeskripsi.setText(deskripsi);
        tvDeskripsi.setText(detail);
        Uri bac = Uri.parse("https://image.tmdb.org/t/p/w780" + background);
        Glide.with(DetailMovie.this)
                .load(bac)
                .into(imgCollec);
        ratingBar.setRating(rating);

    }
}
//    public static final String EXTRA_INFO = "extra_info";
//    TextView tvJudul,tvDeskripsi,tvRelease;
//    RatingBar ratingBar;
//
//    ImageView imgPhoto,imgBackground;
//    String data[] = new String[10];
//    Context context;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.detail_new);
//        tvJudul = findViewById(R.id.tvJudul);
//        tvDeskripsi = findViewById(R.id.tvDeskripsi);
//        ratingBar = findViewById(R.id.ratingBar);
//        tvRelease = findViewById(R.id.tvRelease);
//        imgBackground = findViewById(R.id.imgBackground);
//
////        tvRuntime = findViewById(R.id.runtimee);
////        tvBudget = findViewById(R.id.budget);
////        tvRevenue = findViewById(R.id.revenuee);
//        imgPhoto = findViewById(R.id.img_Movie);
//
//        Bundle bundle = getIntent().getExtras();
//         data[0] = bundle.getString("klik");
//        data[1] = bundle.getString("gambar");
//        data[2] = bundle.getString("deskripsi");
//        data[3] = String.valueOf(bundle.get("background"));
//        data[4] = String.valueOf(bundle.get("popularity"));
//        tvJudul.setText(data[0]);
//        Uri gambar = Uri.parse("https://image.tmdb.org/t/p/w342" + data[1]);
//        Glide.with(getApplicationContext())
//                .load(gambar)
////                .apply(new RequestOptions().override(55, 55))
//                .into(imgPhoto);
//        Uri background = Uri.parse("https://image.tmdb.org/t/p/w780"+data[3]);
//        Glide.with(getApplicationContext())
//                .load(background)
//                .into(imgBackground);
//        tvDeskripsi.setText(data[2]);
//        tvRelease.setText(data[4]);
//
//
//
//


//        Result info = getIntent().getParcelableExtra(EXTRA_INFO);
//        String judul = info.getTitle();
//        String detail = info.getOverview();
//        String runtime = info.getReleaseDate();
//        String budget = info.getOriginalLanguage();
//        String revenue = info.getOriginalTitle();
//        String photo;
//        photo = info.getPosterPath();
        //       Picasso.get().load(info.getPhoto()).fit().centerCrop().into(imgPhoto);
//        imgPhoto.setImageResource(photo);
//        Glide.with(DetailMovie.this)
//                .load(photo)
//                .into(imgPhoto);
//       tvJudul.setText(judul);
////        tvDeskripsi.setText(deskripsi);
//        tvInfo.setText(detail);
//        tvRuntime.setText(runtime);
//        tvBudget.setText(budget);


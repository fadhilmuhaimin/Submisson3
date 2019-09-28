package com.tomjerry.ulangiapp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tomjerry.ulangiapp.Adapter.AdapterBaru;
import com.tomjerry.ulangiapp.InterfaceRetrofit.RetMovie;
import com.tomjerry.ulangiapp.MovieList.Movie;
import com.tomjerry.ulangiapp.MovieList.Result;
import com.tomjerry.ulangiapp.R;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListFragment extends Fragment{
    private String[] dataName;
    private String[] dataDescription;
    private String[] dataDetail;
    private String[] dataRuntime;
    private String[] dataBudget;
    private String[] dataRevenue;
    private TypedArray dataPhoto;
    private RecyclerView rvMovies;
    private AdapterBaru adapter;
    private ArrayList<Result> listMv = new ArrayList<Result>();
    Context context;
    private ProgressBar loading;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
//        rvMovies = view.findViewById(R.id.rv_film);
//        rvMovies.setHasFixedSize(true);
//        addItem();
    return view;
    }
//

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovies = (RecyclerView) view.findViewById(R.id.rv_film);


//        addItem();
        loading = view.findViewById(R.id.progressBar);
        if (savedInstanceState!= null && savedInstanceState.getSerializable("save")!=null){
            listMv = new Gson().fromJson(savedInstanceState.getSerializable("save").toString(),new TypeToken<ArrayList<Result>>(){}.getType());

            Log.e("adakah", listMv.get(0).getTitle());
            setListFilm(listMv);
            loading.setVisibility(View.GONE);
        }
        else {
            addItem();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
        Log.e("saving data duluan", String.valueOf(listMv));
        outstate.putSerializable("save",new Gson().toJson(listMv));
    }



//    @Override
//    public void onCreate(@NonNull Bundle savedInstanceState) {
    private void addItem() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetMovie.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetMovie retrofitnya = retrofit.create(RetMovie.class);
        Call<Movie> hubungi = retrofitnya.getMovie();
        hubungi.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie tv = response.body();
//                ArrayList<Result> listTv = new ArrayList<Result>();

                Log.e("Get data", "duluan");


                for (int a = 0; a < tv.getResults().size(); a++){
                    listMv.add(tv.getResults().get(a));
//                    listTv.add(new Result(tv.getResults().get(a).getTitle() , tv.getResults().get(a).getBackdropPath()
//                            , tv.getResults().get(a).getGenreIds() , tv.getResults().get(a).getId()
//                            , tv.getResults().get(a).getOriginalLanguage(), tv.getResults().get(a).getTitle()
//                            , tv.getResults().get(a).getOverview(), tv.getResults().get(a).getPosterPath()
//                            , tv.getResults().get(a).getVoteAverage(), tv.getResults().get(a).getVoteCount()
//                            , tv.getResults().get(a).getPopularity()
//                    ));
//                    listTv.add(new Result(tv.getResults().get(a).getPopularity(), 3, false, tv.getResults().get(a).getPosterPath(), 3, false, "tes", "language", "Tite",
//                            null, "Title", Float.parseFloat("3.0"), "2", "as"));

                }

//                listMv = listTv;
                loading.setVisibility(View.GONE);
                Log.e("Image", tv.getResults().get(0).getPosterPath());
                setListFilm(listMv);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(getActivity(),  t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

//            hero.setDeskripsi(dataDescription[i]);
//            hero.setDetail(dataDetail[i]);
//            hero.setRuntime(dataRuntime[i]);
//            hero.setBudget(dataBudget[i]);
//            hero.setRevenue(dataRevenue[i]);

//            list.add(hero);
        }


//    private void prepare() {
//        dataName = getResources().getStringArray(R.array.data_name);
//        dataDescription = getResources().getStringArray(R.array.data_description);
//        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
//        dataDetail = getResources().getStringArray(R.array.data_details);
//        dataRuntime = getResources().getStringArray(R.array.data_runtime);
//        dataBudget = getResources().getStringArray(R.array.data_budget);
//        dataRevenue = getResources().getStringArray(R.array.data_revenue);
//
//    }
//private void setListFilm(){
//    rvMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
//    ListTvAdapter list = new ListFragment(ListFragment);
//    rvMovies.setAdapter(list);
//    rvMovies.setNestedScrollingEnabled(false);
//
//}

    private void setListFilm(ArrayList<Result> list){

        for (int a = 0; a < list.size(); a++){
            Log.e("saat di set", list.get(a).getPosterPath() + "ada");
        }
        rvMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        AdapterBaru go = new AdapterBaru(list);
        rvMovies.setAdapter(go);
        rvMovies.setNestedScrollingEnabled(false);
    }

//        adapter = new AdapterBaru(this,list);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
//        rvMovies.setLayoutManager(layoutManager);
//        rvMovies.setItemAnimator(new DefaultItemAnimator());
////        rvMovies.setAdapter(adapter);
//    }

//    private void showSelectedMovie (Result movie){
//        Intent intent = new Intent(getActivity(), DetailMovie.class);
//        intent.putExtra("extra_info",movie);
//        startActivity(intent);
//    }

//
//    @Override
//    public void onClick(Result movie) { showSelectedMovie(movie);
//
//    }
}

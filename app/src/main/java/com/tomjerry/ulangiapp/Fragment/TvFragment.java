package com.tomjerry.ulangiapp.Fragment;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tomjerry.ulangiapp.Detail.DetailTv;
import com.tomjerry.ulangiapp.Adapter.ListTvAdapter;
import com.tomjerry.ulangiapp.InterfaceRetrofit.RetTv;
import com.tomjerry.ulangiapp.TvList.Result;
import com.tomjerry.ulangiapp.R;
import com.tomjerry.ulangiapp.TvList.ListTv;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TvFragment extends Fragment {
    private ProgressBar loading;
    private ArrayList<Result> listTv = new ArrayList<Result>();


    private RecyclerView rcList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view_frag1 = inflater.inflate(R.layout.fragment_main, container, false);
        return view_frag1;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcList = (RecyclerView)view.findViewById(R.id.rv_film);
        loading =(ProgressBar)view.findViewById(R.id.progressBar);


        if (savedInstanceState != null && savedInstanceState.getSerializable("Simpan") != null){

            ArrayList<Result> yourArray = new Gson().fromJson(savedInstanceState.getSerializable("Simpan").toString()
                    , new TypeToken<ArrayList<Result>>(){}.getType());
            listTv = yourArray;
            setListFilm();
            loading.setVisibility(View.GONE);
        }
        else {
            getListFilm();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("Simpan", new Gson().toJson(listTv));
    }


    private void getListFilm(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetTv.URL_NAME)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetTv retTv = retrofit.create(RetTv.class);

        Call<ListTv> call = retTv.getTV();

        call.enqueue(new Callback<ListTv>() {
            @Override
            public void onResponse(Call<ListTv> call, Response<ListTv> response) {
                ListTv tv = response.body();
                listTv = new ArrayList<Result>();

                Log.e("data", tv.getResults().get(0).getName());

                for (int a = 0; a < tv.getResults().size(); a++){
                    listTv.add(new Result(tv.getResults().get(a).getOriginalName() , tv.getResults().get(a).getBackdropPath()
                            , tv.getResults().get(a).getGenreIds() , tv.getResults().get(a).getId()
                            , tv.getResults().get(a).getOriginalLanguage(), tv.getResults().get(a).getName()
                            , tv.getResults().get(a).getOverview(), tv.getResults().get(a).getPosterPath()
                            , tv.getResults().get(a).getFirstAirDate(), tv.getResults().get(a).getOriginCountry()
                            , tv.getResults().get(a).getVoteAverage(), tv.getResults().get(a).getVoteCount()
                            , tv.getResults().get(a).getPopularity()
                    ));

                }
                loading.setVisibility(View.GONE);
                setListFilm();
            }

            @Override
            public void onFailure(Call<ListTv> call, Throwable t) {
                Toast.makeText(getActivity(),  t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                loading.setVisibility(View.GONE);
            }
        });
    }

    private void setListFilm(){
        rcList.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListTvAdapter list = new ListTvAdapter(listTv);
        rcList.setAdapter(list);
        rcList.setNestedScrollingEnabled(false);

    }


}

















//    private void addItem() {
//        list = new ArrayList<>();
//        for (int i = 0; i < dataName.length; i++) {
//            Tv hero = new Tv();
//            hero.setPhoto(dataPhoto.getResourceId(i, -1));
//            hero.setName(dataName[i]);
//            hero.setDeskripsi(dataDescription[i]);
//            hero.setDetail(dataDetail[i]);
//            hero.setRuntime(dataRuntime[i]);
//            hero.setBudget(dataBudget[i]);
//            hero.setRevenue(dataRevenue[i]);
//            hero.setCollect(dataCollec.getResourceId(i,-1));
//            list.add(hero);
//        }
//    }
//
//    private void prepare() {
//        dataName = getResources().getStringArray(R.array.name_tv);
//        dataDescription = getResources().getStringArray(R.array.genre_tv);
//        dataPhoto = getResources().obtainTypedArray(R.array.photo_tv);
//        dataDetail = getResources().getStringArray(R.array.details_tv);
//        dataRuntime = getResources().getStringArray(R.array.runtime_tv);
//        dataBudget = getResources().getStringArray(R.array.languange_tv);
//        dataRevenue = getResources().getStringArray(R.array.type_tv);
//        dataCollec = getResources().obtainTypedArray(R.array.arc_tv);
//    }
//    private void setListTv(){
//        rvTv.setLayoutManager(new LinearLayoutManager(getContext()));
//        ListTvAdapter listTvAdapter  = new  ListTvAdapter(getContext());
//        listTvAdapter.setListTvAdapter(list);
//        rvTv.setAdapter(listTvAdapter);
//        listTvAdapter.setOnDetailClick(this);
//    }
//
//    private void showSelectedTv(Tv tv){
//        Intent intent = new Intent(getActivity(), DetailTv.class);
//        intent.putExtra("extra_info",tv);
//        startActivity(intent);
//
//    }
//    @Override
//    public void onClick(Tv tv) {
//        showSelectedTv(tv);
//    }


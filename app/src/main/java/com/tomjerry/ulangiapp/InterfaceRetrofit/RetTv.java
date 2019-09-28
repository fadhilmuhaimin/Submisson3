package com.tomjerry.ulangiapp.InterfaceRetrofit;

import com.tomjerry.ulangiapp.TvList.ListTv;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetTv {
    /**
     *
     */
    String URL_NAME = "https://api.themoviedb.org/3/discover/";
    @GET("tv?api_key=0235ef04c6de443e41cb8fd46280fdf5")
    Call<ListTv>getTV();

}

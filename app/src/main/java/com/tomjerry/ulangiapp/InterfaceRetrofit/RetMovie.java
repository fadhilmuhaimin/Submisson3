package com.tomjerry.ulangiapp.InterfaceRetrofit;

import com.tomjerry.ulangiapp.MovieList.Movie;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetMovie {
//    String BASE_URL = "https://api.themoviedb.org/3/discover/movie/";
String BASE_URL = "https://api.themoviedb.org/3/discover/";


    @GET("movie?api_key=0235ef04c6de443e41cb8fd46280fdf5")
    Call<Movie> getMovie();
}

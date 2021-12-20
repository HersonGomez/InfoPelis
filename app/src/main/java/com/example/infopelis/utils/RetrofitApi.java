package com.example.infopelis.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

    private static RetrofitApi myInstance;

    public static synchronized RetrofitApi getInstance(){
        return myInstance == null ? myInstance = new RetrofitApi():myInstance;
    }

    private RetrofitApi (){
    }

    public Retrofit objetoRetrofit(){
        String baseURL = "https://api.themoviedb.org/";
        return new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

package com.example.infopelis.interfaces;


import com.example.infopelis.model.Peliculas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PeliculasApiService {
    @GET("3/movie/popular?api_key=c051e24a7c62ff2c01982445b6ff5860&language=es-ES")
    Call<Peliculas> consultarPeliculas();
}

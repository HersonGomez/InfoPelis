package com.example.infopelis.model;

import com.example.infopelis.interfaces.InteractorPeliculasView;
import com.example.infopelis.interfaces.PeliculasApiService;
import com.example.infopelis.interfaces.PresenterPeliculasView;
import com.example.infopelis.utils.RetrofitApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InteractorPeliculas implements InteractorPeliculasView, Callback<Peliculas> {
    private final PresenterPeliculasView presenterPeliculasView;

    public InteractorPeliculas(PresenterPeliculasView presenterPeliculasView) {
        this.presenterPeliculasView = presenterPeliculasView;
    }

    @Override
    public void buscarDetallePeliculas() {
        RetrofitApi.getInstance().objetoRetrofit().create(PeliculasApiService.class).consultarPeliculas().enqueue(this);
    }

    @Override
    public void onResponse(Call<Peliculas> call, Response<Peliculas> response) {
        if(!response.isSuccessful()){
            presenterPeliculasView.consultaFallida();
            return;
        }

        Peliculas peliculasData = response.body();
        assert peliculasData != null;
        ArrayList<PeliculasResults> peliculas = peliculasData.getResults();

        if(peliculasData!=null){

            presenterPeliculasView.consultaPopulares(peliculas);
        }
    }

    @Override
    public void onFailure(Call<Peliculas> call, Throwable t) {
        presenterPeliculasView.consultaFallida();
    }
}

package com.example.infopelis.interfaces;

import com.example.infopelis.model.PeliculasResults;

import java.util.ArrayList;

public interface PresenterPeliculasView {
    void buscarDetallePeliculas();
    void consultaFallida();
    void consultaPopulares(ArrayList<PeliculasResults> peliculas);
}

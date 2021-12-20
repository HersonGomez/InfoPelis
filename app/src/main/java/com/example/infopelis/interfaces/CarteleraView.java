package com.example.infopelis.interfaces;

import com.example.infopelis.model.PeliculasResults;

import java.util.ArrayList;

public interface CarteleraView {
    void mostrarProgressBar();
    void ocultarProgressBar();
    void mostrarRecycler();
    void buscarDetallePeliculas();
    void consultaPopulares(ArrayList<PeliculasResults> peliculas);
}

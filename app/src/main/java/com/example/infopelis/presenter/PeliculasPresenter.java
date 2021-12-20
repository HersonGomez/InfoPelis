package com.example.infopelis.presenter;

import com.example.infopelis.interfaces.CarteleraView;
import com.example.infopelis.interfaces.InteractorPeliculasView;
import com.example.infopelis.interfaces.PresenterPeliculasView;
import com.example.infopelis.model.InteractorPeliculas;
import com.example.infopelis.model.PeliculasResults;

import java.util.ArrayList;

public class PeliculasPresenter implements PresenterPeliculasView {

    private CarteleraView carteleraView;
    private InteractorPeliculasView interactorPeliculasView;

    public PeliculasPresenter( CarteleraView carteleraView) {
        this.carteleraView = carteleraView;
        this.interactorPeliculasView = new InteractorPeliculas(this);
    }

    @Override
    public void buscarDetallePeliculas() {
        carteleraView.mostrarProgressBar();
        carteleraView.ocultarError();
        interactorPeliculasView.buscarDetallePeliculas();
    }

    @Override
    public void consultaFallida() {
        carteleraView.ocultarProgressBar();
        carteleraView.mostrarError();
    }

    @Override
    public void consultaPopulares(ArrayList<PeliculasResults> peliculas) {
        carteleraView.ocultarProgressBar();
        carteleraView.mostrarRecycler();
        carteleraView.consultaPopulares(peliculas);
        carteleraView.mostrarRecycler();
    }
}

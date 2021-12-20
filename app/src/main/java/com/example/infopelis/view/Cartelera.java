package com.example.infopelis.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.infopelis.R;
import com.example.infopelis.adapter.RecyclerAdapter;
import com.example.infopelis.interfaces.CarteleraView;
import com.example.infopelis.interfaces.PresenterPeliculasView;
import com.example.infopelis.model.PeliculasResults;
import com.example.infopelis.presenter.PeliculasPresenter;

import java.util.ArrayList;

public class Cartelera extends AppCompatActivity implements CarteleraView {

    private PresenterPeliculasView peliculasPresenter;
    private RecyclerView        mRecyclerPopulares;
    ProgressBar                 progressBarPopulares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cartelera);

        mRecyclerPopulares      = findViewById(R.id.RecyclerPopulares);
        progressBarPopulares    = findViewById(R.id.progressBarPopulares);

        peliculasPresenter      = new PeliculasPresenter(this);
        buscarDetallePeliculas();


    }

    @Override
    public void mostrarProgressBar() {
        progressBarPopulares.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarProgressBar() {
        progressBarPopulares.setVisibility(View.GONE);
    }

    @Override
    public void mostrarRecycler() {
        mRecyclerPopulares.setVisibility(View.VISIBLE);
    }

    @Override
    public void buscarDetallePeliculas() {
        peliculasPresenter.buscarDetallePeliculas();
    }

    @Override
    public void consultaPopulares(ArrayList<PeliculasResults> peliculas) {
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        DividerItemDecoration itemDecoration2 = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0xfda947, 0xfda947});
        drawable.setSize(5,5);
        itemDecoration.setDrawable(drawable);
        itemDecoration2.setDrawable(drawable);
        mRecyclerPopulares.addItemDecoration(itemDecoration);
        mRecyclerPopulares.addItemDecoration(itemDecoration2);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerPopulares.setLayoutManager(staggeredGridLayoutManager);

        //Mostrar Recycler
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(peliculas,this);
        mRecyclerPopulares.setAdapter(recyclerAdapter);
    }
}
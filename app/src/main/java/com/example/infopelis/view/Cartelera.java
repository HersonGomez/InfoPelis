package com.example.infopelis.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.infopelis.R;
import com.example.infopelis.interfaces.CarteleraView;
import com.example.infopelis.presenter.PeliculasPresenter;

public class Cartelera extends AppCompatActivity implements CarteleraView {

    private PeliculasPresenter peliculasPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cartelera);

    }
}
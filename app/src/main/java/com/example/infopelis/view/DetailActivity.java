package com.example.infopelis.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.infopelis.R;
import com.example.infopelis.model.PeliculasResults;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class DetailActivity extends AppCompatActivity {
    PeliculasResults peliculasResults;
    TextView            descripcion;
    TextView            titulo;
    ImageView           backdropPath;
    ImageView           poster_path;
    BlurView            blurView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail);

        descripcion         = findViewById(R.id.descrip);
        titulo              = findViewById(R.id.titulo);
        backdropPath        = findViewById(R.id.backdropPath);
        poster_path         = findViewById(R.id.poster_path);
        blurView            = findViewById(R.id.blurLayout);

        Intent intent       = getIntent();
        peliculasResults    = (PeliculasResults) intent.getSerializableExtra("Descripcion");
        desenfoque();
        mostrarDetalle();
    }

    private void desenfoque() {
        float radius = 15f;

        View decorView = getWindow().getDecorView();
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        Drawable windowBackground = decorView.getBackground();

        blurView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(radius)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(true); // Or false if it's in a scrolling container or might be animated
    }

    public void mostrarDetalle() {
        descripcion.setText(peliculasResults.getOverview());
        titulo.setText(peliculasResults.getTitle());
        glide(poster_path,"https://image.tmdb.org/t/p/w500/"+peliculasResults.getBackdrop_path() );
        glide(backdropPath,"https://image.tmdb.org/t/p/w500/"+peliculasResults.getPoster_path());
    }

    public void glide (ImageView imageView, String url){

        Glide.with(this)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}
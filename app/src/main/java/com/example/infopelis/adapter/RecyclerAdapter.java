package com.example.infopelis.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.infopelis.R;
import com.example.infopelis.model.PeliculasResults;
import com.example.infopelis.view.DetailActivity;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PeliculasViewHolder>{

    private ArrayList<PeliculasResults> results;
    private Context                     context;

    public RecyclerAdapter(ArrayList<PeliculasResults> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public PeliculasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_peliculas,null,false);
        return new PeliculasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculasViewHolder holder, int position) {
        holder.position = results.get(position);
        holder.url="https://image.tmdb.org/t/p/w500/"+results.get(position).getPoster_path();
        Glide.with(context)
                .load(holder.url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageViewPeliculas);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    //Clase utilizada para definir y relacionar los elementos de la vista
    class PeliculasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private  ImageView          imageViewPeliculas;
        private  String             url;
        private  PeliculasResults   position;

        public PeliculasViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewPeliculas = itemView.findViewById(R.id.ImageViewPeliculas);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("Descripcion", position);
            context.startActivity(intent);
        }
    }
}

package com.example.proyecto.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto.Entidades.Carro;
import com.example.proyecto.R;

import java.util.ArrayList;

public class AdapterCarros extends RecyclerView.Adapter<AdapterCarros.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    ArrayList<Carro> model;
    private View.OnClickListener listener;

    public AdapterCarros(Context context,ArrayList<Carro> model){
        this.inflater= LayoutInflater.from(context);
        this.model=model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.lista_carros,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String marca=model.get(position).getMarca();
        String modelo=model.get(position).getModelo();
        String precio=model.get(position).getPrecio();
        String agencia=model.get(position).getAgencia();
        int imagen=model.get(position).getImagenid();
        holder.marca.setText(marca);
        holder.agencia.setText(agencia);
        holder.modelo.setText(modelo);
        holder.precio.setText(precio);
        holder.imagen.setImageResource(imagen);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView marca,modelo,precio,agencia;
        ImageView imagen;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            marca = itemView.findViewById(R.id.Marca);
            modelo= itemView.findViewById(R.id.Modelo);
            precio= itemView.findViewById(R.id.Precio);
            agencia= itemView.findViewById(R.id.Agencia);
            imagen= itemView.findViewById(R.id.carro_imagen);
        }
    }
}

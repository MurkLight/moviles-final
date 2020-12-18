package com.example.proyecto.Fragments;

import android.os.Bundle;
import android.security.identity.PersonalizationData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto.Adaptadores.AdapterCarros;
import com.example.proyecto.Entidades.Carro;
import com.example.proyecto.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    AdapterCarros adapterCarros;
    RecyclerView recyclerViewCarros;
    ArrayList<Carro> listaCarros;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gallery_fragment,container,false);
        recyclerViewCarros= view.findViewById(R.id.recyclerview);
        listaCarros= new ArrayList<>();

        cargaLista();
        mostrarDatos();
        return view;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void cargaLista(){
        listaCarros.add(new Carro("Audi","A10","Audi Bosques Ags","5500", R.drawable.carro));
        listaCarros.add(new Carro("AAAAA","BBB","Audi Bosques Ags","15500", R.drawable.carro2));
        listaCarros.add(new Carro("Audi","BBBBB","Audi Bosques Ags","5500", R.drawable.carro3));
    }

    public void mostrarDatos(){
        recyclerViewCarros.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterCarros=new AdapterCarros(getContext(),listaCarros);
        recyclerViewCarros.setAdapter(adapterCarros);


    }
}

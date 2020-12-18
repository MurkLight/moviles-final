package com.example.proyecto.Fragments;

import android.os.Bundle;
import android.security.identity.PersonalizationData;
import android.util.Log;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class GalleryFragment extends Fragment {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    AdapterCarros adapterCarros;
    RecyclerView recyclerViewCarros;
    ArrayList<Carro> listaCarros;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gallery_fragment,container,false);
        recyclerViewCarros= view.findViewById(R.id.recyclerview);
        listaCarros= new ArrayList<>();

        // NO TENGO NI IDEA DE LO QUE ESTOY HACIENDO !!!!
        db.collection("autos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());

                                Map data = document.getData();

                                listaCarros.add(new Carro(
                                        data.get("nombre").toString(),
                                        data.get("descripcion").toString(),
                                        data.get("precio").toString(),
                                        data.get("foto").toString(),
                                        data.get("capacidad").toString()
                                ));
                                mostrarDatos();

                            }

                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

        return view;


    }


    public void mostrarDatos(){
        recyclerViewCarros.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterCarros=new AdapterCarros(getContext(),listaCarros);
        recyclerViewCarros.setAdapter(adapterCarros);
    }
}

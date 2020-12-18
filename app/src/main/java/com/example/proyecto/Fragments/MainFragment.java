package com.example.proyecto.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.proyecto.R;

public class MainFragment extends Fragment implements View.OnClickListener  {

    Button gallery,payment,mapas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment,container,false);
        super.onCreate(savedInstanceState);

        gallery=(Button) view.findViewById(R.id.gallery);
        payment=(Button) view.findViewById(R.id.payment);
        mapas=(Button) view.findViewById(R.id.mapas);
        gallery.setOnClickListener(this);
        payment.setOnClickListener(this);
        mapas.setOnClickListener(this);

        //Fragment nuevoFragmento = new BlankFragment();

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.gallery:
                // Crea el nuevo fragmento y la transacción.
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new GalleryFragment());
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();
                break;
            case R.id.payment:
                // Crea el nuevo fragmento y la transacción.
                FragmentTransaction transaction2 = getFragmentManager().beginTransaction();
                transaction2.replace(R.id.container, new PayFragment());
                transaction2.addToBackStack(null);

                // Commit a la transacción
                transaction2.commit();
                break;
            case R.id.mapas:
                // Crea el nuevo fragmento y la transacción.
                FragmentTransaction transaction3 = getFragmentManager().beginTransaction();
                transaction3.replace(R.id.container, new MapFragment());
                transaction3.addToBackStack(null);

                // Commit a la transacción
                transaction3.commit();
                break;

        }

    }
}

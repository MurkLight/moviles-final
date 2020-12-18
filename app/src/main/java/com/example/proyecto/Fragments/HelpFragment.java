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

public class HelpFragment extends Fragment implements View.OnClickListener {
    Button condiciones;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.help_fragment,container,false);
        super.onCreate(savedInstanceState);

        condiciones = (Button) view.findViewById(R.id.condiciones);
        condiciones.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.condiciones:
                // Crea el nuevo fragmento y la transacción.
                FragmentTransaction transaction5 = getFragmentManager().beginTransaction();

                transaction5.replace(R.id.container, new TerminosFragment());
                transaction5.addToBackStack(null);

                // Commit a la transacción
                transaction5.commit();
                break;
        }
    }
}

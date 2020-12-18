package com.example.proyecto.Fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.gallery:

                break;

        }

    }
}

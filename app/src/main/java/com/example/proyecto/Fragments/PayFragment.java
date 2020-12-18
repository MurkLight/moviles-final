package com.example.proyecto.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyecto.R;

public class PayFragment extends Fragment implements View.OnClickListener {
    Button button;
    EditText name,card_number,cvv2;
    Spinner year_spinner,month_spinner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pay_fragment,container,false);
        super.onCreate(savedInstanceState);


        button= (Button) view.findViewById(R.id.guardar);
        button.setOnClickListener(this);


        name= (EditText) view.findViewById(R.id.name);
        // name.setOnClickListener(this);
        card_number= (EditText) view.findViewById(R.id.card_number);
        // card_number.setOnClickListener(this);
        cvv2= (EditText) view.findViewById(R.id.cvv2);
        //cvv2.setOnClickListener(this);
        year_spinner= (Spinner) view.findViewById(R.id.year_spinner);
        //year_spinner.setOnClickListener(this);
        month_spinner= (Spinner) view.findViewById(R.id.month_spinner);
        //month_spinner.setOnClickListener(this);




        return view;
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.guardar:
                name.setText("");
                card_number.setText("");
                cvv2.setText("");
                year_spinner.setSelection(0);
                month_spinner.setSelection(0);
                Toast.makeText(getContext(),"Pago Realizado", Toast.LENGTH_SHORT).show();
                break;
        }
    }




}

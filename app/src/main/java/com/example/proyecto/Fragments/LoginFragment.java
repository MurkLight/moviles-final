package com.example.proyecto.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyecto.MainActivity;
import com.example.proyecto.R;

import static com.google.common.base.Strings.isNullOrEmpty;

public class LoginFragment extends Fragment implements View.OnClickListener {

    EditText email, password;
    String _email, _password;

    Button ingresar, registrar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        super.onCreate(savedInstanceState);
        email = (EditText) view.findViewById(R.id.email);
        password = (EditText) view.findViewById(R.id.password);

        ingresar = (Button) view.findViewById(R.id.ingresar);
        registrar = (Button) view.findViewById(R.id.registrar);

        ingresar.setOnClickListener(this);

        registrar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        _email = email.getText().toString();
        _password = password.getText().toString();


        if (isNullOrEmpty(_password) || isNullOrEmpty(_email)) {
            Log.d("", "signInWithEmail:emailOrPasswordEmpty");
            Toast.makeText(this.getContext(), "Correo o contraseña vacíos",
                    Toast.LENGTH_SHORT).show();
        } else {
            switch (view.getId()) {
                case R.id.ingresar:
                    ((MainActivity) getActivity()).logIn(_email, _password);
                    break;
                case R.id.registrar:
                    ((MainActivity) getActivity()).signUp(_email, _password);
                    break;
            }
        }
    }
}
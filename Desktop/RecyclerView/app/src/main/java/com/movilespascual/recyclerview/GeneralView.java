package com.movilespascual.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GeneralView extends AppCompatActivity {

    TextView nombre, correo, ciudad, estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_view);
        nombre = findViewById(R.id.nombre2);
        correo = findViewById(R.id.correo2);
        ciudad = findViewById(R.id.ciudad2);
        estado = findViewById(R.id.estado2);

        String name = getIntent().getStringExtra("name");
        nombre.setText(name);
        String mail = getIntent().getStringExtra("correo");
        correo.setText(mail);
        String city = getIntent().getStringExtra("ciudad");
        ciudad.setText(city);
        String state = getIntent().getStringExtra("estado");
        estado.setText(state);
    }
}
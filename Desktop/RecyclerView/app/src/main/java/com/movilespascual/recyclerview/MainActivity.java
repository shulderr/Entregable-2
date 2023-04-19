package com.movilespascual.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListaElementos> elementos;
    public RelativeLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void  init(){
        elementos = new ArrayList<>();
        elementos.add(new ListaElementos("#7B1FA2","Pedro","Manizales","Activo", "pedrito@mail.com"));
        elementos.add(new ListaElementos("#58F098","Bernardo","Pasto","Ausente", "bernard@mail.com"));
        elementos.add(new ListaElementos("#F08658","Ivan","Bogota","Activo", "ivancho@mail.com"));
        elementos.add(new ListaElementos("#A4F058","Leonardo","Barranquilla","Activo", "leo@mail.com"));
        elementos.add(new ListaElementos("#F73030","Antonio","Bucaramanga","Ausente", "antonio@mail.com"));

        ListAdapter listAdapter = new ListAdapter(elementos,this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    public void content(View view){
        Intent intent = new Intent(view.getContext(), GeneralView.class);
        startActivity(intent);
    }

}
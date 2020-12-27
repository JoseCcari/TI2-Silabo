package com.example.registrocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Crear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
    }
    public  void CSiguiente(View view) {
        Intent cambiar = new Intent(this, Crear2.class);
        startActivity(cambiar);
    }
    public  void CAtras(View view) {
        Intent cambiar = new Intent(this, Nuevo.class);
        startActivity(cambiar);
    }
    public  void CUnidad(View view) {
        Intent cambiar = new Intent(this, AgUnidad.class);
        startActivity(cambiar);
    }


}
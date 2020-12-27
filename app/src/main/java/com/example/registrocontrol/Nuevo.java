package com.example.registrocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Nuevo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
    }
    public  void CMain(View view) {
        Intent cambiar = new Intent(this, MainActivity.class);
        startActivity(cambiar);
    }
    public  void CCrear(View view) {
        Intent cambiar = new Intent(this, Crear.class);
        startActivity(cambiar);
    }
    public  void CModificar(View view) {
        Intent cambiar = new Intent(this, Modificar.class);
        startActivity(cambiar);
    }

}
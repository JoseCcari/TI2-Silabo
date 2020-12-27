package com.example.registrocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Otros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otros);
    }

    public  void CBuscarDocente(View view) {
        Intent cambiar = new Intent(this, BuscarDocente.class);
        startActivity(cambiar);
    }
    public  void CAgregarDocente(View view) {
        Intent cambiar = new Intent(this, AgregarDocente.class);
        startActivity(cambiar);
    }
    public  void CEliminarDocente(View view) {
        Intent cambiar = new Intent(this, EliminarDocente.class);
        startActivity(cambiar);
    }
    public  void CModificarDocente(View view) {
        Intent cambiar = new Intent(this, ModificarDocente.class);
        startActivity(cambiar);
    }
    public  void CRetroceder(View view) {
        Intent cambiar = new Intent(this, MainActivity.class);
        startActivity(cambiar);
    }

}
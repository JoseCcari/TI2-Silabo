package com.example.registrocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ModificarDocente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_docente);
    }
    public  void CRetroceder(View view) {
        Intent cambiar = new Intent(this, Otros.class);
        startActivity(cambiar);
    }
    public  void CBuscarD(View view) {
        Intent cambiar = new Intent(this, BuscarDocente.class);
        startActivity(cambiar);
    }
}
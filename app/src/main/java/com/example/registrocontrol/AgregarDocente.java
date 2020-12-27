package com.example.registrocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AgregarDocente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_docente);
    }
    public  void CAgregarD(View view) {
        Intent cambiar = new Intent(this, AgregarCompletado.class);
        startActivity(cambiar);
    }
    public  void CAtrasD(View view) {
        Intent cambiar = new Intent(this, Otros.class);
        startActivity(cambiar);
    }
}
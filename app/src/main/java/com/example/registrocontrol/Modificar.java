package com.example.registrocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Modificar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
    }
    public  void CMain(View view) {
        Intent cambiar = new Intent(this, MainActivity.class);
        startActivity(cambiar);
    }
    public  void CCrear(View view) {
        Intent cambiar = new Intent(this, Crear.class);
        startActivity(cambiar);
    }

}
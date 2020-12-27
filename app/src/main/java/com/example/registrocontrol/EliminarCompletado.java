package com.example.registrocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EliminarCompletado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_completado);
    }
    public  void CRegresar(View view) {
        Intent cambiar = new Intent(this, MainActivity.class);
        startActivity(cambiar);
    }
}
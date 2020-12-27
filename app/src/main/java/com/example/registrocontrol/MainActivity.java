package com.example.registrocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void CExportar(View view) {
        Intent cambiar = new Intent(this, Exportar.class);
        startActivity(cambiar);
    }
    public  void CVer(View view) {
        Intent cambiar = new Intent(this, Ver.class);
        startActivity(cambiar);
    }
    public  void CModificar(View view) {
        Intent cambiar = new Intent(this, Modificar.class);
        startActivity(cambiar);
    }
    public  void CNuevo(View view) {
        Intent cambiar = new Intent(this, Nuevo.class);
        startActivity(cambiar);
    }
    public  void CConfiguracion(View view) {
        Intent cambiar = new Intent(this, Configuracion.class);
        startActivity(cambiar);
    }

    public  void COtros(View view) {
        Intent cambiar = new Intent(this, Otros.class);
        startActivity(cambiar);
    }



}
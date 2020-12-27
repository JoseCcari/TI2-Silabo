package com.example.registrocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
        final TextView idDocente = (TextView) findViewById(R.id.editTextNumber4);
        String url ="http://192.168.0.6:8000/searchDocente/" + idDocente.getText().toString().trim();

        System.out.println("GET: " + url);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        //String url ="http://192.168.0.6:8000/searchDocente/1234";

        //http://192.168.0.6:8000/searchDocente/1234
        final Intent cambiar = new Intent(this, BuscarDocente.class);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        cambiar.putExtra("docenteinfo", response);
                        startActivity(cambiar);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //textView.setText("That didn't work!");
                        System.out.println("Error," + error.toString());
                    }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

        //Intent cambiar = new Intent(this, BuscarDocente.class);
        //startActivity(cambiar);
    }

}
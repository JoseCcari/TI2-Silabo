package com.example.registrocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;

public class BuscarDocente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_docente);


    }
    public void Request(){
            final TextView textView = (TextView) findViewById(R.id.editTextNumber5);
    // ...

    // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(this);
            String url ="http://127.0.0.1:8000/searchDocente/1234";

        //http://192.168.0.6:8000/searchDocente/1234

    // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.
                            textView.setText("Response is: "+ response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            textView.setText("That didn't work!");
                            System.out.println("Error," + error.toString());
                        }
            });

    // Add the request to the RequestQueue.
            queue.add(stringRequest);
    }


    public  void CRetroceder(View view) {
        Intent cambiar = new Intent(this, ModificarDocente.class);
        startActivity(cambiar);
    }
    public  void CModificarD(View view)throws IOException {
        //Intent cambiar = new Intent(this, Otros.class);
        //startActivity(cambiar);
        Request();
    }
}
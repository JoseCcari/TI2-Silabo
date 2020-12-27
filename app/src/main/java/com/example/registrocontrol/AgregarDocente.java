package com.example.registrocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class AgregarDocente extends AppCompatActivity {
    JSONObject docente;

    TextView tvDocumento;
    TextView tvNombre;
    TextView tvApPaterno;
    TextView tvApMaterno;
    TextView tvGradoAcademico;
    TextView tvIdDepartamento;

    //Toast mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_docente);


        tvDocumento = (TextView) findViewById(R.id.editTextNumber);
        tvNombre = (TextView) findViewById(R.id.editTextTextPersonName5);
        tvApPaterno = (TextView) findViewById(R.id.editTextTextPersonName7);
        tvApMaterno = (TextView) findViewById(R.id.editTextTextPersonName8);
        tvGradoAcademico = (TextView) findViewById(R.id.editTextTextPersonName9);
        tvIdDepartamento = (TextView) findViewById(R.id.editTextNumber2);


    }
    public void CrearDocente(){
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = "http://192.168.0.6:8000/addDocente";

            JSONObject jsonBody = new JSONObject();

            jsonBody.put("dni", tvDocumento.getText().toString().trim());
            jsonBody.put("name",  tvNombre.getText().toString().trim());
            jsonBody.put("lastname1", tvApPaterno.getText().toString().trim());
            jsonBody.put("lastname2", tvApMaterno.getText().toString().trim());
            jsonBody.put("gradoacademico", tvGradoAcademico.getText().toString().trim());
            jsonBody.put("depAcademico", tvIdDepartamento.getText().toString().trim());

            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                    Toast.makeText(getApplicationContext(), "Docente Eliminado!", Toast.LENGTH_LONG).show();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public  void CAgregarD(View view) {
        Intent cambiar = new Intent(this, AgregarCompletado.class);
        startActivity(cambiar);
        CrearDocente();
    }
    public  void CAtrasD(View view) {
        Intent cambiar = new Intent(this, Otros.class);
        startActivity(cambiar);
    }

}
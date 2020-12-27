package com.example.registrocontrol;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class BuscarDocente extends AppCompatActivity {

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
        setContentView(R.layout.activity_buscar_docente);
        Bundle bundle = getIntent().getExtras();
        String docenteInfo = bundle.getString("docenteinfo");

        System.out.println("docenteInfo: " + docenteInfo);

        tvDocumento = (TextView) findViewById(R.id.editTextNumber5);
        tvNombre = (TextView) findViewById(R.id.editTextTextPersonName10);
        tvApPaterno = (TextView) findViewById(R.id.editTextTextPersonName11);
        tvApMaterno = (TextView) findViewById(R.id.editTextTextPersonName12);
        tvGradoAcademico = (TextView) findViewById(R.id.editTextTextPersonName13);
        tvIdDepartamento = (TextView) findViewById(R.id.editTextNumber6);

        try {
            docente = new JSONObject(docenteInfo);

            tvDocumento.setText(docente.getString("doc_dni"));
            tvNombre.setText(docente.getString("doc_nom"));
            tvApPaterno.setText(docente.getString("doc_ape_pat"));
            tvApMaterno.setText(docente.getString("doc_ape_mat"));
            tvGradoAcademico.setText(docente.getString("doc_grad_aca"));
            tvIdDepartamento.setText(docente.getString("dep_aca_ide"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void actualizarDatosDocente(){
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = "http://192.168.0.6:8000/updateDocente";

            JSONObject jsonBody = new JSONObject();

            jsonBody.put("doc_ide", docente.getString("doc_ide"));
            jsonBody.put("doc_dni", tvDocumento.getText().toString().trim());
            jsonBody.put("doc_nom",  tvNombre.getText().toString().trim());
            jsonBody.put("doc_ape_pat", tvApPaterno.getText().toString().trim());
            jsonBody.put("doc_ape_mat", tvApMaterno.getText().toString().trim());
            jsonBody.put("doc_grad_aca", tvGradoAcademico.getText().toString().trim());
            jsonBody.put("dep_aca_ide", tvIdDepartamento.getText().toString().trim());

            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
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
    /*
    public void actualizarDatosDocente(){
        //mPostCommentResponse.requestStarted();
        //RequestQueue queue = Volley.newRequestQueue(context);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this    );
        StringRequest sr = new StringRequest(Request.Method.POST,"http://192.168.0.6:8000/updateDocente", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //mPostCommentResponse.requestCompleted();
                //Toast.makeText(this, "Actualización correcta!",3000).show();
                System.out.println("Actualización correcta!");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mPostCommentResponse.requestEndedWithError(error);
                System.out.println("ERROR! " + error.toString());
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                try {
                    params.put("doc_ide", docente.getString("doc_ide"));
                    params.put("doc_dni", tvDocumento.getText().toString().trim());
                    params.put("doc_nom",  tvNombre.getText().toString().trim());
                    params.put("doc_ape_pat", tvApPaterno.getText().toString().trim());
                    params.put("doc_ape_mat", tvApMaterno.getText().toString().trim());
                    params.put("doc_grad_aca", tvGradoAcademico.getText().toString().trim());
                    params.put("dep_aca_ide", tvIdDepartamento.getText().toString().trim());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for (Map.Entry entry : params.entrySet()){
                    System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
                }
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                //params.put("Content-Type","application/x-www-form-urlencoded");
                params.put("Content-Type","application/json");
                return params;
            }
        };
        queue.add(sr);
    }
     */


    public  void CRetroceder(View view) {
        Intent cambiar = new Intent(this, ModificarDocente.class);
        startActivity(cambiar);
    }
    public  void CModificarD(View view)throws IOException {
        //Intent cambiar = new Intent(this, Otros.class);
        //startActivity(cambiar);
        //Request();

        actualizarDatosDocente();
    }
}
package com.example.user.travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Postform extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postform);
    }

    public void post(View v)
    {
        final String RegistrationUrl = "http://aroundbangladesh.byethost24.com/sust/post.php";

        EditText source = (EditText) findViewById(R.id.src);
        EditText destination = (EditText) findViewById(R.id.des);
        EditText cost = (EditText) findViewById(R.id.cost);
        EditText description = (EditText) findViewById(R.id.description);

        final String _src = source.getText().toString();
        final String _des = destination.getText().toString();
        final String _cost = cost.getText().toString();
        final String _descrip = description.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(Postform.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, RegistrationUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Postform.this, response, Toast.LENGTH_SHORT).show();
                if (response.trim().equals("success")) {
                    Intent intent = new Intent(Postform.this, MainActivity.class);
                    startActivity(intent);
                }
                Log.i("My success", "" + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("my error :", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("cost", _cost);
                map.put("source", _src);
                map.put("destination", _des);
                map.put("description", _descrip);
                return map;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/12.10240");
                map.put("Cookie", "__test=5acf389be15ebc7b5138aeae63b698ca; expires=Friday, January 1, 2038 at 5:55:55 AM; path=/");
                return map;
            }
        };
        queue.add(stringRequest);

    }
}

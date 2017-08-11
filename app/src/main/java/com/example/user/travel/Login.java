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

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v)
    {
        final String LoginUrl = "http://studybuddy.site11.com/sust/login.php";
        EditText username = (EditText) findViewById(R.id.login_user);
        EditText password = (EditText) findViewById(R.id.login_pass);
        final String uName = username.getText().toString();
        final String pass = password.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(Login.this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, LoginUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Login.this,response,Toast.LENGTH_SHORT).show();
                if(response.trim().equals("success")){
                    Intent intent = new Intent(Login.this, Postform.class);
                    startActivity(intent);
                }
                Log.i("My success",""+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("my error :",error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("username",uName);
                map.put("password",pass);
                return map;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError{
                Map<String,String> map = new HashMap<>();
                map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/12.10240");
                map.put("Cookie", "__test=5acf389be15ebc7b5138aeae63b698ca; expires=Friday, January 1, 2038 at 5:55:55 AM; path=/");
                return map;
            }
        };
        queue.add(stringRequest);
//        new BackgroundTask(this).execute("login", uName, pass);
//        Intent i= new Intent(Login.this,Postform.class);
//        startActivity(i);
    }
    public void reg(View v)
    {
        Intent i= new Intent(Login.this,Registration.class);
        startActivity(i);
    }
}

package com.example.user.travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
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

public class Postfeed extends AppCompatActivity {

    ListView mylist;
    MyCustomAdapter myAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postfeed);

        mylist=(ListView) findViewById(R.id.mylistview);

        int[] img={R.drawable.inani,R.drawable.kuakata};

        myAdap = new MyCustomAdapter(this);

        final String postUrl = "http://studybuddy.site11.com/sust/guideTravel.php";
        RequestQueue queue = Volley.newRequestQueue(Postfeed.this);
        StringRequest stringRequest= new StringRequest(Request.Method.GET, postUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(Postfeed.this,response,Toast.LENGTH_SHORT).show();
//                if(response.trim().equals("success")){
//                    Intent intent = new Intent(Login.this, Postform.class);
//                    startActivity(intent);
//                }
                myAdap.setmList(new Json(response).parseJSON());
                Log.i("My successo",""+new Json(response).parseJSON());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("my error :",error.toString());
            }
        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> map = new HashMap<>();
//                map.put("username",uName);
//                map.put("password",pass);
//                return map;
//            }
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
        mylist.setAdapter(myAdap);

    }
    }



package com.example.user.travel;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Registration extends AppCompatActivity {
    String sgender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final Spinner gen = (Spinner) findViewById(R.id.gen);

        String[] gender = new String[]{
                "Select",
                "Male",
                "Female"
        };

        final List<String> g = new ArrayList<>(Arrays.asList(gender));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.gender, g) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spArrayAdapter.setDropDownViewResource(R.layout.gender);
        gen.setAdapter(spArrayAdapter);

        gen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    sgender = gen.getSelectedItem().toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    public void submit(View v) {

        final String RegistrationUrl = "http://studybuddy.site11.com/sust/registration.php";

        EditText fullname = (EditText) findViewById(R.id.name);
        EditText Pass = (EditText) findViewById(R.id.pass);
        EditText Email = (EditText) findViewById(R.id.mobno);
        EditText mob = (EditText) findViewById(R.id.email);

        final String Name = fullname.getText().toString();
        final String pass = Pass.getText().toString();
        final String mail = Email.getText().toString();
        final String mobno = mob.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(Registration.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, RegistrationUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Registration.this, response, Toast.LENGTH_SHORT).show();
                if (response.trim().equals("success")) {
                    Intent intent = new Intent(Registration.this, Postform.class);
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
                map.put("name", Name);
                map.put("email", mail);
                map.put("password", pass);
                map.put("phone", mobno);
                map.put("password", pass);
                map.put("gender", sgender);
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

package com.example.user.travel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

public class Rentplace extends AppCompatActivity {
    String[] source_arr = {"Sylhet", "Rajshahi", "Chittagong", "Rangpur","Dhaka"};

    AutoCompleteTextView acTextView1, acTextView2;


    public String src1;
    EditText es1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentplace);

        es1 = (EditText) findViewById(R.id.location);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, source_arr);
        //Find TextView control
        acTextView1 = (AutoCompleteTextView) findViewById(R.id.location);
        //Set the number of characters the user must type before the drop down list is shown
        acTextView1.setThreshold(0);
        //Set the adapterr
        acTextView1.setAdapter(adapter1);

        src1 = acTextView1.getText().toString();


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio1:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio2:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio3:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio4:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void joma1 (View v) {

        Toast.makeText(Rentplace.this, "your response has been submitted ", Toast.LENGTH_SHORT).show();



    }

}

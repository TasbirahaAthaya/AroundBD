package com.example.user.travel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class VacationRentals extends AppCompatActivity {

    String[] des_arr = { "Sylhet","Rajshahi","Chittagong","Rangpur"};

    AutoCompleteTextView acTextView2;

    public String src2;
    EditText es2;

    ListView mylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_rentals);
        es2 = (EditText) findViewById(R.id.location);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, des_arr);
        //Find TextView control
        acTextView2 = (AutoCompleteTextView) findViewById(R.id.loc);
        //Set the number of characters the user must type before the drop down list is shown
        acTextView2.setThreshold(0);
        //Set the adapterr
        acTextView2.setAdapter(adapter2);

        src2 =  acTextView2.getText().toString();

        mylist=(ListView) findViewById(R.id.mylistview);

        String[] myos={"Cox's Bajar","Sylhet Ratargul","Kaptai","Panamcity","Saintmartin"};
        int[] myos_img={R.drawable.cox,R.drawable.s1,R.drawable.k1,R.drawable.p1,R.drawable.s1};

        custom myAdap= new custom(this, myos, myos_img);
        mylist.setAdapter(myAdap);

    }

    public void joma (View v)
    {

        Toast.makeText(VacationRentals.this, "your response has been submitted ", Toast.LENGTH_SHORT).show();
    }

}

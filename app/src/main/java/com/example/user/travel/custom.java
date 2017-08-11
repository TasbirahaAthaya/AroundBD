package com.example.user.travel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by DELL on 06-Feb-16.
 */

public class custom extends BaseAdapter {

    String[] names;
    int[] ims;
    Context ct;

    public static LayoutInflater inflater = null;

    public custom(Context mainac, String[] nameofos, int[] osimg) {

        names = nameofos;
        ims = osimg;
        ct = mainac;
        inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyHolder {
        TextView tvs;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        MyHolder myh = new MyHolder();
        View myview;

        myview = inflater.inflate(R.layout.activitycustom, null);
        myh.tvs = (TextView) myview.findViewById(R.id.textviewid);
        myh.img = (ImageView) myview.findViewById(R.id.imageviewid);

        myh.tvs.setText(names[position]);
        myh.img.setImageResource(ims[position]);

       myview.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               if(ct instanceof Rentplace){
                   Intent intent = new Intent(ct.getApplicationContext(), detail.class);
                   ((Rentplace)ct).startActivity(intent);
               }
           }
       });

        return myview;
    }
}



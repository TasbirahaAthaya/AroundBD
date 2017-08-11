package com.example.user.travel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Viewpost> mList;

    public static LayoutInflater inflater=null;

    public MyCustomAdapter(Context mainac)
    {

        context=mainac;
        mList=new ArrayList<>();

    }

    public void setmList(ArrayList<Viewpost> ar){
        mList=new ArrayList<>(ar);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class MyHolder{
        TextView name,email,src,des,cost,detail;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        MyHolder myh;
        if (convertView == null) {
            myh= new MyHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_layout_item, parent, false);
            myh.name = (TextView) convertView.findViewById(R.id.postName);
//        myh.email=(TextView)myview.findViewById(R.id.contactEmail);
            myh.src = (TextView) convertView.findViewById(R.id.trSource);
            myh.des = (TextView) convertView.findViewById(R.id.trDestination);
            myh.cost = (TextView) convertView.findViewById(R.id.costAmount);
            myh.detail = (TextView) convertView.findViewById(R.id.description);
            myh.img = (ImageView) convertView.findViewById(R.id.postImage);
            convertView.setTag(myh);
        }
        else{
            myh = (MyHolder) convertView.getTag();
        }
        myh.name.setText(mList.get(position).names);
//        myh.email.setText(mList.get(position).email);
        myh.src.setText(mList.get(position).src);
        myh.des.setText(mList.get(position).des);
        myh.cost.setText(mList.get(position).cost);
        myh.detail.setText(mList.get(position).detail);
        myh.img.setImageResource(R.drawable.bd);

        return convertView;
    }
}

package com.example.user.travel;

import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by User on 8/5/2017.
 */
public class Json
{

//    public static String[] names;
//    public static String[] cost;
//    public static String[] src;
//    public static String[] des;
//    public static String[] descrip;
//    public static String[] date;

    public static final String JSON_ARRAY = "";
    public static final String KEY_cost = "cost";
    public static final String KEY_NAME = "username";
    public static final String KEY_src = "source";
    public static final String KEY_des = "destination";
    public static final String KEY_descrip = "description";
    public static final String KEY_date = "date";

    private JSONArray users = null;

    private String json;

    public Json(String json){
        this.json = json;
    }

    protected ArrayList<Viewpost> parseJSON(){
        JSONArray jsonArray=null;
        ArrayList<Viewpost> output = new ArrayList<>();
        try {
            jsonArray = new JSONArray(json);
            for( int j=0; j<jsonArray.length();j++) {
                users = jsonArray.getJSONArray(j);
                Log.e("Json.java", users.toString());

//            names = new String[users.length()];
//            cost = new String[users.length()];
//            src = new String[users.length()];
//            des = new String[users.length()];
//            descrip = new String[users.length()];
//            date = new String[users.length()];

                for (int i = 0; i < users.length(); i++) {
                    JSONObject jo = users.getJSONObject(i);
                    Viewpost viewpost = new Viewpost();
                    viewpost.names = jo.getString(KEY_NAME);
                    viewpost.cost = jo.getString(KEY_cost);
                    viewpost.src = jo.getString(KEY_src);
                    viewpost.des = jo.getString(KEY_des);
                    viewpost.detail = jo.getString(KEY_descrip);
                    viewpost.date = jo.getString(KEY_date);
                    output.add(viewpost);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return output;
    }
}
    


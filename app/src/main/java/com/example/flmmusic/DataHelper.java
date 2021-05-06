package com.example.flmmusic;

import android.content.Context;
import android.content.SharedPreferences;

public class DataHelper {


    private static Context context;

    public DataHelper(Context context){
        this.context=context;
    }
    //Int değer döndürdüğünde
    public static  void saveDataInt (String s, int i){
        SharedPreferences preferences=context.getSharedPreferences("PREFS",0);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt(s,i);
        editor.commit();
    }

    public static  int receiveDataInt(String s,int  i){
        SharedPreferences preferences=context.getSharedPreferences("PREFS",0);
        int points=preferences.getInt(s,i);
        return  points;
    }
    //String değer döndürdüğünde
    public static  void saveDataString (String s,String i){
        SharedPreferences preferences=context.getSharedPreferences("PREFS",0);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(s,i);
        editor.commit();
    }


    public static String receiveDataString(String s, String i){
        SharedPreferences preferences=context.getSharedPreferences("PREFS",0);
        String points=preferences.getString (s,i);
        return  points;
    }

    //Boolaen değer döndürdüğünde
    public static  void saveDataBoolean (String s,boolean i){
        SharedPreferences preferences=context.getSharedPreferences("PREFS",0);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(s,i);
        editor.commit();
    }

    public static  boolean receiveDataboolean(String s,boolean  i){
        SharedPreferences preferences=context.getSharedPreferences("PREFS",0);
        boolean points=preferences.getBoolean (s,i);
        return  points;
    }
}

package com.farisalchaula.myapplication.session;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.farisalchaula.myapplication.admin.HomeAdminActivity;
import com.farisalchaula.myapplication.pembeli.HomePembeli;

public class PrefSetting {

    public static String _id;
    public static String username;
    public static String password;
    public static String role;
    public static String email;
    Activity activity;

    public  PrefSetting(Activity activity){
        this.activity = activity;
    }

    public SharedPreferences getSharePreferences(){
        SharedPreferences preferences = activity.getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        return preferences;
    }

    public void isLogin(SessionManager session, SharedPreferences pref){
        session = new SessionManager(activity);
        if (session.isLoggedIn()){
            pref = getSharePreferences();
            _id = pref.getString("_id", "");
            username = pref.getString("username", "");
            password = pref.getString("password", "");
            role = pref.getString("role", "");
            email = pref.getString("email", "");
        }else {
            session.setLogin(false);
            session.setSessid(0);
            Intent i = new Intent(activity, activity.getClass());
            activity.startActivity(i);
            activity.finish();
        }
    }

    public void checkLogin(SessionManager session, SharedPreferences pref){
        session = new SessionManager(activity);
        _id = pref.getString("_id", "");
        username = pref.getString("username", "");
        password = pref.getString("password", "");
        role = pref.getString("role", "");
        email = pref.getString("email", "");
        if (session.isLoggedIn()){
            if (role.equals("1")){
                Intent i = new Intent(activity, HomeAdminActivity.class);
                activity.startActivity(i);
                activity.finish();
            }else {
                Intent i = new Intent(activity, HomePembeli.class);
                activity.startActivity(i);
                activity.finish();
            }
        }
    }

    public void storeRegIdSharedPreferences(Context context, String _id, String username,
                                            String password, String role, String email, SharedPreferences prefs){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("_id", _id);
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putString("role", role);
        editor.putString("email", email);
        editor.commit();
    }
}

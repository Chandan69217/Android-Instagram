package com.chandan.instagram.splashscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.view.WindowCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.chandan.instagram.MainActivity;
import com.chandan.instagram.R;
import com.chandan.instagram.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //WindowCompat.setDecorFitsSystemWindows(getWindow(),false);

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent NextActivity;
               SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
               boolean check = pref.getBoolean("flag",false);
               if(check){
                   NextActivity = new Intent(getApplicationContext(), MainActivity.class);
               }else{
                   NextActivity = new Intent(getApplicationContext(), LoginActivity.class);
               }
               startActivity(NextActivity);
               finish();
           }
       },4000);
    }
}
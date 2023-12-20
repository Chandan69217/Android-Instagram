package com.chandan.instagram.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import com.chandan.instagram.R;

public class LoginActivity extends AppCompatActivity {
    FragmentManager fm;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.login_frame,new Quick_login_Fragment());
        ft.commit();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
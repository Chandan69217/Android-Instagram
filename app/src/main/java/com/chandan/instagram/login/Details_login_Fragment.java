package com.chandan.instagram.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.chandan.instagram.MainActivity;
import com.chandan.instagram.R;


public class Details_login_Fragment extends Fragment {

    private EditText UsernameEdt,PasswordEdt;
    private TextView ForgotPassTxt,LoginByFacebookTxt,SignUpTxt;
    private AppCompatButton LoginBtn;
    private ImageView ToolBack;
    private String username = "Chandan_03_09",password = "69217";

    private FragmentManager fm;
    FragmentTransaction ft;

    public Details_login_Fragment() {

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details_login_, container, false);
        UsernameEdt = view.findViewById(R.id.username_edtext);
        PasswordEdt = view.findViewById(R.id.password_edtext);
        ForgotPassTxt = view.findViewById(R.id.forgot_pass_txt);
        LoginByFacebookTxt = view.findViewById(R.id.login_by_facebook_txt);
        SignUpTxt = view.findViewById(R.id.sign_up_txt);
        LoginBtn = view.findViewById(R.id.login_btn);
        ToolBack = view.findViewById(R.id.tool_back_img);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("flag",true);
                if(username.equalsIgnoreCase(UsernameEdt.getText().toString()) && password.equalsIgnoreCase(PasswordEdt.getText().toString())){
                    editor.commit();
                    getActivity().finish();
                    Intent mainActivity = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                    startActivity(mainActivity);
                }
            }
        });
        ToolBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm = getActivity().getSupportFragmentManager();
                ft = fm.beginTransaction();

                ft.replace(R.id.login_frame,new Quick_login_Fragment());
                fm.popBackStack();
                ft.commit();

            }
        });
        return view;
    }
}
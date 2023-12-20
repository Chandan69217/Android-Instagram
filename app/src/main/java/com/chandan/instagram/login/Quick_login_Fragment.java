package com.chandan.instagram.login;

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
import android.widget.TextView;
import android.widget.Toast;

import com.chandan.instagram.MainActivity;
import com.chandan.instagram.R;

public class Quick_login_Fragment extends Fragment {
    AppCompatButton loginBtn;
    TextView switchAccTxt,signUpTxt;
    public Quick_login_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quick_login_, container, false);
        loginBtn = view.findViewById(R.id.login_btn);
        switchAccTxt = view.findViewById(R.id.switch_acc_txt);
        signUpTxt = view.findViewById(R.id.sign_up_txt);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("flag",true);
                editor.commit();
                getActivity().finish();
                Intent mainActivity = new Intent(getActivity(), MainActivity.class);
                startActivity(mainActivity);
            }
        });

        switchAccTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("switch Account Clicked","Clicked");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.login_frame,new Details_login_Fragment());
                ft.addToBackStack("second fragment");
                ft.commit();
            }
        });

        signUpTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"This function will introduced later",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }


}
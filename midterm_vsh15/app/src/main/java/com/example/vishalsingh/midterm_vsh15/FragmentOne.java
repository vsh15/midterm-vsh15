package com.example.vishalsingh.midterm_vsh15;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FragmentOne extends Fragment {


   TextView number1;

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_one, container, false);

        number1 = (TextView)view.findViewById(R.id.singleNumber);

     Bundle args =getArguments();

     if (args!=null){


      number1.setText("num");

     }

        int var = (int)(Math.random()*10+1);
        String numVariable = var +"";
        number1.setText(numVariable);

        return view;

    }
}
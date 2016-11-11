package com.example.vishalsingh.midterm_vsh15;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class FragmentTwo extends Fragment {

    TextView numbertop,numberbottom;
    TextView Symbol;
    public FragmentTwo() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        numbertop = (TextView)view.findViewById(R.id.topNumber);
        numberbottom = (TextView)view.findViewById(R.id.bottomNumber);

        Symbol = (TextView)view.findViewById(R.id.symbol);


        Bundle args =getArguments();

        if (args!=null){

            numbertop.setText("num1");
            numberbottom.setText("num2");

        }
        else
        {

        }



        Symbol.setText("+");

        return view;
    }



}

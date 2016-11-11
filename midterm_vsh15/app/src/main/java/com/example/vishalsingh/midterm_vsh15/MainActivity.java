package com.example.vishalsingh.midterm_vsh15;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<>();
    ArrayList<Integer[]> gameDetails = new ArrayList<Integer[]>();
    Button buttonleft;
    Button buttonright;
    int var,var1,var2;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       buttonleft = (Button) findViewById(R.id.button_left);
        buttonright = (Button) findViewById(R.id.button_right);
        list.add("Game1");
        list.add("Game2");


        //code to retrieve from the text

/*
        if(savedInstanceState != null){
            list = savedInstanceState.getStringArrayList("arrayListTasks");

            populateList(list);
        }
        else if(fileExists("tasks.txt")){

            try {
                Scanner loadListState = new Scanner(openFileInput("ListState1.txt"));

                while (loadListState.hasNextLine()){
                    String[] lineSplit = loadListState.nextLine().split("\t");
                    list.add(lineSplit[0]);

                }
                populateList(list);
            } catch (FileNotFoundException e) {
                Log.wtf("FileWriter", e);
                e.printStackTrace();
            }
        }


  */
        listView = (ListView)findViewById(R.id.taskList);


        int temp =(int) (Math.random()*1+1);


        if (temp == 1) {

            Bundle args = new Bundle();

            var = (int)(Math.random()*10+1);
            String numVariable = var +"";

            args.putString("num",numVariable);



            Fragment newFragment1 = new FragmentOne();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_left, newFragment1);
            transaction.addToBackStack(null);
            transaction.commit();


            Bundle args1 = new Bundle();

             var1 = (int)(Math.random()*5+1);
            String numVariable1 = var1 +"";

            var2 = (int)(Math.random()*5+1);
            String numVariable2 = var2 +"";

            args1.putString("num1",numVariable1);
            args1.putString("num2",numVariable2);
            Fragment newFragment2 = new FragmentTwo();

            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
            transaction1.replace(R.id.fragment_right, newFragment2);
            transaction1.addToBackStack(null);
            transaction1.commit();
        }

        else
        {
            Bundle args = new Bundle();

            var = (int)(Math.random()*10+1);
            String numVariable = var +"";

            args.putString("num",numVariable);



            Fragment newFragment1 = new FragmentOne();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_right, newFragment1);
            transaction.addToBackStack(null);
            transaction.commit();


            Bundle args1 = new Bundle();

            var1 = (int)(Math.random()*5+1);
            String numVariable1 = var1 +"";

            var2 = (int)(Math.random()*5+1);
            String numVariable2 = var2 +"";

            args1.putString("num1",numVariable1);
            args1.putString("num2",numVariable2);
            Fragment newFragment2 = new FragmentTwo();

            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
            transaction1.replace(R.id.fragment_left, newFragment2);
            transaction1.addToBackStack(null);
            transaction1.commit();


        }
        populateList(list);




        buttonright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(var<(var1+var2))
                {
                    //correct answer
                    Toast.makeText(getApplicationContext(), "Correct Answer",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    //wrong answer;
                    Toast.makeText(getApplicationContext(), "Wrong Answer",Toast.LENGTH_SHORT).show();

                }


            }
        });


        buttonleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(var >(var1+var2))
                {
                    //correct answer
                    Toast.makeText(getApplicationContext(), "Correct Answer",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    //wrong answer;
                    Toast.makeText(getApplicationContext(), "Wrong Answer",Toast.LENGTH_SHORT).show();

                }


            }
        });

    }


    public void setListFromFrag(String[] listFromFrag){
        list.add(listFromFrag[0]);
        populateList(list);

    }






    public void populateList(ArrayList<String> listToSet){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listToSet);
        listView.setAdapter(adapter);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putStringArrayList("arrayListTasks", list);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null){
            list = savedInstanceState.getStringArrayList("arrayListTasks");

            populateList(list);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        try {
            PrintStream output = new PrintStream(openFileOutput("tasks.txt", MODE_PRIVATE));
            for(int i = 0; i < list.size(); i++){
                output.println(list.get(i));
            }
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private boolean fileExists(String fileName){
        File file = getBaseContext().getFileStreamPath(fileName);
        return file.exists();
    }


}

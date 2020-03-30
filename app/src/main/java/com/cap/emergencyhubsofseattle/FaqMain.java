package com.cap.emergencyhubsofseattle;

import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FaqMain extends AppCompatActivity {


    ExpandableListView expandableTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("FAQ OnCreate", "started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faqmain);

        Log.i("FAQ OnCreate", "set the view");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        if(ab!=null){
            ab.setTitle("FREQUENTLY ASKED QUESTIONS");
            ab.setDisplayHomeAsUpEnabled(true);
        }

        expandableTextView=findViewById(R.id.eTV);
        Log.i("FAQ OnCreate", "found expandable text view");
        ExpandableTextViewAdapter adapter = new ExpandableTextViewAdapter(FaqMain.this);
        expandableTextView.setAdapter(adapter);



    }




}

package com.cap.seattleemergencyhubs;

import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;

public class FaqMain extends AppCompatActivity {


    ExpandableListView expandableTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("FAQ OnCreate", "started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faqmain);
        Log.i("FAQ OnCreate", "set the view");

        expandableTextView=findViewById(R.id.eTV);
        Log.i("FAQ OnCreate", "found expandable text view");
        ExpandableTextViewAdapter adapter = new ExpandableTextViewAdapter(FaqMain.this);
        expandableTextView.setAdapter(adapter);
        Log.i("FAQ OnCreate expandableTextView", "set the expandable text view");

    }




}

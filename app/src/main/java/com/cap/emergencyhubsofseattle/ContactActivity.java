package com.cap.emergencyhubsofseattle;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;



    public class ContactActivity extends AppCompatActivity {


        public String theUrl;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_contact);


            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            ActionBar ab = getSupportActionBar();

            if(ab!=null){
                ab.setTitle("CONTACTS");
                ab.setDisplayHomeAsUpEnabled(true);
            }
        }

        public void buttonOnClick(View view) {
            Log.i("On button click", "started");
            Log.i("View ", view.toString());
            switch(view.getId())
            {
                case R.id.contactBtn:

                    theUrl = "http://seattleemergencyhubs.org/contact-us/";
                    uriGo(theUrl);
                    break;

                case R.id.fab:

                    Intent emailIntent = new Intent(
                            android.content.Intent.ACTION_SEND);
                    emailIntent.setAction(Intent.ACTION_SEND);
                    emailIntent.setType("message/rfc822");
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                            new String[] { "info@seattleemergencyhubs.org" });
                    emailIntent.putExtra(android.content.Intent.EXTRA_CC, "");

                    emailIntent.putExtra(android.content.Intent.EXTRA_BCC, "");
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                            "");
                    //emailIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(Detail));
                    emailIntent.setType("text/html");
                    //emailIntent.setData(Uri.parse("mailto:info@seattleemergencyhubs.org"));

// FOLLOWING STATEMENT CHECKS WHETHER THERE IS ANY APP THAT CAN HANDLE OUR EMAIL INTENT
                    try {
                        startActivity(Intent.createChooser(emailIntent,
                                "Send Email Using: "));
                    } catch (ActivityNotFoundException e) {
                       // Handle case where no email app is available

                 }

                    Log.i("Started emailIntent", "activity");

            }
        }

        private void uriGo(String theurl) {
            Log.i("uriGo", "started");
            Uri urlstr = Uri.parse(theurl);
            Intent urlintent = new Intent();
            urlintent.setData(urlstr);
            urlintent.setAction(Intent.ACTION_VIEW);
            startActivity(urlintent);
        }


    }


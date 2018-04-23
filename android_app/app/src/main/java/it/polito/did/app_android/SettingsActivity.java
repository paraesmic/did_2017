package it.polito.did.app_android;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);

                // Display the fragment as the main content.
                getFragmentManager().beginTransaction()
                        .replace(android.R.id.content, new SettingsFragment())
                        .commit();

            Intent intent = getIntent();

            Toolbar myToolbar = findViewById(R.id.my_toolbar);
            setSupportActionBar(myToolbar);
            ActionBar actionBar = getActionBar();

            android.support.v7.app.ActionBar ab = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);


        }



    }

    //DA TRASFORMARE IN FRAGMENT
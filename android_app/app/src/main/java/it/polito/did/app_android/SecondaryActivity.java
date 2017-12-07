package it.polito.did.app_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Intent intent = getIntent();
        //// LampManager manager= LampManager.getInstance(); //di nuovo?
//    Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
//    setSupportActionBar(myToolbar);
    }
}

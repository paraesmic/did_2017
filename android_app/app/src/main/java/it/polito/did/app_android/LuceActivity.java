package it.polito.did.app_android;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class LuceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luce);

        Intent intent = getIntent();

//        Toolbar myToolbar = findViewById(R.id.my_toolbar);
//        setSupportActionBar(myToolbar);
//        ActionBar bar = getActionBar();
//        bar.setDisplayShowHomeEnabled(true);

//        myToolbar.setNavigationIcon(R.drawable.backarrow);
//
//        myToolbar.setNavigationOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        startActivity(new Intent(LuceActivity.this, SecondaryActivity.class));
//                    }
//                }
//
//        );
    }
}

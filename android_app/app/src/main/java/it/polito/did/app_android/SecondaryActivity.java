package it.polito.did.app_android;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Intent intent = getIntent();
        //// LampManager manager= LampManager.getInstance(); //di nuovo?
       Toolbar myToolbar = findViewById(R.id.my_toolbar);
      setSupportActionBar(myToolbar);
      ActionBar actionBar = getActionBar();


//        myToolbar.setNavigationIcon(R.drawable.backarrow);
//        myToolbar.setNavigationOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        startActivity(new Intent(SecondaryActivity.this, MainActivity.class));
//                    }
//                }
//
//        );


        Button bottone_movimento = findViewById(R.id.bottone_movimento);
        Button bottone_luce = findViewById(R.id.bottone_luce);

        bottone_luce.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     startActivity(new Intent(SecondaryActivity.this, LuceActivity.class));
                                                 }
                                             }

        );
        bottone_movimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondaryActivity.this, MovimentoActivity.class));
            }
        }
        );
    }
}


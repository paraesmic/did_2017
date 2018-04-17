package it.polito.did.app_android;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

      android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_update:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }


    }

}


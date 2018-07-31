package it.polito.did.app_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public class SettingsActivity extends AppCompatActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_settings);

                // Display the fragment as the main content.
                getFragmentManager().beginTransaction()
                        .replace(R.id.replaceable, new SettingsFragment())
                        .commit();

            Intent intent = getIntent();

           Toolbar myToolbar = findViewById(R.id.my_toolbar);
          setSupportActionBar(myToolbar);
            ActionBar ab = getSupportActionBar();
            Log.i("a", "ok");
            ab.setDisplayHomeAsUpEnabled(true);
            Log.i("b", "no");
        }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }


    }


}


package it.polito.did.app_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.SaturationBar;

import java.util.List;

public class LuceActivity extends AppCompatActivity {

    LampManager manager = LampManager.getInstance();
    final List<Lampada> lista_lampade = manager.getLamps();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luce);

        Intent intent = getIntent();
        ColorPicker picker = findViewById(R.id.colorPicker);
//        SVBar svBar = (SVBar) findViewById(R.id.svbar);
        SaturationBar saturationBar = findViewById(R.id.saturationbar);

//        picker.addSVBar(svBar);

        picker.addSaturationBar(saturationBar);


//To get the color
        picker.getColor();

//To set the old selected color u can do it like this
        picker.setOldCenterColor(picker.getColor());

//to turn of showing the old color
        picker.setShowOldCenterColor(false);

         Toolbar myToolbar = findViewById(R.id.my_toolbar);

          setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
         ab.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.secondarymenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(LuceActivity.this, SettingsActivity.class));

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

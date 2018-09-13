package it.polito.did.app_android;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.SaturationBar;

public class LuceActivity extends AppCompatActivity {

    LampManager manager = LampManager.getInstance();
    int currentLamp_index = manager.getCurrent_lamp();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luce);
//        Bundle bundle = getIntent().getExtras();
//        currentLamp_index= bundle.getInt("currentLamp_index");
        final Lampada current = manager.lista_lampade.get(currentLamp_index);

        Intent intent = getIntent();
        ColorPicker picker = findViewById(R.id.colorPicker);
//        SVBar svBar = (SVBar) findViewById(R.id.svbar);
        SaturationBar saturationBar = findViewById(R.id.saturationbar);

//        picker.addSVBar(svBar);

        picker.addSaturationBar(saturationBar);


//To get the color
        picker.setColor(Color.parseColor("#FFdF60"));
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

            case R.id.action_changeview:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            case R.id.home:
                Intent intent = new Intent(LuceActivity.this, SecondaryActivity.class);
                intent.putExtra("currentLamp_index", currentLamp_index );
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }


    }

}

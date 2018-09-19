package it.polito.did.app_android;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;

public class LuceActivity extends AppCompatActivity {

    LampManager manager = LampManager.getInstance();
    int currentLamp_index = manager.getCurrent_lamp();
    final Lampada current = manager.lista_lampade.get(currentLamp_index);
    int initial_color = current.getColor();
    int new_color;
    public UDPCommunication udp_task = manager.getUdp_task();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_luce);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        final ColorPicker picker = findViewById(R.id.colorPicker);
        SaturationBar saturationBar = findViewById(R.id.saturationbar);
        ValueBar valueBar = findViewById(R.id.valuebar);
        picker.addSaturationBar(saturationBar);
        picker.addValueBar(valueBar);


        picker.setColor(initial_color);
        Log.e("AttivitaLuce", "il colore del picker è:  " + initial_color);

//To set the old selected color u can do it like this

        picker.setNewCenterColor(initial_color);
//to turn of showing the old color
        picker.setShowOldCenterColor(false);
        Button ripristina = findViewById(R.id.btn_ripristina);
        ripristina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    picker.setColor(initial_color);
                    current.setColor(initial_color);

            }
        });

        Button conferma = findViewById(R.id.btn_conferma);
        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new_color = picker.getColor();
                current.setColor(new_color);
                udp_task.sendUDP("RGB:" + Color.red(new_color) + "," + Color.green(new_color) + "," + Color.blue(new_color), current.getIpAddress());
                startActivity(new Intent(LuceActivity.this,SecondaryActivity.class));
            }
        });

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

            case R.id.home:
                Intent intent = new Intent(LuceActivity.this, SecondaryActivity.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }


    }

}

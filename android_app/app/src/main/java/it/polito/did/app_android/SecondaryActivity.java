package it.polito.did.app_android;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;


public class SecondaryActivity extends AppCompatActivity {

    LampManager manager = LampManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Bundle bundle = getIntent().getExtras();
        final int currentLamp_index = bundle.getInt("currentLamp_index");
        final Lampada current = manager.lista_lampade.get(currentLamp_index);


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

        //settaggio nome
        TextView name = findViewById(R.id.nomeLampada_secondary);
        name.setText(current.getNome());

        //settaggio intensità
        SeekBar sb = findViewById(R.id.barra_intensita);
        int current_intensity = current.getIntensity();
        sb.setProgress(current_intensity);
        //funzionamento seekbar e salvataggio dati
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            Lampada current = manager.lista_lampade.get(currentLamp_index);
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                current.setIntensity(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //settaggio On/Off
        Switch sw = findViewById(R.id.switch_secondary);
        sw.setChecked(current.isOn);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    if(b){
                        current.turnOn();
                        Log.i("switchSecondary", "on");

                    }
                    if(!b){
                        current.turnOff();
                        Log.i("switchSecondary", "off");

                    }
            }
        });

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
        getMenuInflater().inflate(R.menu.secondarymenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(SecondaryActivity.this, SettingsActivity.class));
                return true;
            case android.R.id.home:
                Intent intent = new Intent(SecondaryActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}


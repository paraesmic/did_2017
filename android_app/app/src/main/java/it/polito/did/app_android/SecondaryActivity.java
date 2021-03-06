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
import android.widget.Switch;
import android.widget.TextView;


public class SecondaryActivity extends AppCompatActivity {

    LampManager manager = LampManager.getInstance();
    int currentLamp_index = manager.getCurrent_lamp();
    private UDPCommunication UDPAsynctask = manager.getUdp_task();
    final Lampada current = manager.lista_lampade.get(currentLamp_index);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);


        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar actionBar = getActionBar();

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Switch sw = findViewById(R.id.switch_secondary);
        TextView name = findViewById(R.id.nomeLampada_secondary);
        Button bottone_movimento = findViewById(R.id.bottone_movimento);
        Button bottone_luce = findViewById(R.id.bottone_luce);
       //SET UI
        name.setText(current.getNome());
        sw.setChecked(current.isOn);



        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    if(b){
                        current.turnOn();
                        UDPAsynctask.sendUDP("PWR:true", current.ipAddress);
                        Log.i("switchSecondary", "on");


                    }
                    if(!b){
                        current.turnOff();
                        UDPAsynctask.sendUDP("PWR:false", current.ipAddress);
                        Log.i("switchSecondary", "off");

                    }
            }
        });

        bottone_luce.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     Intent intent = new Intent(view.getContext(), LuceActivity.class);
                                                     intent.putExtra("currentLamp_index", currentLamp_index);
                                                     view.getContext().startActivity(intent);
                                                 }
                                             }
                                             );

        bottone_movimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MovimentoActivity.class);
                intent.putExtra("currentLamp_index", currentLamp_index);
                view.getContext().startActivity(intent);
            }
        }
        );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Switch sw = findViewById(R.id.switch_secondary);
        sw.setChecked(current.isOn);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Switch sw = findViewById(R.id.switch_secondary);
        sw.setChecked(current.isOn);
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
                startActivity(new Intent(SecondaryActivity.this,  InfoActivity.class));
                return true;
            case R.id.home:
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


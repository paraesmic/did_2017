package it.polito.did.app_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import radial.semicircularmenu.SemiCircularRadialMenu;
import radial.semicircularmenu.SemiCircularRadialMenuItem;

public class MovimentoActivity extends AppCompatActivity {

    LampManager manager = LampManager.getInstance();
    int currentLamp_index = manager.getCurrent_lamp();
    UDPCommunication udpTask = manager.getUdp_task();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimento);
        final Lampada current = manager.lista_lampade.get(currentLamp_index);

        Intent intent = getIntent();

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        final SemiCircularRadialMenu menu = findViewById(R.id.radial_menu);
        menu.setOpenMenuText("Seleziona posizione");
        menu.setCloseMenuText("Chiudi");

        final GifImageView gif = findViewById(R.id.gif_posizione);
        TextView testo = findViewById(R.id.testo_posizione_corrente);
        switch(current.getCurrent_pos()){

            case 100:
                try {
                    gif.setImageDrawable(new GifDrawable(getResources(), R.drawable.png_0_degrees));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 135:
                gif.setImageResource(R.drawable.png_45_degrees);
                testo.setText("POSIZIONE 45°");
                break;
            case 170:
                gif.setImageResource(R.drawable.png_90_degrees);
                testo.setText("POSIZIONE 90°");
                break;
        }




        int drawableResourceId1 = this.getResources().getIdentifier("icon_0_degrees", "drawable", this.getPackageName());
        int drawableResourceId3 = this.getResources().getIdentifier("icon_45_degrees", "drawable", this.getPackageName());
        int drawableResourceId4 = this.getResources().getIdentifier("icon_90_degrees", "drawable", this.getPackageName());

        final SemiCircularRadialMenuItem item_1 =  new SemiCircularRadialMenuItem("primoItem", getApplicationContext().getResources().getDrawable(drawableResourceId1),"posizione1");
        final SemiCircularRadialMenuItem item_3 =  new SemiCircularRadialMenuItem("terzoItem", getApplicationContext().getResources().getDrawable(drawableResourceId3),"posizione3");
        final SemiCircularRadialMenuItem item_4 =  new SemiCircularRadialMenuItem("quartoItem", getApplicationContext().getResources().getDrawable(drawableResourceId4),"posizione4");



        menu.addMenuItem("primoItem", item_1);
        menu.addMenuItem("terzoItem", item_3);
        menu.addMenuItem("quartoItem", item_4);






        item_1.setOnSemiCircularRadialMenuPressed(new SemiCircularRadialMenuItem.OnSemiCircularRadialMenuPressed() {
            @Override
            public void onMenuItemPressed() {
                GifImageView gif = findViewById(R.id.gif_posizione);
                TextView testo = findViewById(R.id.testo_posizione_corrente);
                testo.setText("POSIZIONE 0°");
                gif.setImageResource(R.drawable.png_0_degrees);
                udpTask.sendUDP("MOV:100", current.getIpAddress());
                Log.i("item_1", " testo cambiato");
                menu.dismissMenu();
            }
        });

        item_3.setOnSemiCircularRadialMenuPressed(new SemiCircularRadialMenuItem.OnSemiCircularRadialMenuPressed() {
            @Override
            public void onMenuItemPressed() {
                final GifImageView gif = findViewById(R.id.gif_posizione);
                TextView testo = findViewById(R.id.testo_posizione_corrente);
                testo.setText("POSIZIONE 45°");
                gif.setImageResource(R.drawable.png_45_degrees);
                udpTask.sendUDP("MOV:135", current.getIpAddress());
                Log.i("item_3", " testo cambiato");
                menu.dismissMenu();
            }
        });

        item_4.setOnSemiCircularRadialMenuPressed(new SemiCircularRadialMenuItem.OnSemiCircularRadialMenuPressed() {
            @Override
            public void onMenuItemPressed() {
                final GifImageView gif = findViewById(R.id.gif_posizione);
                TextView testo = findViewById(R.id.testo_posizione_corrente);
                testo.setText("POSIZIONE 90°");
                gif.setImageResource(R.drawable.png_90_degrees);
                udpTask.sendUDP("MOV:170", current.getIpAddress());
                Log.i("item_4", " testo cambiato");
                menu.dismissMenu();
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
                startActivity(new Intent(MovimentoActivity.this, SettingsActivity.class));
                return true;

            case R.id.home:
                Intent intent = new Intent(MovimentoActivity.this, SecondaryActivity.class);
                startActivity(intent);

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }




    }
}


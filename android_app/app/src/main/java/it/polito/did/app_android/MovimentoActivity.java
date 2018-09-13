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

import radial.semicircularmenu.SemiCircularRadialMenu;
import radial.semicircularmenu.SemiCircularRadialMenuItem;

public class MovimentoActivity extends AppCompatActivity {

    LampManager manager = LampManager.getInstance();
    int currentLamp_index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimento);
        Bundle bundle = getIntent().getExtras();
        currentLamp_index= bundle.getInt("currentLamp_index");
        final Lampada current = manager.lista_lampade.get(currentLamp_index);

        Intent intent = getIntent();

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        final SemiCircularRadialMenu menu = findViewById(R.id.radial_menu);
        menu.setOpenMenuText("Seleziona posizione");
        menu.setCloseMenuText("Chiudi");




        int drawableResourceId1 = this.getResources().getIdentifier("lamp1_64", "drawable", this.getPackageName());
        int drawableResourceId3 = this.getResources().getIdentifier("ic_lampada1_round", "mipmap", this.getPackageName());
        int drawableResourceId4 = this.getResources().getIdentifier("ic_lampada2_round", "mipmap", this.getPackageName());
        int drawableResourceId5 = this.getResources().getIdentifier("ic_lampada3_round", "mipmap", this.getPackageName());

        final SemiCircularRadialMenuItem item_1 =  new SemiCircularRadialMenuItem("primoItem", getApplicationContext().getResources().getDrawable(drawableResourceId1),"posizione1");
         final SemiCircularRadialMenuItem item_3 =  new SemiCircularRadialMenuItem("terzoItem", getApplicationContext().getResources().getDrawable(drawableResourceId3),"posizione3");
        final SemiCircularRadialMenuItem item_4 =  new SemiCircularRadialMenuItem("quartoItem", getApplicationContext().getResources().getDrawable(drawableResourceId4),"posizione4");
        final SemiCircularRadialMenuItem item_5 =  new SemiCircularRadialMenuItem("quintoItem", getApplicationContext().getResources().getDrawable(drawableResourceId4),"posizione5");



        menu.addMenuItem("primoItem", item_1);
        menu.addMenuItem("terzoItem", item_3);
        menu.addMenuItem("quartoItem", item_4);
        menu.addMenuItem("quintoItem", item_5);





        item_1.setOnSemiCircularRadialMenuPressed(new SemiCircularRadialMenuItem.OnSemiCircularRadialMenuPressed() {
            @Override
            public void onMenuItemPressed() {
                TextView testo = findViewById(R.id.testo_posizione_corrente);
                testo.setText(item_1.getText());
                Log.i("item_1", " testo cambiato");
                menu.dismissMenu();
            }
        });

        item_3.setOnSemiCircularRadialMenuPressed(new SemiCircularRadialMenuItem.OnSemiCircularRadialMenuPressed() {
            @Override
            public void onMenuItemPressed() {
                TextView testo = findViewById(R.id.testo_posizione_corrente);
                testo.setText(item_3.getText());
                Log.i("item_3", " testo cambiato");
                menu.dismissMenu();
            }
        });

        item_4.setOnSemiCircularRadialMenuPressed(new SemiCircularRadialMenuItem.OnSemiCircularRadialMenuPressed() {
            @Override
            public void onMenuItemPressed() {
                TextView testo = findViewById(R.id.testo_posizione_corrente);
                testo.setText(item_4.getText());
                Log.i("item_4", " testo cambiato");
                menu.dismissMenu();
            }
        });
        item_5.setOnSemiCircularRadialMenuPressed(new SemiCircularRadialMenuItem.OnSemiCircularRadialMenuPressed() {
            @Override
            public void onMenuItemPressed() {
                TextView testo = findViewById(R.id.testo_posizione_corrente);
                testo.setText(item_5.getText());
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
                intent.putExtra("currentLamp_index", currentLamp_index );
                startActivity(intent);

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }




    }

}

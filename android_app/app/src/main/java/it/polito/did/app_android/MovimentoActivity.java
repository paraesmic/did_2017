package it.polito.did.app_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import radial.semicircularmenu.SemiCircularRadialMenu;
import radial.semicircularmenu.SemiCircularRadialMenuItem;

public class MovimentoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimento);

        Intent intent = getIntent();

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        SemiCircularRadialMenu menu = findViewById(R.id.radial_menu);

        int drawableResourceId = this.getResources().getIdentifier("lamp1_64", "drawable", this.getPackageName());
//        int drawableResourceId2 = this.getResources().getIdentifier("Icona1_64", "drawable", this.getPackageName());
//        int drawableResourceId3 = this.getResources().getIdentifier("Icona2_64", "drawable", this.getPackageName());
//        int drawableResourceId4 = this.getResources().getIdentifier("Icona1_64", "drawable", this.getPackageName());
        SemiCircularRadialMenuItem item_1 =  new SemiCircularRadialMenuItem("primoItem", getApplicationContext().getResources().getDrawable(drawableResourceId),"ciao");
        SemiCircularRadialMenuItem item_2 =  new SemiCircularRadialMenuItem("secondoItem", getApplicationContext().getResources().getDrawable(drawableResourceId),"ciao");
        SemiCircularRadialMenuItem item_3 =  new SemiCircularRadialMenuItem("terzoItem", getApplicationContext().getResources().getDrawable(drawableResourceId),"ciao");
        SemiCircularRadialMenuItem item_4 =  new SemiCircularRadialMenuItem("quartoItem", getApplicationContext().getResources().getDrawable(drawableResourceId),"ciao");
        SemiCircularRadialMenuItem item_5 =  new SemiCircularRadialMenuItem("quintoItem", getApplicationContext().getResources().getDrawable(drawableResourceId),"ciao");

        menu.addMenuItem("primoItem", item_1);
        menu.addMenuItem("secondoItem ", item_2);
        menu.addMenuItem("terzoItem", item_3);
        menu.addMenuItem("quartoItem", item_4);
        menu.addMenuItem("quintoItem", item_5);


//        myToolbar.setNavigationIcon(R.drawable.backarrow);
//        myToolbar.setNavigationOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        startActivity(new Intent(MovimentoActivity.this, SecondaryActivity.class));
//                    }
//                }
//
//        );
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


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }




    }

}

package it.polito.did.app_android;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        final List<Lampada> lista_lampade = new ArrayList<>();

        // LampManager manager= LampManager.getInstance();
        // manager.discover();  // da usare una volta imparato ad usare il manager!
        int nLampade = 12; //dato che non prendiamo le lampade da nessuna parte facciamo che siano 6
        ListView root = null;
        for (int i = 0; i < nLampade; i++) {
            Lampada lamp = new Lampada("urltemp");
            lista_lampade.add(lamp);
        }

        root = findViewById(R.id.list_layout);
        CustomAdapter adapter = new CustomAdapter(this, (ArrayList<Lampada>) lista_lampade);

        root.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MainActivity.this, SecondaryActivity.class));

            }
        });
        root.setAdapter(adapter);

        for (int i = 0; i < nLampade; i++) {
            GridView lay = findViewById(R.id.grid_layout);
            Lampada lamp = new Lampada("urltemp");
            lista_lampade.add(lamp);
            CustomGridAdapter g_adapter = new CustomGridAdapter(this, (ArrayList<Lampada>) lista_lampade);

            lay.setAdapter(g_adapter);
            lay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    CardView cv = (CardView) view;
                    Lampada lamp = lista_lampade.get(i);
                    if(!lamp.isOn) {
                        cv.setCardBackgroundColor(Color.YELLOW);
                        TextView t = (TextView) view.findViewById(R.id.grid_item_isOn_text);
                        t.setText("ACCESA");
                        lamp.turnOn();
                        Log.i("tag","accendo");

                    }
                    else if(lamp.isOn){
                        cv.setCardBackgroundColor(Color.WHITE);
                        lamp.turnOff();
                        TextView t = (TextView) view.findViewById(R.id.grid_item_isOn_text);
                        t.setText("SPENTA");
                        Log.i("tag","spengo");

                    }
                }
            });

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainmenu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));



        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_search:
                onSearchRequested();
                return true;
            case R.id.action_settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
//                    getFragmentManager().beginTransaction()
//                            .add(R.id.container, new SettingsFragment())
//                            .commit();
                Log.i("Hello", "Hello");
                return true;

            case R.id.action_update:
                ListView lista_layout = (ListView) findViewById(R.id.list_layout);
                GridView grid_layout = (GridView) findViewById(R.id.grid_layout);
                if(lista_layout.getVisibility()== View.VISIBLE) {
                    lista_layout.setVisibility(View.GONE);
                    grid_layout.setVisibility(View.VISIBLE);
                } else {
                    lista_layout.setVisibility(View.VISIBLE);
                    grid_layout.setVisibility(View.GONE);
                }
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }


    }

}



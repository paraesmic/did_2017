package it.polito.did.app_android;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.List;


public class MainActivity extends AppCompatActivity {

    LampManager manager = LampManager.getInstance();
   // ListView lista_layout;
    RecyclerView recycler_layout;
    GridView grid_layout;
    CustomGridAdapter g_adapter;
    RecyclerViewAdapter recyclerViewAdapter;
   // CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // da usare una volta imparato ad usare il manager!
        manager.discover();


        //int nLampade = 12; //dato che non prendiamo le lampade da nessuna parte facciamo che siano 6
       /* for (int i = 0; i < 3; i++) {
            Lampada lamp = new Lampada("urltemp","null", true);
        manager.lista_lampade.add(lamp);
       }*/

       recycler_layout = findViewById(R.id.recycler_layout);
       if(manager.statoMain==0)
           recycler_layout.setLayoutManager(new LinearLayoutManager(this));
       else
           recycler_layout.setLayoutManager(new GridLayoutManager(this,3));

       recyclerViewAdapter = new RecyclerViewAdapter(this);
       recycler_layout.setAdapter(recyclerViewAdapter);
//        ListView root = findViewById(R.id.list_layout);
//        adapter = new CustomAdapter(this);
//        root.setAdapter(adapter);
//
//        grid_layout = findViewById(R.id.grid_layout);
//        g_adapter = new CustomGridAdapter(this);
//        grid_layout.setAdapter(g_adapter);
//
//        //lista_layout = findViewById(R.id.lista_layout);
//
//        //inizializza
//        if ((manager.statoMain == 0)) {
//            recycler_layout.setVisibility(View.VISIBLE);
//            grid_layout.setVisibility(View.GONE);
//        } else {
//            recycler_layout.setVisibility(View.GONE);
//            grid_layout.setVisibility(View.VISIBLE);
//
//        }


    }

    @Override
    protected void onRestart() {
        super.onRestart();
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
                Log.i("Hello", "Hello");
                return true;

            case R.id.action_update:
//                if (recycler_layout.getVisibility() == View.VISIBLE) {
//                    recycler_layout.setVisibility(View.GONE);
//                    grid_layout.setVisibility(View.VISIBLE);
//                    manager.statoMain = 1;
//
//                } else {
//                    recycler_layout.setVisibility(View.VISIBLE);
//                    grid_layout.setVisibility(View.GONE);
//                    manager.statoMain = 0;
//                }
                if(manager.statoMain==0){
                    manager.statoMain=1;
                    recycler_layout.setLayoutManager(new GridLayoutManager(this, 3));
                    recycler_layout.setAdapter(recyclerViewAdapter);
                    recyclerViewAdapter.notifyDataSetChanged();
                }else{
                    manager.statoMain=0;
                    recycler_layout.setLayoutManager(new LinearLayoutManager(this));
                    recycler_layout.setAdapter(recyclerViewAdapter);
                    recyclerViewAdapter.notifyDataSetChanged();
                }
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }


    }

}



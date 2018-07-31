package it.polito.did.app_android;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        List<Lampada> lista_lampade = new ArrayList<>();

        // LampManager manager= LampManager.getInstance();
        // manager.discover();  // da usare una volta imparato ad usare il manager!
        int nLampade = 12; //dato che non prendiamo le lampade da nessuna parte facciamo che siano 6
        ListView root = null;
        for (int i = 0; i < nLampade; i++) {
            Lampada lamp = new Lampada("urltemp");
            lista_lampade.add(lamp);
        }

        root = findViewById(R.id.lista_lampade);
        CustomAdapter adapter = new CustomAdapter(this, (ArrayList<Lampada>) lista_lampade);

        root.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MainActivity.this, SecondaryActivity.class));

            }
        });
        root.setAdapter(adapter);

    }

    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.mainmenu, menu);
            return true;
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
//                    getFragmentManager().beginTransaction()
//                            .add(R.id.container, new SettingsFragment())
//                            .commit();
                    Log.i("Hello", "Hello");
                    return true;

                case R.id.action_update:
                    startActivity(new Intent(MainActivity.this, MainGridActivity.class));
                                   List<Lampada> lista_lampade = new ArrayList<>();
                    GridView lay = findViewById(R.id.grid_layout);

                    // LampManager manager= LampManager.getInstance();
                    // manager.discover();  // da usare una volta imparato ad usare il manager!
                    int nLampade = 12; //dato che non prendiamo le lampade da nessuna parte facciamo che siano 6
                    for (int i = 0; i < nLampade; i++) {
                        Lampada lamp = new Lampada("urltemp");
                        lista_lampade.add(lamp);
                        CustomGridAdapter adapter2 = new CustomGridAdapter(this, (ArrayList<Lampada>) lista_lampade);
                        if(lay!=null)
                        lay.setAdapter(adapter2);

                    }
                    return true;

                default:
                    // If we got here, the user's action was not recognized.
                    // Invoke the superclass to handle it.
                    return super.onOptionsItemSelected(item);
            }


    }


}



package it.polito.did.app_android;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Lampada> lista_lampade = new ArrayList<>();
        //
        // LampManager manager= LampManager.getInstance();
        // manager.discover();  // da usare una volta imparato ad usare il manager!
        int nLampade = 6; //dato che non prendiamo le lampade da nessuna parte facciamo che siano 6
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
                Log.i("Hello", "Hello");
            }
        });
        root.setAdapter(adapter);

    }

}



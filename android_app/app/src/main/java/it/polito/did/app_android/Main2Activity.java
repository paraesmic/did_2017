package it.polito.did.app_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        List<Lampada> lista_lampade = new ArrayList<>();
        GridLayout lay = findViewById(R.id.grid_layout);
        //
        // LampManager manager= LampManager.getInstance();
        // manager.discover();  // da usare una volta imparato ad usare il manager!
        int nLampade = 6; //dato che non prendiamo le lampade da nessuna parte facciamo che siano 6
        ListView root = null;
        for (int i = 0; i < nLampade; i++) {
            Lampada lamp = new Lampada("urltemp");
            lista_lampade.add(lamp);
            View v = new View(R.id.grid_item);
            lay.addView( );
        }

    }


}

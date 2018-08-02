package it.polito.did.app_android;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class LampManager {

    public List<Lampada> lista_lampade = new ArrayList<>();
    private boolean flag = true;
    private static final LampManager instance = new LampManager();
    int i = 0;

    private LampManager() {

    }

    public static LampManager getInstance() {
        return instance;
    }

    public List<Lampada> getLamps() {
        return lista_lampade;
    }

    public void setLamps(List<Lampada> lista_nuova){
     this.lista_lampade = lista_nuova;
        return;
    }

    public void discover(/*Runnable done*/) {

        //inizia una ricerca di lampade
        Log.i("avvisoManager", "1");
        int nLampade = 3; //dato che non prendiamo le lampade da nessuna parte facciamo che siano 6
        if (flag == true) {
            for (i = 0; i < nLampade; i++) {
                Lampada lamp = new Lampada("Ciccio" + i, "urltemp", getBoolean());
                lista_lampade.add(lamp);
            }
            flag = false;
        }
        //done.run();
    }

    boolean getBoolean() {

        if (i == 0 || i == 2)
            return true;
        else
            return false;

    }
}


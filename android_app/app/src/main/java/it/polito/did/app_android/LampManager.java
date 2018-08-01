package it.polito.did.app_android;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class LampManager {

    public List<Lampada> lista_lampade = new ArrayList<>();
    private static final LampManager instance = new LampManager();
    private LampManager(){}

    public static LampManager getInstance(){
        return instance;
    }

    public List<Lampada> getLamps(){
        return lista_lampade;
    }

    public void discover(/*Runnable done*/){

        //inizia una ricerca di lampade
        Log.i("avvisoManager", "1");
        int nLampade = 12; //dato che non prendiamo le lampade da nessuna parte facciamo che siano 6
        for (int i = 0; i < nLampade; i++) {
            Lampada lamp = new Lampada("urltemp", getRandomBoolean());
            lista_lampade.add(lamp);
        }
        //done.run();
    }

    public static boolean getRandomBoolean() {
        double b = Math.random();
        if(b<0.5){
            return true;
        } else
            return false;
        }
}

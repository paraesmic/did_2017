package it.polito.did.app_android;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luca on 30/11/2017.
 */

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

    public void discover(Runnable done){

        //inizia una ricerca di lampade
        Lampada lamp = new Lampada("urltemp");
        lista_lampade.add(lamp);
        done.run();
    }
}

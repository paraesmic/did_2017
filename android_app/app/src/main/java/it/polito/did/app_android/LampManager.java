package it.polito.did.app_android;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class LampManager {

    public static List<Lampada> lista_lampade = new ArrayList<>();
    private boolean flag = true;
    private static final LampManager instance = new LampManager();
    public int current_lamp;
    int i = 0;
    public static int statoMain;

    private LampManager() {
        statoMain=0;
    }

    public static LampManager getInstance() {
        return instance;
    }

    public List<Lampada> getLamps() {
        return lista_lampade;
    }

    public void discover(final UDPCommunication udp) {
        udp.execute();
        //addLamp();//da tenere finchè udptask non funge
        //done.run();
    }

    public void addLamp(String ip, String name){
        //inizia una ricerca di lampade
        Log.i("LampManager", " siamo dentro");
   for(int i=0; i<lista_lampade.size();i++){
       if(lista_lampade.get(i).getIpAddress().equals(ip)){
          return;
            }
        }
        Lampada lamp = new Lampada(name, ip, true);
        lista_lampade.add(lamp);
        Log.e("LampManager", "creata Lamp: " + name + "con IP: " + ip);
    }


   public void setCurrent_lamp(int current){
        this.current_lamp=current;
    }

    public int getCurrent_lamp(){
        return current_lamp;
    }
}


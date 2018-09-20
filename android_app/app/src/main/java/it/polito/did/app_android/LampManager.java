package it.polito.did.app_android;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class LampManager {

    public static List<Lampada> lista_lampade = new ArrayList<>();
    private static final LampManager instance = new LampManager();
    public int current_lamp;
    int i = 0;

    public static int statoMain;
    public UDPCommunication udp_task;

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
        this.udp_task=udp;
        udp.execute();
        //addLamp();//da tenere finchè udptask non funge
        //done.run();
    }

    public void addLamp(String ip, String name, String isOn, int color,int current_pos,int currentBattery){
        //inizia una ricerca di lampade
        boolean temp_bool = Boolean.parseBoolean(isOn);
        for(int i = 0; i<getLamps().size(); i++){
            Lampada current = getLamps().get(i);
            if(current.getIpAddress().equals(ip)){
                current.setColor(color);
                current.changePwr(temp_bool);
                current.setCurrent_pos(current_pos);
                current.setBattery(currentBattery);
                Log.e("LampManager", "aggiornata lampada: " + name + "con IP: " + ip);
                return;
            }
        }
        Lampada lamp = new Lampada(name, ip, temp_bool,current_pos,currentBattery);
        lamp.setColor(color);
        lista_lampade.add(lamp);
        Log.e("LampManager", "creata Lamp: " + name + "con IP: " + ip);

    }

    public int getCurrent_lamp(){
        return current_lamp;
    }

    public UDPCommunication getUdp_task() {
        return udp_task;
    }

    public void setBattery(String ip, int currentBattery){
        for(int i = 0; i<getLamps().size();i++){
            Lampada current = getLamps().get(i);
            if(current.getIpAddress().equals(ip)){
                current.setBattery(currentBattery);
            }

        }
    }
}


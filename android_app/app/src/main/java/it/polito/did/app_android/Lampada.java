package it.polito.did.app_android;

import android.graphics.Color;
import android.util.Log;

import java.util.Random;

public class Lampada {
    String nome;
    int RGB;
    int intensity;
    String Picture;
    Boolean isOn;
    String ipAddress;
    boolean battery;
    int current_pos;


    public Lampada(String nome, String ipAddress, Boolean status, int current_pos) {
        this.nome = nome;
        this.ipAddress = ipAddress;
        isOn= status;
        this.current_pos = current_pos;
        int[] rgb_diviso = {250, 250, 150}; //<-----R G B!
        this.setColor(Color.rgb(rgb_diviso[0],rgb_diviso[1],rgb_diviso[2]));
        Log.e("CreazioneLampada", "il colore settato è: Rosso:" +  Color.red(this.getColor()) + " Verde: " + rgb_diviso[1] + " Blu: " + rgb_diviso[2] + " equivalente a int: " + this.getColor());
        Random r = new Random();
        int n = r.nextInt(2);
        if(n == 0){
            Picture = "" + R.drawable.icona1;
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getColor() {
        return RGB;
    }

    public void setColor(int RGB) {
        this.RGB = RGB;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int RGB) {
        this.intensity = intensity;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public Boolean isOn() {
        return isOn;
    }

    public void changePwr(boolean status){
        isOn = status ? true : false;
    }

    public void turnOff(){
        isOn = false;
    }
    public void turnOn() {
        isOn = true;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }


    public boolean isBattery() {
        return battery;
    }

    public void setBattery(boolean battery) {
        this.battery = battery;
    }


    public int getCurrent_pos() {
        return current_pos;
    }

    public void setCurrent_pos(int current_pos) {
        this.current_pos = current_pos;
    }

    public String toString(){
        return nome;
    }

}

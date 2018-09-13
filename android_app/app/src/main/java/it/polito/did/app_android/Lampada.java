package it.polito.did.app_android;

import java.util.Random;

public class Lampada {
    String nome;
    String url;
    int RGB;
    int intensity;
    String Picture;
    Boolean isOn;
    String ipAddress;

    public Lampada(String nome, String ipAddress, Boolean status) {
        this.nome = nome;
        this.ipAddress = ipAddress;
        isOn= status;
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

    public void setIntensity(int intensity) {
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

    public String toString(){
        return nome;
    }

}

package it.polito.did.app_android;

import android.graphics.Bitmap;

/**
 * Created by Luca on 28/11/2017.
 */

public class Lampada {
    String nome;
    String url;
    int RGB;
    int intensity;
    Bitmap Picture;
    Boolean isOn;
    String ipAddress;

    public Lampada(String URL) {
        this.url = URL;
                isOn= false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String URL) {
        this.url = URL;
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

    public Bitmap getPicture() {
        return Picture;
    }

    public void setPicture(Bitmap picture) {
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
        return "Lampada: " + nome +" " + "Indirizzo IP:" + ipAddress;
    }

}

package it.polito.did.app_android;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.YELLOW;

/**
 * Created by Luca on 07/12/2017.
 */

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private final List<Lampada> lista_lampade;

    public CustomAdapter(Context ctx, ArrayList<Lampada> lampade){
        this.context = ctx;
        this.lista_lampade = lampade;
    }

    @Override
    public int getCount() {
        return lista_lampade.size();
    }

    @Override
    public Object getItem(int i) {
        return lista_lampade.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View v, ViewGroup p) {
        if(v==null){
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=li.inflate(R.layout.lampada_item_layout,p, false);
        }
        TextView tv = (TextView) v.findViewById(R.id.testo_lampada);
        Switch sw = (Switch) v.findViewById(R.id.switch_isOn);
       tv.setText(lista_lampade.get(i).toString() + "\n \n" + "Indirizzo IP: " + lista_lampade.get(i).getIpAddress());
//        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                lista_lampade.get(i).turnOn();
//            }
//        });
        Lampada lamp = lista_lampade.get(i);
        if(!lamp.isOn) {
            v.setBackgroundColor(Color.WHITE);
            sw.setChecked(false);
            Log.i("tag","e' spenta");

        }
        else if(lamp.isOn){
            v.setBackgroundColor(YELLOW);
            lamp.turnOff();
            sw.setChecked(true);
            Log.i("tag","e' accesa");

        }

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Lampada lamp = lista_lampade.get(i);
              if(b){
                  lamp.turnOn();
              }
              if(!b){
                  lamp.turnOff();
              }

            }
        });


        return v;


    }
}

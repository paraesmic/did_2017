package it.polito.did.app_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import static android.graphics.Color.YELLOW;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    LampManager manager = LampManager.getInstance();


    public CustomAdapter(Context ctx){
        this.context = ctx;
    }

    @Override
    public int getCount() {
        return LampManager.lista_lampade.size();
    }

    @Override
    public Object getItem(int i) {
        return LampManager.lista_lampade.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View v, ViewGroup p) {
        if(v==null){
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=li.inflate(R.layout.lampada_item_layout, p, false);
        }
        TextView tv = v.findViewById(R.id.testo_lampada);
        Switch sw = v.findViewById(R.id.switch_isOn);
       tv.setText(LampManager.lista_lampade.get(i).toString() + "\n \n" + LampManager.lista_lampade.get(i).getIpAddress());
       Log.i("Completata", "View " + i + "nella lista");

        Lampada lamp = LampManager.lista_lampade.get(i);
        if(!lamp.isOn) {
            v.setBackgroundColor(Color.WHITE);
            sw.setChecked(false);
            Log.i("list","e' spenta " + i);
        }
        else if(lamp.isOn){
            v.setBackgroundColor(YELLOW);
            sw.setChecked(true);
            Log.i("list","e' accesa " + i);
        }

        final View finalV = v;
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Lampada lamp = LampManager.lista_lampade.get(i);
              if(b){
                  finalV.setBackgroundColor(Color.YELLOW);
                  lamp.turnOn();
                  Log.i("switch", "on");
              }
              if(!b){
                  finalV.setBackgroundColor(Color.WHITE);
                  lamp.turnOff();
                  Log.i("switch", "off");
              }
            }
        });

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondaryActivity.class);
                intent.putExtra("currentLamp_index", i);
                view.getContext().startActivity(intent);
            }
        });

        return v;


    }


}

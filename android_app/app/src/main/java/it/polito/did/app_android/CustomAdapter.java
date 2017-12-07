package it.polito.did.app_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        Switch sw = (Switch) v.findViewById(R.id.switch2);
       tv.setText(lista_lampade.get(i).toString());
//        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                lista_lampade.get(i).turnOn();
//            }
//        });
        return v;
    }
}

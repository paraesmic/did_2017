package it.polito.did.app_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomGridAdapter extends BaseAdapter {
    private Context context;
    private final List<Lampada> lista_lampade;

    public CustomGridAdapter(Context ctx, ArrayList<Lampada> lampade){
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
            v=li.inflate(R.layout.grid_item,p, false);
        }
        TextView tv = (TextView) v.findViewById(R.id.grid_item_name);
        ImageButton b = (ImageButton) v.findViewById(R.id.grid_item_button);
        tv.setText(lista_lampade.get(i).toString());


        return v;
    }
}

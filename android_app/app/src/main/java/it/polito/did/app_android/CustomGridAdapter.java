package it.polito.did.app_android;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class CustomGridAdapter extends BaseAdapter {

    private Context context;
    LampManager manager = LampManager.getInstance();
    final List<Lampada> lista_lampade = manager.getLamps();

    public CustomGridAdapter(Context ctx){
        this.context = ctx;
        final List<Lampada> lista_lampade = manager.getLamps();

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
        TextView name = (TextView) v.findViewById(R.id.grid_item_name);
        ImageButton b = (ImageButton) v.findViewById(R.id.grid_item_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), SecondaryActivity.class));
            }
        });
        TextView isOn = (TextView) v.findViewById(R.id.grid_item_isOn_text);
        name.setText(lista_lampade.get(i).toString() + "\n" + "Indirizzo IP: " + lista_lampade.get(i).getIpAddress());
        if(lista_lampade.get(i).isOn)
        {
            isOn.setText("ACCESA");
            v.setBackgroundColor(YELLOW);
        }
        else {
            isOn.setText("SPENTA");
            v.setBackgroundColor(WHITE);
        }
        return v;
    }
}


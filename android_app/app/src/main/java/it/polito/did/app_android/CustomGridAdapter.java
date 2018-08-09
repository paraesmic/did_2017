package it.polito.did.app_android;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

    int flag = 1;

    public CustomGridAdapter(Context ctx){
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
            v=li.inflate(R.layout.grid_item,p, false);
        }
        TextView name = v.findViewById(R.id.grid_item_name);
        ImageButton b = v.findViewById(R.id.grid_item_button);

        final TextView isOn = v.findViewById(R.id.grid_item_isOn_text);
        name.setText(LampManager.lista_lampade.get(i).toString() + "\n" + LampManager.lista_lampade.get(i).getIpAddress());


        if (LampManager.lista_lampade.get(i).isOn) {
                isOn.setText("ACCESA");
                v.setBackgroundColor(YELLOW);
                Log.i("grid", "è accesa " + i);
        }
        else {
            isOn.setText("SPENTA");
            v.setBackgroundColor(WHITE);
            Log.i("grid", "è spenta " + i);
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondaryActivity.class);
                intent.putExtra("currentLamp_index", i);
                view.getContext().startActivity(intent);
            }
        });



        v.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(LampManager.lista_lampade.get(i).isOn){
                isOn.setText("SPENTA");
                LampManager.lista_lampade.get(i).turnOff();
                Log.i("gridOnClick", "spenta " + i);
                view.setBackgroundColor(WHITE);
            } else{
                isOn.setText("ACCESA");
                view.setBackgroundColor(YELLOW);
                LampManager.lista_lampade.get(i).turnOn();
                Log.i("gridOnClick", "accesa " + i);
                }
            }
        });

        return v;
    }
}


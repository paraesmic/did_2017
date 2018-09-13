package it.polito.did.app_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    Context context;

    public RecyclerViewAdapter(Context ctx){
        this.context = ctx;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if(LampManager.statoMain==0)
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lampada_item_layout, parent,false);
        else
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent,false);
        MyViewHolder vh = new MyViewHolder(v);


        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Lampada current = LampManager.lista_lampade.get(position);
        holder.name.setText(current.toString());
        holder.image.setImageDrawable((Drawable.createFromPath(current.getPicture());
        if(LampManager.statoMain==0){

            holder.sw.setChecked(current.isOn);
            if(current.isOn){
                holder.cl.setBackgroundColor(Color.YELLOW);
            } else {
                holder.cl.setBackgroundColor(Color.WHITE);
            }

        holder.cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondaryActivity.class);
                intent.putExtra("currentLamp_index", position);
                view.getContext().startActivity(intent);
            }
        });
        holder.sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current.isOn){
                    current.turnOff();
                    holder.cl.setBackgroundColor(Color.WHITE);
                } else{
                    current.turnOn();
                    holder.cl.setBackgroundColor(Color.YELLOW);
                }
            }
        });


        } else{

            if(LampManager.lista_lampade.get(position).isOn){
                holder.isOnText.setText("ACCESA");
                holder.card_view.setBackgroundColor(Color.YELLOW);
            } else {
                holder.isOnText.setText("SPENTA");
                holder.card_view.setBackgroundColor(Color.WHITE);
            }
            holder.card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(current.isOn){
                        current.turnOff();
                        holder.isOnText.setText("SPENTA");
                        holder.card_view.setBackgroundColor(Color.WHITE);
                    } else{
                        current.turnOn();
                        holder.isOnText.setText("ACCESA");
                        holder.card_view.setBackgroundColor(Color.YELLOW);
                    }
                }
            });

            holder.bottonepiu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), SecondaryActivity.class);
                    intent.putExtra("currentLamp_index", position);
                    view.getContext().startActivity(intent);
                }
            });
        }



    }

    @Override
    public int getItemCount() {
        return LampManager.lista_lampade.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        Switch sw;
        ImageView image;
        ImageView bottonepiu;
        TextView isOnText;
        ConstraintLayout cl;
        CardView card_view;


        public MyViewHolder(View itemView){
            super(itemView);
            if(LampManager.statoMain==0){
                cl = itemView.findViewById(R.id.singola_lampada);
                name = itemView.findViewById(R.id.testo_lampada);
                sw = itemView.findViewById(R.id.switch_isOn);
            }else{
                card_view = itemView.findViewById(R.id.grid_item);
                image=itemView.findViewById(R.id.grid_item_image);
                bottonepiu=itemView.findViewById(R.id.grid_item_button);
                name=itemView.findViewById(R.id.grid_item_name);
                isOnText=itemView.findViewById(R.id.grid_item_isOn_text);

            }


        }

    }

}


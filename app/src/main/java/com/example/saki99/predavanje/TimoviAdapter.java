package com.example.saki99.predavanje;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.saki99.predavanje.POJO.Tim;

import java.util.ArrayList;

/**
 * Created by Saki99 on 23.3.2018..
 */

public class TimoviAdapter extends RecyclerView.Adapter<TimoviAdapter.MyViewHolder> {

    private ArrayList<Tim> timovi;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView grb;
        private TextView ime, code, skrIme;

        public MyViewHolder(View itemView) {
            super(itemView);

            grb = itemView.findViewById(R.id.grb_tima);
            ime = itemView.findViewById(R.id.ime_tima);
            skrIme = itemView.findViewById(R.id.kratko_ime_tima);
            code = itemView.findViewById(R.id.code_tima);
        }
    }

    public TimoviAdapter(ArrayList<Tim> timovi, Context context) {
        this.timovi = timovi;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_timovi, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Glide.with(context).load(timovi.get(position).getSlika()).into(holder.grb);

        holder.ime.setText(timovi.get(position).getIme());
        holder.skrIme.setText(timovi.get(position).getShortName());
        holder.code.setText(timovi.get(position).getCode());
    }

    @Override
    public int getItemCount() {
        return timovi.size();
    }
}

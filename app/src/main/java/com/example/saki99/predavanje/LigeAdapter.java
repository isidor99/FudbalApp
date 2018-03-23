package com.example.saki99.predavanje;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saki99.predavanje.POJO.Liga;
import com.example.saki99.predavanje.POJO.ListaTimova;
import com.example.saki99.predavanje.POJO.Tim;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Saki99 on 23.3.2018..
 */

public class LigeAdapter extends RecyclerView.Adapter<LigeAdapter.MyViewHolder> {

    private ArrayList<Liga> lige;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView imeLige, skiLige;
        private ImageButton prikaziTimove;

        public MyViewHolder(View itemView) {
            super(itemView);

            imeLige = itemView.findViewById(R.id.ime_lige);
            skiLige = itemView.findViewById(R.id.ski_lige);
            prikaziTimove = itemView.findViewById(R.id.prikazi_timove);
        }
    }

    public LigeAdapter(ArrayList<Liga> lige, Context context) {
        this.context = context;
        this.lige = lige;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_lige, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.imeLige.setText(lige.get(position).getIme());
        holder.skiLige.setText(lige.get(position).getLiga());
        holder.prikaziTimove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RetrofitService service = retrofit.create(RetrofitService.class);

                Call<ListaTimova> zahtjev = service.getTimovi(lige.get(position).getId());

                zahtjev.enqueue(new Callback<ListaTimova>() {
                    @Override
                    public void onResponse(Call<ListaTimova> call, Response<ListaTimova> response) {

                        ListaTimova t = (ListaTimova) response.body();
                        ArrayList<Tim> timovi = t.getTimovi();

                        Intent intent = new Intent(context, ActivityTimovi.class);

                        intent.putExtra(Constants.EX_TIMOVI, timovi);

                        context.startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<ListaTimova> call, Throwable t) {
                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return lige.size();
    }
}

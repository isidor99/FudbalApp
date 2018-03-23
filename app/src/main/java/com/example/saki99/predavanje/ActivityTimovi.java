package com.example.saki99.predavanje;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.saki99.predavanje.POJO.Tim;

import java.util.ArrayList;

/**
 * Created by Saki99 on 23.3.2018..
 */

public class ActivityTimovi extends AppCompatActivity {

    RecyclerView listaTimova;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timovi);

        listaTimova = findViewById(R.id.lista_timova);

        ArrayList<Tim> timovi = (ArrayList<Tim>) getIntent().getExtras().get(Constants.EX_TIMOVI);

        TimoviAdapter adapter = new TimoviAdapter(timovi, ActivityTimovi.this);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(ActivityTimovi.this);
        listaTimova.setLayoutManager(manager);
        listaTimova.setItemAnimator(new DefaultItemAnimator());
        listaTimova.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}

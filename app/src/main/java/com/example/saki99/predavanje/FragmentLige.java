package com.example.saki99.predavanje;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saki99.predavanje.POJO.Liga;

import java.util.ArrayList;

/**
 * Created by Saki99 on 23.3.2018..
 */

public class FragmentLige extends Fragment {

    RecyclerView lista;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lige, container, false);

        lista = view.findViewById(R.id.lista_liga);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle b = getArguments();
        ArrayList<Liga> lige = (ArrayList<Liga>) b.getSerializable(Constants.EX_LIGE);

        LigeAdapter adapter = new LigeAdapter(lige, getContext());

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());

        lista.setLayoutManager(manager);
        lista.setItemAnimator(new DefaultItemAnimator());
        lista.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}

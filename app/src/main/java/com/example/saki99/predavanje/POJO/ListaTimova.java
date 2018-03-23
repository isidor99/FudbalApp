package com.example.saki99.predavanje.POJO;

import com.example.saki99.predavanje.POJO.Tim;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Saki99 on 23.3.2018..
 */

public class ListaTimova implements Serializable {

    @SerializedName("teams")
    private ArrayList<Tim> timovi;

    public ListaTimova() {}

    public ArrayList<Tim> getTimovi() { return timovi; }
}

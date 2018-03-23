package com.example.saki99.predavanje.POJO;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Saki99 on 23.3.2018..
 */

public class Liga implements Serializable {

    @SerializedName("id")
    private int id;
    @SerializedName("caption")
    private String ime;
    @SerializedName("league")
    private String liga;


    public Liga() {

    }

    public int getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getLiga() {
        return liga;
    }
}

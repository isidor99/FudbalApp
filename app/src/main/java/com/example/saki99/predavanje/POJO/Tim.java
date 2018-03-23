package com.example.saki99.predavanje.POJO;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Saki99 on 23.3.2018..
 */

public class Tim implements Serializable {

    @SerializedName("name")
    private String ime;
    @SerializedName("code")
    private String code;
    @SerializedName("shortName")
    private String shortName;
    @SerializedName("crestUrl")
    private String slika;


    public Tim() {

    }

    public String getIme() {
        return ime;
    }

    public String getSlika() {
        return slika;
    }

    public String getCode() { return code; }

    public String getShortName() { return shortName; }
}

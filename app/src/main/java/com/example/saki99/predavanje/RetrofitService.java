package com.example.saki99.predavanje;

import com.example.saki99.predavanje.POJO.Liga;
import com.example.saki99.predavanje.POJO.ListaTimova;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by Saki99 on 23.3.2018..
 */

public interface RetrofitService {

    @Headers({
            "X-Auth-Token: da843e5d740e40dda1a9a6c890284527"
    })
    @GET ("/v1/competitions/")
    Call<List<Liga>> getLige();


    @Headers({
            "X-Auth-Token: da843e5d740e40dda1a9a6c890284527"
    })
    @GET ("/v1/competitions/{id}/teams")
    Call<ListaTimova> getTimovi(@Path("id") int id);
}

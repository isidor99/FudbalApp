package com.example.saki99.predavanje;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.saki99.predavanje.POJO.Liga;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    RetrofitService service;
    Button prikaziSveLige;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prikaziSveLige = findViewById(R.id.prikazi_sve_lige);

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RetrofitService.class);



        prikaziSveLige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<List<Liga>> zahtjev = service.getLige();

                zahtjev.enqueue(new Callback<List<Liga>>() {
                    @Override
                    public void onResponse(Call<List<Liga>> call, Response<List<Liga>> response) {

                        ArrayList<Liga> lige = (ArrayList<Liga>) response.body();

                        FragmentLige fragment = new FragmentLige();

                        Bundle b = new Bundle();
                        b.putSerializable(Constants.EX_LIGE, lige);
                        fragment.setArguments(b);

                        getSupportFragmentManager().beginTransaction().replace(R.id.okvir, fragment).addToBackStack(null).commit();
                    }

                    @Override
                    public void onFailure(Call<List<Liga>> call, Throwable t) {

                    }
                });
            }
        });
    }
}

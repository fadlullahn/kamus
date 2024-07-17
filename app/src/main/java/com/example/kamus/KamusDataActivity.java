package com.example.kamus;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kamus.Adapter.AdapterDataKamus;
import com.example.kamus.Api.ApiClient;
import com.example.kamus.Api.ApiInterface;
import com.example.kamus.Model.Kamus.GetKamus;
import com.example.kamus.Model.Kamus.Kamus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KamusDataActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static KamusDataActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamus_data);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_heros);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;
        refresh();

    }

    public void refresh() {
        Call<GetKamus> HerosCall = mApiInterface.getHeros();
        HerosCall.enqueue(new Callback<GetKamus>() {
            @Override
            public void onResponse(Call<GetKamus> call, Response<GetKamus>
                    response) {
                List<Kamus> HerosList = response.body().getListDataHeros();
                Log.d("Retrofit Get", "Jumlah data Heros: " +
                        String.valueOf(HerosList.size()));
                mAdapter = new AdapterDataKamus(HerosList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetKamus> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
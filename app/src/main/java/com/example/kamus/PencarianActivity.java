package com.example.kamus;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

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

public class PencarianActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private AdapterDataKamus mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SearchView searchView;
    public static PencarianActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian);
        mRecyclerView = findViewById(R.id.rv_heros);
        searchView = findViewById(R.id.search_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;

        // Panggil metode refresh untuk memuat data saat aktivitas dibuat
        refresh();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mAdapter.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.filter(newText);
                return false;
            }
        });
    }

    public void refresh() {
        Call<GetKamus> HerosCall = mApiInterface.getHeros();
        HerosCall.enqueue(new Callback<GetKamus>() {
            @Override
            public void onResponse(Call<GetKamus> call, Response<GetKamus> response) {
                if (response.body() != null) {
                    List<Kamus> HerosList = response.body().getListDataHeros();

                    // Tampilkan semua data tanpa filter
                    Log.d("Retrofit Get", "Jumlah data Heros: " + HerosList.size());
                    mAdapter = new AdapterDataKamus(HerosList);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<GetKamus> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}

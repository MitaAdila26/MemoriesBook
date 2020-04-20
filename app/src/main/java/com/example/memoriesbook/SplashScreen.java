package com.example.memoriesbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SplashScreen extends AppCompatActivity {

    private ApiInterface apiInterface;
    private List<Siswa> siswaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new AmbilData().execute();

    }

    private class AmbilData extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
            Call<List<Siswa>> call = apiInterface.getSiswa();
            call.enqueue(new Callback<List<Siswa>>() {
                @Override
                public void onResponse(Call<List<Siswa>> call, Response<List<Siswa>> response) {
                    siswaList = response.body();
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    intent.putExtra("datanya", (Serializable) siswaList);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<List<Siswa>> call, Throwable t) {

                }
            });
            return null;
        }



    }



}
package com.example.memoriesbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;

public class CobaActivity extends AppCompatActivity {
    TextView  txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);

        txtView=(TextView)findViewById(R.id.txtView);
        Intent intent=getIntent();
        String pass=intent.getStringExtra("pesan");
        txtView.setText(pass);

    }
}

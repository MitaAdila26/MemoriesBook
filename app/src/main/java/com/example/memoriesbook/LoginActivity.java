package com.example.memoriesbook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.memoriesbook.ApiClient.retrofit;

public class LoginActivity extends AppCompatActivity {

    EditText edt_email, edt_password;
    Button btn_login;
    Password password;
    List<Password>passwords;
    ApiInterfaceLogin apiLogin, apiLogin2;
    String email, pass, passnya, tokendapat;
    Token tokennya;
    Siswa siswanya;

    RelativeLayout rellay;
    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            rellay.setVisibility(View.VISIBLE);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        rellay=(RelativeLayout)findViewById(R.id.rellay);

        edt_email=(EditText)findViewById(R.id.edtEmail);
        edt_password=(EditText)findViewById(R.id.edtPassword);

        btn_login=(Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                email=edt_email.getText().toString();
                pass=edt_password.getText().toString();
                apiLogin=ApiClient.getApiClient().create(ApiInterfaceLogin.class);
                Call<List<Password>>siswaa=apiLogin.getPass(email);
                siswaa.enqueue(new Callback<List<Password>>() {
                    @Override
                    public void onResponse(Call<List<Password>> call, Response<List<Password>> response) {
                        passwords=response.body();
                        passnya=passwords.get(0).getPassword();

                    }
                    @Override
                    public void onFailure(Call<List<Password>> call, Throwable t) {

                    }
                });
            if(pass.equals(passnya)){
                apiLogin2=ApiClient.getApiClient().create(ApiInterfaceLogin.class);
                Call<Token>call=apiLogin2.getToken(email,pass);
                call.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        tokennya=response.body();
                        tokendapat=tokennya.getToken();
                        Intent pindah1=new Intent(LoginActivity.this,MainActivity.class);
                        pindah1.putExtra("pesan",tokendapat);
                        startActivity(pindah1);
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {

                    }
                });

            }else {
                Toast.makeText(getApplicationContext(),"Siapa Anda?",Toast.LENGTH_LONG).show();
                edt_email.setText("");
                edt_password.setText("");
            }
            }

        });

        handler.postDelayed(runnable,0);

    }

}

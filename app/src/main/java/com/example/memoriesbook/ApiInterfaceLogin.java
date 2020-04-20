package com.example.memoriesbook;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterfaceLogin {
    @GET("/pass/email")
    Call<List<Password>>getPass(@Query("email")String email);

    @POST("/signin")
    @FormUrlEncoded
    Call<Token>getToken(@Field("email")String email,
                        @Field("password")String password);

}

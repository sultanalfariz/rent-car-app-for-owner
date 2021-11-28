package com.example.asus.mobilku_pemilik.Interface;

import com.example.asus.mobilku_pemilik.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterface {

    @FormUrlEncoded
    @POST("login_perusahaan")
    Call<LoginResponse> login(@Field("username") String username,
                              @Field("password") String password);
}

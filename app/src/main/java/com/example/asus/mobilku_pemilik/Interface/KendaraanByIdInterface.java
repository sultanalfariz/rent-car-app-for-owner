package com.example.asus.mobilku_pemilik.Interface;

import com.example.asus.mobilku_pemilik.Model.KendaraanByIdResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface KendaraanByIdInterface {

    @GET("kendaraan_by_id/{id}")
    Call<KendaraanByIdResponse> kendaraan(@Path("id") String id);

}

package com.example.asus.mobilku_pemilik.Interface;

import com.example.asus.mobilku_pemilik.Model.PesananMasukResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PesananMasukInterface {

    @GET("pemesanan_pemilik_masuk_by_id/{id}")
    Call<PesananMasukResponse> pesananMasuk(@Path("id") String id);

}

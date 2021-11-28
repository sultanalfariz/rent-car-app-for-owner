package com.example.asus.mobilku_pemilik.Interface;

import com.example.asus.mobilku_pemilik.Model.PesananKonfirmasiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PesananKonfirmasiInterface {

    @GET("pemesanan_pemilik_by_id/{id}")
    Call<PesananKonfirmasiResponse> pesananKonfirmasi(@Path("id") String id);

}

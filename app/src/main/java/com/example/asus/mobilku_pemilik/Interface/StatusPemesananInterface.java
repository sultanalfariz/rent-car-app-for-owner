package com.example.asus.mobilku_pemilik.Interface;

import com.example.asus.mobilku_pemilik.Model.StatusPemesanan;
import com.example.asus.mobilku_pemilik.Model.StatusPemesananResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface StatusPemesananInterface {

    @POST("ubah_status_pemesanan/{id}")
    Call<StatusPemesananResponse> statusPemesanan(@Path("id") String id,
                                                  @Body StatusPemesanan statusPemesanan);

}

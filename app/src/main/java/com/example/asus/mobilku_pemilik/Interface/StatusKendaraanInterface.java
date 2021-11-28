package com.example.asus.mobilku_pemilik.Interface;

import com.example.asus.mobilku_pemilik.Model.StatusKendaraan;
import com.example.asus.mobilku_pemilik.Model.StatusKendaraanResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface StatusKendaraanInterface {

    @POST("ubah_status_kendaraan/{id}")
    Call<StatusKendaraanResponse> statusKendaraan(@Path("id") String id,
                                                  @Body StatusKendaraan statusKendaraan);

}

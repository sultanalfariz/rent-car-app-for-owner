package com.example.asus.mobilku_pemilik.Interface;

import com.example.asus.mobilku_pemilik.Model.DeleteResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

public interface DeleteInterface {

    @DELETE("hapus_pesanan/{id}")
    Call<DeleteResponse> hapusPesan(@Path("id") String id);

}

package com.example.asus.mobilku_pemilik.Interface;

import com.example.asus.mobilku_pemilik.Model.AddKendaraanResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AddKendaraanInterface {

    @Multipart
    @POST("tambah_kendaraan")
    Call<AddKendaraanResponse> tambah(@Part("nama_kendaraan") RequestBody nama_kendaraan,
                                      @Part("jenis") RequestBody jenis,
                                      @Part("harga") RequestBody harga,
                                      @Part("id_perusahaan") RequestBody id_perusahaan,
                                      @Part MultipartBody.Part file);

}

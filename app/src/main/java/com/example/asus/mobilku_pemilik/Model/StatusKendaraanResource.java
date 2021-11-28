package com.example.asus.mobilku_pemilik.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusKendaraanResource {

    @SerializedName("id_kendaraan")
    @Expose
    private Integer idKendaraan;
    @SerializedName("nama_kendaraan")
    @Expose
    private String namaKendaraan;
    @SerializedName("jenis")
    @Expose
    private String jenis;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("id_perusahaan")
    @Expose
    private Integer idPerusahaan;

    public Integer getIdKendaraan() {
        return idKendaraan;
    }

    public void setIdKendaraan(Integer idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Integer getIdPerusahaan() {
        return idPerusahaan;
    }

    public void setIdPerusahaan(Integer idPerusahaan) {
        this.idPerusahaan = idPerusahaan;
    }

}

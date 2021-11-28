package com.example.asus.mobilku_pemilik.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddKendaraanResponse {

    @SerializedName("kode")
    @Expose
    private Integer kode;
    @SerializedName("pesan")
    @Expose
    private String pesan;

    public Integer getKode() {
        return kode;
    }

    public void setKode(Integer kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

}

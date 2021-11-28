package com.example.asus.mobilku_pemilik.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusPemesanan {

    @SerializedName("status_pemesanan")
    @Expose
    private String statusPemesanan;

    public String getStatusPemesanan() {
        return statusPemesanan;
    }

    public void setStatusPemesanan(String statusPemesanan) {
        this.statusPemesanan = statusPemesanan;
    }

}

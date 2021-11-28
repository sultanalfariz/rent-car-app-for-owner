package com.example.asus.mobilku_pemilik.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PesananKonfirmasiResponse {

    @SerializedName("success")
    @Expose
    private List<PesananKonfirmasiResource> pesananKonfirmasiResource = null;

    public List<PesananKonfirmasiResource> getSuccess() {
        return pesananKonfirmasiResource;
    }

    public void setSuccess(List<PesananKonfirmasiResource> pesananKonfirmasiResource) {
        this.pesananKonfirmasiResource = pesananKonfirmasiResource;
    }

}

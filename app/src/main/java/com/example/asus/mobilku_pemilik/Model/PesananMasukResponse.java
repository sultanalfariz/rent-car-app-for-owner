package com.example.asus.mobilku_pemilik.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PesananMasukResponse {

    @SerializedName("success")
    @Expose
    private List<PesananMasukResource> pesananMasukResource = null;

    public List<PesananMasukResource> getSuccess() {
        return pesananMasukResource;
    }

    public void setSuccess(List<PesananMasukResource> pesananMasukResource) {
        this.pesananMasukResource = pesananMasukResource;
    }

}

package com.example.asus.mobilku_pemilik.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KendaraanByIdResponse {

    @SerializedName("success")
    @Expose
    private List<KendaraanByIdResource> kendaraanByIdResource = null;

    public List<KendaraanByIdResource> getSuccess() {
        return kendaraanByIdResource;
    }

    public void setSuccess(List<KendaraanByIdResource> kendaraanByIdResource) {
        this.kendaraanByIdResource = kendaraanByIdResource;
    }

}

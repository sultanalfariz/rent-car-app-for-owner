package com.example.asus.mobilku_pemilik.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusKendaraanResponse {

    @SerializedName("success")
    @Expose
    private StatusKendaraanResource statusKendaraanResource;

    public StatusKendaraanResource getSuccess() {
        return statusKendaraanResource;
    }

    public void setSuccess(StatusKendaraanResource statusKendaraanResource) {
        this.statusKendaraanResource = statusKendaraanResource;
    }

}

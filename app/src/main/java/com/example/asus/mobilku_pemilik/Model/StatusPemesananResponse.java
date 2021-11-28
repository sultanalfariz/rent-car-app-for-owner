package com.example.asus.mobilku_pemilik.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusPemesananResponse {

    @SerializedName("success")
    @Expose
    private StatusPemesananResource statusPemesananResource;

    public StatusPemesananResource getSuccess() {
        return statusPemesananResource;
    }

    public void setSuccess(StatusPemesananResource statusPemesananResource) {
        this.statusPemesananResource = statusPemesananResource;
    }

}

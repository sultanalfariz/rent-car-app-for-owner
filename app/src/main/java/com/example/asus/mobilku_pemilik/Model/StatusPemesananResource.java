package com.example.asus.mobilku_pemilik.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusPemesananResource {

    @SerializedName("id_pemesanan")
    @Expose
    private Integer idPemesanan;
    @SerializedName("nama_kendaraan")
    @Expose
    private String namaKendaraan;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("tanggal_keluar")
    @Expose
    private String tanggalKeluar;
    @SerializedName("tanggal_masuk")
    @Expose
    private String tanggalMasuk;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("status_pemesanan")
    @Expose
    private String statusPemesanan;
    @SerializedName("id_user")
    @Expose
    private Integer idUser;
    @SerializedName("id_perusahaan")
    @Expose
    private Integer idPerusahaan;
    @SerializedName("id_kendaraan")
    @Expose
    private Integer idKendaraan;

    public Integer getIdPemesanan() {
        return idPemesanan;
    }

    public void setIdPemesanan(Integer idPemesanan) {
        this.idPemesanan = idPemesanan;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggalKeluar() {
        return tanggalKeluar;
    }

    public void setTanggalKeluar(String tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStatusPemesanan() {
        return statusPemesanan;
    }

    public void setStatusPemesanan(String statusPemesanan) {
        this.statusPemesanan = statusPemesanan;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdPerusahaan() {
        return idPerusahaan;
    }

    public void setIdPerusahaan(Integer idPerusahaan) {
        this.idPerusahaan = idPerusahaan;
    }

    public Integer getIdKendaraan() {
        return idKendaraan;
    }

    public void setIdKendaraan(Integer idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

}

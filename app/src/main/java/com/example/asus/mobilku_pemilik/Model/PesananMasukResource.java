package com.example.asus.mobilku_pemilik.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PesananMasukResource {

    @SerializedName("id_pemesanan")
    @Expose
    private Integer idPemesanan;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("nama_kendaraan")
    @Expose
    private String namaKendaraan;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("status_pemesanan")
    @Expose
    private String statusPemesanan;
    @SerializedName("no_ktp_user")
    @Expose
    private String noKtpUser;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tanggal_keluar")
    @Expose
    private String tanggalKeluar;
    @SerializedName("tanggal_masuk")
    @Expose
    private String tanggalMasuk;
    @SerializedName("id_user")
    @Expose
    private Integer idUser;
    @SerializedName("id_kendaraan")
    @Expose
    private Integer idKendaraan;

    public Integer getIdPemesanan() {
        return idPemesanan;
    }

    public void setIdPemesanan(Integer idPemesanan) {
        this.idPemesanan = idPemesanan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatusPemesanan() {
        return statusPemesanan;
    }

    public void setStatusPemesanan(String statusPemesanan) {
        this.statusPemesanan = statusPemesanan;
    }

    public String getNoKtpUser() {
        return noKtpUser;
    }

    public void setNoKtpUser(String noKtpUser) {
        this.noKtpUser = noKtpUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdKendaraan() {
        return idKendaraan;
    }

    public void setIdKendaraan(Integer idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

}

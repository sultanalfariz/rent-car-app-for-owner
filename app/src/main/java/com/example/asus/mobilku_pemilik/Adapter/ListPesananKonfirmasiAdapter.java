package com.example.asus.mobilku_pemilik.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.mobilku_pemilik.Config;
import com.example.asus.mobilku_pemilik.Interface.StatusKendaraanInterface;
import com.example.asus.mobilku_pemilik.Interface.StatusPemesananInterface;
import com.example.asus.mobilku_pemilik.Model.PesananKonfirmasiResource;
import com.example.asus.mobilku_pemilik.Model.StatusKendaraan;
import com.example.asus.mobilku_pemilik.Model.StatusKendaraanResource;
import com.example.asus.mobilku_pemilik.Model.StatusKendaraanResponse;
import com.example.asus.mobilku_pemilik.Model.StatusPemesanan;
import com.example.asus.mobilku_pemilik.Model.StatusPemesananResource;
import com.example.asus.mobilku_pemilik.Model.StatusPemesananResponse;
import com.example.asus.mobilku_pemilik.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPesananKonfirmasiAdapter extends RecyclerView.Adapter<ListPesananKonfirmasiAdapter.PesananKonfirmasiViewHolder> {

    Context context;

    StatusKendaraan mStatus = new StatusKendaraan();

    StatusPemesanan mPemesanan = new StatusPemesanan();

    List<PesananKonfirmasiResource> mPesanan;

    public ListPesananKonfirmasiAdapter(Context context, List<PesananKonfirmasiResource> mPesanan){

        this.context = context;
        this.mPesanan = mPesanan;

    }

    @NonNull
    @Override
    public PesananKonfirmasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutList = LayoutInflater.from(context).inflate(R.layout.item_pesanan_masuk,parent,false);
        PesananKonfirmasiViewHolder pesananKonfirmasiViewHolder = new PesananKonfirmasiViewHolder(layoutList);

        return pesananKonfirmasiViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PesananKonfirmasiViewHolder holder, final int position) {

        holder.txtNo.setText("No. Pesanan : "+mPesanan.get(position).getIdPemesanan().toString());
        holder.txtHarga.setText("Rp. "+mPesanan.get(position).getHarga().toString());
        holder.txtNamaMobil.setText(mPesanan.get(position).getNamaKendaraan().toString());
        holder.txtNama.setText(mPesanan.get(position).getNama().toString());
        holder.txtKtp.setText("  -  "+mPesanan.get(position).getNoKtpUser().toString());
        holder.txtTanggal.setText(mPesanan.get(position).getTanggalKeluar().toString());

        holder.btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sKendaraan = "Ada";
                mStatus.setStatus(sKendaraan);
                Log.d("dataaaaa", "status ="+mStatus.getStatus().toString());

                String id = mPesanan.get(position).getIdKendaraan().toString();
                Log.d("dataaaaaa", "id_kendaraan = "+id);
                final StatusKendaraanInterface statusKendaraanInterface = Config.getClient(context).create(StatusKendaraanInterface.class);
                Call<StatusKendaraanResponse> ubahStatus = statusKendaraanInterface.statusKendaraan(id, mStatus);
                ubahStatus.enqueue(new Callback<StatusKendaraanResponse>() {
                    @Override
                    public void onResponse(Call<StatusKendaraanResponse> call, Response<StatusKendaraanResponse> response) {
                        Log.d("dataaaaaa", "masukkkk");
                        StatusKendaraanResource mStatusKendaraan = response.body().getSuccess();
                        Log.d("dataaaaaa", "status = "+mStatusKendaraan);

                        if (mStatusKendaraan != null){

                            String sPemesanan = "Selesai";
                            mPemesanan.setStatusPemesanan(sPemesanan);
                            Log.d("dataaaaa", "mPemesanan "+mPemesanan.getStatusPemesanan().toString());

                            String id = mPesanan.get(position).getIdPemesanan().toString();
                            Log.d("dataaaaa", "id pesan "+id);

                            StatusPemesananInterface statusPemesananInterface = Config.getClient(context)
                                    .create(StatusPemesananInterface.class);
                            Call<StatusPemesananResponse> ubahPesan = statusPemesananInterface.statusPemesanan(id, mPemesanan);
                            ubahPesan.enqueue(new Callback<StatusPemesananResponse>() {
                                @Override
                                public void onResponse(Call<StatusPemesananResponse> call, Response<StatusPemesananResponse> response) {
                                    Log.d("dataaaaaa", "mauk response 2");
                                    StatusPemesananResource mStatKen = response.body().getSuccess();
                                    Log.d("dataaaaaa", "resp = "+mStatKen);

                                    if (mStatKen != null){

                                        Toast.makeText(context, "Berhasil", Toast.LENGTH_LONG).show();

                                    }

                                }

                                @Override
                                public void onFailure(Call<StatusPemesananResponse> call, Throwable t) {

                                }
                            });

                        }

                    }

                    @Override
                    public void onFailure(Call<StatusKendaraanResponse> call, Throwable t) {

                    }
                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return mPesanan.size();
    }

    public class PesananKonfirmasiViewHolder extends RecyclerView.ViewHolder {

        TextView txtNo, txtHarga, txtNamaMobil, txtNama, txtKtp, txtTanggal, btnKonfirmasi;

        public PesananKonfirmasiViewHolder(View itemView) {
            super(itemView);

            txtNo = itemView.findViewById(R.id.text_no_pesanan);
            txtHarga = itemView.findViewById(R.id.text_harga);
            txtNamaMobil = itemView.findViewById(R.id.nama_kendaraan);
            txtNama = itemView.findViewById(R.id.nama_penyewa);
            txtKtp = itemView.findViewById(R.id.no_ktp);
            txtTanggal = itemView.findViewById(R.id.tanggal_sewa);
            btnKonfirmasi = itemView.findViewById(R.id.btn_selesai);

        }
    }
}

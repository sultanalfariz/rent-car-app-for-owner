package com.example.asus.mobilku_pemilik.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.mobilku_pemilik.Config;
import com.example.asus.mobilku_pemilik.Fragment.PesananMasukFragment;
import com.example.asus.mobilku_pemilik.Interface.DeleteInterface;
import com.example.asus.mobilku_pemilik.Interface.StatusKendaraanInterface;
import com.example.asus.mobilku_pemilik.Interface.StatusPemesananInterface;
import com.example.asus.mobilku_pemilik.Model.DeleteResponse;
import com.example.asus.mobilku_pemilik.Model.PesananKonfirmasiResource;
import com.example.asus.mobilku_pemilik.Model.PesananMasukResource;
import com.example.asus.mobilku_pemilik.Model.StatusKendaraan;
import com.example.asus.mobilku_pemilik.Model.StatusKendaraanResource;
import com.example.asus.mobilku_pemilik.Model.StatusKendaraanResponse;
import com.example.asus.mobilku_pemilik.Model.StatusPemesanan;
import com.example.asus.mobilku_pemilik.Model.StatusPemesananResource;
import com.example.asus.mobilku_pemilik.Model.StatusPemesananResponse;
import com.example.asus.mobilku_pemilik.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPesananMasukAdapter extends RecyclerView.Adapter<ListPesananMasukAdapter.PesananMasukViewHolder> {

    Context context;
    List<PesananMasukResource> mPesanan;

    StatusKendaraan mStatus = new StatusKendaraan();

    StatusPemesanan mPemesanan = new StatusPemesanan();

    List<StatusKendaraanResource> mKendaraanStatus;

    public ListPesananMasukAdapter(Context context, List<PesananMasukResource> mPesanan){

        this.context = context;
        this.mPesanan = mPesanan;

    }

    @NonNull
    @Override
    public PesananMasukViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutList = LayoutInflater.from(context).inflate(R.layout.item_pesanan_konfirmasi,parent,false);
        PesananMasukViewHolder pesananMasukViewHolder = new PesananMasukViewHolder(layoutList);

        return pesananMasukViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PesananMasukViewHolder holder, final int position) {

        holder.txtNo.setText("No. Pesanan : "+mPesanan.get(position).getIdPemesanan().toString());
        holder.txtHarga.setText("Rp. "+mPesanan.get(position).getHarga().toString());
        holder.txtNamaMobil.setText(mPesanan.get(position).getNamaKendaraan().toString());
        holder.txtNama.setText(mPesanan.get(position).getNama().toString());
        holder.txtKtp.setText("  -  "+mPesanan.get(position).getNoKtpUser().toString());
        holder.txtTanggal.setText(mPesanan.get(position).getTanggalKeluar().toString());

        holder.btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sKendaraan = "Tidak ada";
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

                                String sPemesanan = "Dikonfirmasi";
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

        holder.btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = mPesanan.get(position).getIdPemesanan().toString();

                DeleteInterface deleteInterface = Config.getClient(context).create(DeleteInterface.class);
                Call<DeleteResponse> mHapus = deleteInterface.hapusPesan(id);
                mHapus.enqueue(new Callback<DeleteResponse>() {
                    @Override
                    public void onResponse(Call<DeleteResponse> call, Response<DeleteResponse> response) {

                        String mData = response.body().getSuccess();

                        if (mData != null){

                            Toast.makeText(context, "Data Dihapus", Toast.LENGTH_LONG).show();

                        }

                    }

                    @Override
                    public void onFailure(Call<DeleteResponse> call, Throwable t) {

                    }
                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return mPesanan.size();
    }

    public class PesananMasukViewHolder extends RecyclerView.ViewHolder {

        TextView txtNo, txtHarga, txtNamaMobil, txtNama, txtKtp, txtTanggal, btnBatal, btnKonfirmasi;

        public PesananMasukViewHolder(View itemView) {
            super(itemView);

            txtNo = itemView.findViewById(R.id.text_no_pesanan);
            txtHarga = itemView.findViewById(R.id.text_harga);
            txtNamaMobil = itemView.findViewById(R.id.nama_kendaraan);
            txtNama = itemView.findViewById(R.id.nama_penyewa);
            txtKtp = itemView.findViewById(R.id.no_ktp);
            txtTanggal = itemView.findViewById(R.id.tanggal_sewa);
            btnBatal = itemView.findViewById(R.id.btn_cancel);
            btnKonfirmasi = itemView.findViewById(R.id.btn_confirm);

        }
    }
}

package com.example.asus.mobilku_pemilik.Fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.mobilku_pemilik.Adapter.ListPesananKonfirmasiAdapter;
import com.example.asus.mobilku_pemilik.Config;
import com.example.asus.mobilku_pemilik.Interface.PesananKonfirmasiInterface;
import com.example.asus.mobilku_pemilik.Model.PesananKonfirmasiResource;
import com.example.asus.mobilku_pemilik.Model.PesananKonfirmasiResponse;
import com.example.asus.mobilku_pemilik.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesananKonfirmasiFragment extends Fragment {

    RecyclerView rvPesananKonfirmasi;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferencesId;

    List<PesananKonfirmasiResource> mPesanan = new ArrayList<>();

    public PesananKonfirmasiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View listPesananKonfirmasi = inflater.inflate(R.layout.fragment_pesanan_konfirmasi, container, false);

        rvPesananKonfirmasi = listPesananKonfirmasi.findViewById(R.id.rv_pesanan_konfirmasi);

        sharedPreferencesId = getActivity().getSharedPreferences(KEYPREF, getContext().MODE_PRIVATE);
        String id = sharedPreferencesId.getString("id_perusahaan", null);
        Log.d("dataaaa", "id = "+id);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvPesananKonfirmasi.setLayoutManager(linearLayoutManager);

        PesananKonfirmasiInterface pesananKonfirmasiInterface = Config.getClient(getContext())
                .create(PesananKonfirmasiInterface.class);
         Call<PesananKonfirmasiResponse> mKonfirmasi = pesananKonfirmasiInterface.pesananKonfirmasi(id);
         mKonfirmasi.enqueue(new Callback<PesananKonfirmasiResponse>() {
             @Override
             public void onResponse(Call<PesananKonfirmasiResponse> call, Response<PesananKonfirmasiResponse> response) {

                 mPesanan = response.body().getSuccess();

                 if (mPesanan != null){

                     ListPesananKonfirmasiAdapter listPesananKonfirmasiAdapter = new ListPesananKonfirmasiAdapter(getContext(), mPesanan);
                     rvPesananKonfirmasi.setAdapter(listPesananKonfirmasiAdapter);
                     listPesananKonfirmasiAdapter.notifyDataSetChanged();

                 }

             }

             @Override
             public void onFailure(Call<PesananKonfirmasiResponse> call, Throwable t) {

             }
         });

        return listPesananKonfirmasi;
    }

}

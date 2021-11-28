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

import com.example.asus.mobilku_pemilik.Adapter.ListPesananMasukAdapter;
import com.example.asus.mobilku_pemilik.Config;
import com.example.asus.mobilku_pemilik.Interface.PesananMasukInterface;
import com.example.asus.mobilku_pemilik.Model.PesananMasukResource;
import com.example.asus.mobilku_pemilik.Model.PesananMasukResponse;
import com.example.asus.mobilku_pemilik.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesananMasukFragment extends Fragment {

    RecyclerView rvPesananMasuk;

    public static final String KEYPREF = "Key Preference";
    public static SharedPreferences sharedPreferencesId;

    public static String id;

    List<PesananMasukResource> mPesanan = new ArrayList<>();

    public PesananMasukFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View listPesananMasuk = inflater.inflate(R.layout.fragment_pesanan_masuk, container, false);

        rvPesananMasuk = listPesananMasuk.findViewById(R.id.rv_pesanan_masuk);

        sharedPreferencesId = getActivity().getSharedPreferences(KEYPREF, getContext().MODE_PRIVATE);
        String id = sharedPreferencesId.getString("id_perusahaan", null);
        Log.d("dataaaa", "id = "+id);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvPesananMasuk.setLayoutManager(linearLayoutManager);

        PesananMasukInterface pesananMasukInterface = Config.getClient(getContext())
                .create(PesananMasukInterface.class);
        Call<PesananMasukResponse> pesanMasuk = pesananMasukInterface.pesananMasuk(id);
        pesanMasuk.enqueue(new Callback<PesananMasukResponse>() {
            @Override
            public void onResponse(Call<PesananMasukResponse> call, Response<PesananMasukResponse> response) {

                mPesanan = response.body().getSuccess();

                if (mPesanan != null){

                    ListPesananMasukAdapter listPesananMasukAdapter = new ListPesananMasukAdapter(getContext(), mPesanan);
                    rvPesananMasuk.setAdapter(listPesananMasukAdapter);
                    listPesananMasukAdapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<PesananMasukResponse> call, Throwable t) {

            }
        });

        return listPesananMasuk;
    }

}

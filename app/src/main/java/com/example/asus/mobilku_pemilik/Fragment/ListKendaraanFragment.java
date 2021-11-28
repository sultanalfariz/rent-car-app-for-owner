package com.example.asus.mobilku_pemilik.Fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asus.mobilku_pemilik.Adapter.ListKendaraanAdapter;
import com.example.asus.mobilku_pemilik.Config;
import com.example.asus.mobilku_pemilik.Interface.KendaraanByIdInterface;
import com.example.asus.mobilku_pemilik.Model.KendaraanByIdResource;
import com.example.asus.mobilku_pemilik.Model.KendaraanByIdResponse;
import com.example.asus.mobilku_pemilik.Model.LoginResource;
import com.example.asus.mobilku_pemilik.R;
import com.example.asus.mobilku_pemilik.TambahKendaraanActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListKendaraanFragment extends Fragment {

    RecyclerView rvListKendaraan;
    ImageView btnTambahKendaraan;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferencesId;

    List<KendaraanByIdResource> kendaraan = new ArrayList<>();

    public ListKendaraanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View listkendaraan = inflater.inflate(R.layout.fragment_list_kendaraan, container, false);

        rvListKendaraan = listkendaraan.findViewById(R.id.rv_list_kendaraan);

        sharedPreferencesId = getActivity().getSharedPreferences(KEYPREF, getContext().MODE_PRIVATE);
        final String id = sharedPreferencesId.getString("id_perusahaan", null);
        Log.d("dataaaa", "id = "+id);

        btnTambahKendaraan = listkendaraan.findViewById(R.id.btn_tambah);
        btnTambahKendaraan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), TambahKendaraanActivity.class);
                startActivity(intent);
            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvListKendaraan.setLayoutManager(linearLayoutManager);

        KendaraanByIdInterface kendaraanByIdInterface = Config.getClient(getContext())
                .create(KendaraanByIdInterface.class);
        Call<KendaraanByIdResponse> listKendaraan = kendaraanByIdInterface.kendaraan(id);
        listKendaraan.enqueue(new Callback<KendaraanByIdResponse>() {
            @Override
            public void onResponse(Call<KendaraanByIdResponse> call, Response<KendaraanByIdResponse> response) {
                Log.d("dataaaa", "masuk");
                kendaraan = response.body().getSuccess();
                Log.d("dataaaa", "kendaraan = "+kendaraan);
                if (kendaraan != null){
                    ListKendaraanAdapter listKendaraanAdapter = new ListKendaraanAdapter(getContext(), kendaraan);
                    rvListKendaraan.setAdapter(listKendaraanAdapter);
                    listKendaraanAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<KendaraanByIdResponse> call, Throwable t) {

            }
        });

        return listkendaraan;
    }

}

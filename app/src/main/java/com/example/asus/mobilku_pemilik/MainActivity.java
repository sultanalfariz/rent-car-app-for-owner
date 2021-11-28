package com.example.asus.mobilku_pemilik;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.asus.mobilku_pemilik.Fragment.LainnyaFragment;
import com.example.asus.mobilku_pemilik.Fragment.ListKendaraanFragment;
import com.example.asus.mobilku_pemilik.Fragment.PesananKonfirmasiFragment;
import com.example.asus.mobilku_pemilik.Fragment.PesananMasukFragment;

public class MainActivity extends AppCompatActivity {

    RelativeLayout btnKendaraan, btnPesananMasuk, btnPesananKonfirmasi, btnLainnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKendaraan = findViewById(R.id.btnKendaraan);
        btnPesananMasuk = findViewById(R.id.btnPesananMasuk);
        btnPesananKonfirmasi = findViewById(R.id.btnPesananKonfirmasi);
        btnLainnya = findViewById(R.id.btnLainnya);

        btnKendaraan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new ListKendaraanFragment());
            }
        });

        btnPesananMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new PesananMasukFragment());
            }
        });

        btnPesananKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new PesananKonfirmasiFragment());
            }
        });

        btnLainnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new LainnyaFragment());
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ListKendaraanFragment()).commit();
        }

    }

    private void  loadFragment(Fragment fragment){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {

    }
}

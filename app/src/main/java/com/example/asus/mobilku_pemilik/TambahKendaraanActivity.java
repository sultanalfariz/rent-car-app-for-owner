package com.example.asus.mobilku_pemilik;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.mobilku_pemilik.Interface.AddKendaraanInterface;
import com.example.asus.mobilku_pemilik.Model.AddKendaraanResource;
import com.example.asus.mobilku_pemilik.Model.AddKendaraanResponse;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahKendaraanActivity extends AppCompatActivity {

    EditText formNama, formJenis, formHarga;
    TextView namaGambar, btnGambar, btnTambahkan;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferencesId;



    final int REQUEST_GALLERY = 9544;
    InputStream input;
    private File fileContentToUpload;
    InputStream inputStream,inputstr;
    OutputStream output;
    String UriImage;
    String namaKendaraan, namaJenis, namaHarga;
    List<String> path = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kendaraan);

        sharedPreferencesId = getSharedPreferences(KEYPREF, Context.MODE_PRIVATE);
        String id_perusahaan = sharedPreferencesId.getString("id_perusahaan", null);

        formNama = findViewById(R.id.form_nama);
        formJenis = findViewById(R.id.form_jenis);
        formHarga = findViewById(R.id.form_harga);
        btnGambar = findViewById(R.id.btn_gambar);
        namaGambar = findViewById(R.id.text_nama_gambar);
        btnTambahkan = findViewById(R.id.btn_tambah);

        btnGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CropImage.startPickImageActivity(TambahKendaraanActivity.this);
            }
        });

        btnTambahkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    inputStream = getBaseContext().getContentResolver().openInputStream(Uri.parse(path.get(0).toString()));
                    Log.d("dataaaaaaaaaaaa","UriImage = "+UriImage);
                    Log.d("dataaaaaaaaaaaa","UriImage = "+path.get(0).toString());
                    try {
                        fileContentToUpload = new File(getBaseContext().getCacheDir(),"Gambar"+0+".jpeg");
                        Log.d("dataaaaaaaa","data = "+fileContentToUpload);
                        output = new FileOutputStream(fileContentToUpload);
                        try {
                            byte[] buffer = new byte[4 * 1024]; // or other buffer size
                            int read;

                            while ((read = inputStream.read(buffer)) != -1) {
                                output.write(buffer, 0, read);
                            }

                            output.flush();
                        } finally {
                            output.close();
                        }


                    }finally {
                        output.close();
                        UploadImage(fileContentToUpload);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

    }

    public void UploadImage(File file){
        sharedPreferencesId = getSharedPreferences(KEYPREF, Context.MODE_PRIVATE);
        String id_perusahaan = sharedPreferencesId.getString("id_perusahaan", null);
        namaKendaraan = formNama.getText().toString();
        RequestBody nKendaraan = RequestBody.create(MediaType.parse("text/plain"), namaKendaraan);
        Log.d("dataaaaa", "nama kendaraan = "+ nKendaraan);
        namaJenis = formJenis.getText().toString();
        RequestBody nJenis = RequestBody.create(MediaType.parse("text/plain"), namaJenis);
        Log.d("dataaaaa", "Jenis = "+ nJenis);
        namaHarga = formHarga.getText().toString();
        RequestBody nIdPerus = RequestBody.create(MediaType.parse("text/plain"),id_perusahaan);
        Log.d("dataaaaaaa", "id = "+nIdPerus);
        RequestBody nHarga = RequestBody.create(MediaType.parse("text/plain"), namaHarga);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-file"), file);
        MultipartBody.Part partImage = MultipartBody.Part.createFormData("file",file.getName(), requestBody);
        Log.d("dataaaaa", "gbr = "+ partImage);

        AddKendaraanInterface addKendaraanInterface = Config.getClient(TambahKendaraanActivity.this)
                .create(AddKendaraanInterface.class);
        Call<AddKendaraanResponse> tambahKend = addKendaraanInterface.tambah(nKendaraan, nJenis, nHarga,nIdPerus, partImage);
        tambahKend.enqueue(new Callback<AddKendaraanResponse>() {
            @Override
            public void onResponse(Call<AddKendaraanResponse> call, Response<AddKendaraanResponse> response) {
                Log.d("dataaaa", "masuk response");

                if (response.body().getKode().equals(1)){

                    Toast.makeText(getApplicationContext(), "Berhasil Tambah", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<AddKendaraanResponse> call, Throwable t) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == RESULT_OK) {

            Uri imagePick = CropImage.getPickImageResultUri(this, data);
            CropImage.activity(imagePick).start(this);

        } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            Uri imageUri = result.getUri();
            UriImage = imageUri.toString();
            path.add(UriImage);
            Log.d("dataaaaaaaaaaa", "isi" + path.size());

        }
    }
}

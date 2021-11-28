package com.example.asus.mobilku_pemilik;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.mobilku_pemilik.Interface.LoginInterface;
import com.example.asus.mobilku_pemilik.Model.LoginResource;
import com.example.asus.mobilku_pemilik.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText formUsername, formPassword;
    TextView btnLogin;

    String username, password;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences(KEYPREF, Context.MODE_PRIVATE);

        formUsername = findViewById(R.id.input_username);
        formPassword = findViewById(R.id.input_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = formUsername.getText().toString();
                password = formPassword.getText().toString();

                LoginInterface loginInterface = Config.getClient(LoginActivity.this)
                        .create(LoginInterface.class);

                Call<LoginResponse> login = loginInterface.login(username, password);
                login.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                        LoginResponse status = response.body().getSuccess();
                        LoginResource dataUser = response.body().getSuccess();
                        String id_perusahaan = String.valueOf(dataUser.getId());
                        if (status != null){
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            SharedPreferences.Editor data = sharedPreferences.edit();
                            data.putString("id_perusahaan", id_perusahaan);
                            Log.d("dataaa", "id perusahaan = "+id_perusahaan);
                            data.commit();
                            data.apply();
                            startActivity(intent);
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Username atau password salah",
                                Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }

    @Override
    public void onBackPressed() {

    }

}

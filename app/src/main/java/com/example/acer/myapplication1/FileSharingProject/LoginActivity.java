package com.example.acer.myapplication1.FileSharingProject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.myapplication1.FileSharingProject.APIinterface.ApiInterface;
import com.example.acer.myapplication1.FileSharingProject.APImanager.ApiClient;
import com.example.acer.myapplication1.FileSharingProject.APIresponse.LoginResponse;
import com.example.acer.myapplication1.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText loginEmail, loginPassword;
    Button loginBtn;
    LinearLayout linearLayout;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //[strt]Hide Title bar

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_login);

        //[End]Hide Title bar

        loginEmail=findViewById(R.id.loginEmail);
        loginPassword=findViewById(R.id.loginPassword);
        loginBtn=findViewById(R.id.loginBtn);
        linearLayout=findViewById(R.id.linear1);
        progressbar = findViewById(R.id.progress);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.GONE);
                progressbar.setVisibility(View.VISIBLE);

                CheckLogin(loginEmail.getText().toString(),loginPassword.getText().toString());
            }
        });
    }

    private void CheckLogin(String loginEmail, String loginPassword) {
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

        final Call<LoginResponse> loginResponseCall = apiInterface.LOGIN_RESPONSE_CALL("1",loginEmail,loginPassword);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.body().getSuccess() == 200)
                {
                    linearLayout.setVisibility(View.VISIBLE);
                    progressbar.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this,response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("##",t.getMessage().toString());
            }
        });
    }
}

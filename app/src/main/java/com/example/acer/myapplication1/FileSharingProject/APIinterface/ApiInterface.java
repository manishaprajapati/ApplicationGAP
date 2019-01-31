package com.example.acer.myapplication1.FileSharingProject.APIinterface;

import android.widget.EditText;

import com.example.acer.myapplication1.FileSharingProject.APIresponse.LoginResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("loginControllerJson.php")
    Call<LoginResponse> LOGIN_RESPONSE_CALL(
            @Field("getLogin") String key,
            @Field("l_email") String email,
            @Field("l_password") String password);
}

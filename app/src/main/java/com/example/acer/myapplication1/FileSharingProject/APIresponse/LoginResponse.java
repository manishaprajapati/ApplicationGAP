package com.example.acer.myapplication1.FileSharingProject.APIresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("l_id")
    @Expose
    private String lId;
    @SerializedName("l_email")
    @Expose
    private String lEmail;
    @SerializedName("l_password")
    @Expose
    private String lPassword;
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;

    public String getLId() {
        return lId;
    }

    public void setLId(String lId) {
        this.lId = lId;
    }

    public String getLEmail() {
        return lEmail;
    }

    public void setLEmail(String lEmail) {
        this.lEmail = lEmail;
    }

    public String getLPassword() {
        return lPassword;
    }

    public void setLPassword(String lPassword) {
        this.lPassword = lPassword;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
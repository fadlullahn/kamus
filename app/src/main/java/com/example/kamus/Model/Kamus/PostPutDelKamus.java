package com.example.kamus.Model.Kamus;

import com.google.gson.annotations.SerializedName;

public class PostPutDelKamus {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Kamus mHeros;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Kamus getHeros() {
        return mHeros;
    }
    public void setHeros(Kamus Heros) {
        mHeros = Heros;
    }
}

package com.example.kamus.Model.Kamus;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GetKamus {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Kamus> listDataHeros;
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
    public List<Kamus> getListDataHeros() {
        return listDataHeros;
    }
    public void setListDataHeros(List<Kamus> listDataHeros) {
        this.listDataHeros = listDataHeros;
    }
}

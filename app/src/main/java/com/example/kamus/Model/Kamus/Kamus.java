package com.example.kamus.Model.Kamus;

import com.google.gson.annotations.SerializedName;

public class Kamus {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("ilmiah")
    private String ilmiah;
    @SerializedName("kategori")
    private String kategori;
    @SerializedName("image")
    private String image;
    @SerializedName("deskripsi")
    private String deskripsi;

    public Kamus(){}

    public Kamus(String id, String name, String ilmiah, String kategori, String image, String deskripsi) {
        this.id = id;
        this.name = name;
        this.ilmiah = ilmiah;
        this.kategori = kategori;
        this.image = image;
        this.deskripsi = deskripsi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIlmiah() {
        return ilmiah;
    }

    public void setIlmiah(String ilmiah) {this.ilmiah = ilmiah; }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDeskripsi() {return deskripsi; }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}
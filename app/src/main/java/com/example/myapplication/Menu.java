package com.example.myapplication;

public class Menu {
    private String nama;
    private String harga;
    private String gambar;
    private String produkid;

    public Menu(String datanama, String dataharga, String datagambar, String dataid) {
        nama = datanama;
        harga = dataharga;
        gambar = datagambar;
        produkid = dataid;
    }

    public String getNama() {
        return nama;
    }

    public String getHarga() {
        return harga;
    }

    public String getGambar() {
        return gambar;
    }

    public String getProdukid() {
        return produkid;
    }
}

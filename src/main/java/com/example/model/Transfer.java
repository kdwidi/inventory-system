/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.io.Serializable;

/**
 *
 * @author riel
 */
public class Transfer implements Serializable {

    private final String id;
    private final String barang;
    private final int jumlah;
    private final String tanggal;
    private final String petugas;
    private final String status;
    private final String transaksiTujuan;

    public Transfer(String id, String barang, int jumlah, String tanggal, String petugas, String status, String transaksiTujuan) {
        this.id = id;
        this.barang = barang;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
        this.petugas = petugas;
        this.status = status;
        this.transaksiTujuan = transaksiTujuan;
    }
    
    public String getId() {
        return id;
    }

    public String getBarang() {
        return barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getPetugas() {
        return petugas;
    }

    public String getStatus() {
        return status;
    }

    public String getTransaksiTujuan() {
        return transaksiTujuan;
    }
}
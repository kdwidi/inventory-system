/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author riel
 */
public class Transaksi implements Serializable {
    private final String id;
    private final String idBarang;
    private final int jumlah;
    private final String tanggal;
    private final String idPetugas;

    public String getId() {
        return id;
    }

    public Transaksi(String id, String idBarang, int jumlah, String tanggal, String idPetugas) {
        this.id = id;
        this.idBarang = idBarang;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
        this.idPetugas = idPetugas;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }
    public String getIdPetugas() {
        return idPetugas;
    }
}

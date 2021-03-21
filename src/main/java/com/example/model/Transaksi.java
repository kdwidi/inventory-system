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
    private String id;
    private String idGudang;
    private String idBarang;
    private int jumlah;
    private String keterangan;
    private Date tanggal;
    private String idPetugas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdGudang() {
        return idGudang;
    }

    public void setIdGudang(String idGudang) {
        this.idGudang = idGudang;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    public String getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(String idPetugas) {
        this.idPetugas = idPetugas;
    }
}

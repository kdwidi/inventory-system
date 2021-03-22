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
public class Stok implements Serializable{
    
    private final String id;
    private final String nama;
    private final int jumlah;

    public Stok(String id, String nama, int jumlah) {
        this.id = id;
        this.nama = nama;
        this.jumlah = jumlah;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlah() {
        return jumlah;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

/**
 *
 * @author riel
 */
public class Petugas {
    private final String id;
    private final String nama;
    private final String gudang;
    
    public Petugas(String id, String nama, String gudang) {
        this.id = id;
        this.nama = nama;
        this.gudang = gudang;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getGudang() {
        return gudang;
    }
}

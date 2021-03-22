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
public class Petugas implements Serializable{
    private final String id;
    private final String nama;
    private final String password;
    private final String status;
    private final String gudang;
    
    public Petugas(String id, String nama, String password, String status, String gudang) {
        this.id = id;
        this.nama = nama;
        this.password = password;
        this.status = status;
        this.gudang = gudang;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
    
    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getGudang() {
        return gudang;
    }
}

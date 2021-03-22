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
public class Barang implements Serializable{
    
    private final String id;
    private final String nama;

    public Barang(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }
    
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
}

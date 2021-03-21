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
    private String idTfAsal;
    private String idGudangAsal;
    private String status;

    public String getIdTfAsal() {
        return idTfAsal;
    }

    public void setIdTfAsal(String idTfAsal) {
        this.idTfAsal = idTfAsal;
    }

    public String getIdGudangAsal() {
        return idGudangAsal;
    }

    public void setIdGudangAsal(String idGudangAsal) {
        this.idGudangAsal = idGudangAsal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdTfTujuan() {
        return idTfTujuan;
    }

    public void setIdTfTujuan(String idTfTujuan) {
        this.idTfTujuan = idTfTujuan;
    }
    private String idTfTujuan;
}

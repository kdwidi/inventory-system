/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.interfaces;

import com.example.model.Barang;
import com.example.model.Gudang;
import com.example.model.Petugas;
import com.example.model.Stok;
import com.example.model.Transaksi;
import com.example.model.Transfer;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author riel
 */
public interface Inventory extends Remote {

    Petugas cekPetugasLogin(String username, String password) throws RemoteException;

    Gudang getGudangById(String id) throws RemoteException;

    ArrayList<Stok> getStokGudang(String idGudang) throws RemoteException;

    ArrayList<Transaksi> getTransaksiGudang(String idGudang) throws RemoteException;

    ArrayList<Transaksi> getTransaksiFilter(String filter) throws RemoteException;

    ArrayList<Barang> getAllBarang() throws RemoteException;

    ArrayList<Transfer> getTransferGudang(String idGudang) throws RemoteException;

    int insertBarang(Barang b) throws RemoteException;
    
    int insertTransaksi(Transaksi t) throws RemoteException;
    
    /*
        Administrator field
     */
    ArrayList<Gudang> getAllGudang() throws RemoteException;
    
    int updateGudang(Gudang g) throws RemoteException;

    ArrayList<Petugas> getAllPetugas() throws RemoteException;
    
    int insertGudang(Gudang g) throws RemoteException;
    
    int insertPetugas(Petugas p) throws RemoteException;
    
    int updatePetugas(Petugas p) throws RemoteException;
}

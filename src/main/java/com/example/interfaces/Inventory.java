/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.interfaces;

import com.example.model.Barang;
import com.example.model.Gudang;
import com.example.model.Petugas;
import com.example.model.Transaksi;
import com.example.model.Transfer;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author riel
 */
public interface Inventory extends Remote{
    Petugas cekPetugasLogin(String username, String password) throws RemoteException;
    ArrayList<Gudang> getAllGudang() throws RemoteException;
    Gudang getGudangById(String id) throws RemoteException;
    ArrayList<Transaksi> getTransaksiByGudang(String idGudang) throws RemoteException;
    ArrayList<Transaksi> getTransaksiByFilter(String filter) throws RemoteException;
    ArrayList<Barang> getAllBarang() throws RemoteException;
    ArrayList<Barang> searchBarangByName(String name) throws RemoteException;
    ArrayList<Transfer> getTransferByGudang(String idGudang) throws RemoteException;
}

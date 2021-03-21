/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.implementasi;

import com.example.model.Barang;
import com.example.model.Gudang;
import com.example.model.Transaksi;
import com.example.model.Transfer;
import com.example.server.dbconnection.DBConnection;
import java.rmi.RemoteException;
import com.example.interfaces.Inventory;
import com.example.model.Petugas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author riel
 */
public class InventoryImplementasi implements Inventory {

    private Connection connection = null;

    public InventoryImplementasi() {
        super();
        this.connection = new DBConnection().getConnection();
    }

    @Override
    public Petugas cekPetugasLogin(String username, String password) throws RemoteException {
        Petugas petugas = null;
        String sql = "SELECT id,nama,gudang FROM petugas WHERE username=? and password=? and status='aktif'";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                petugas = new Petugas(
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getString("gudang")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return petugas;
    }

    @Override
    public ArrayList<Gudang> getAllGudang() throws RemoteException {
        ArrayList<Gudang> listGudang = new ArrayList<>();
        String sql = "SELECT * FROM gudang";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Gudang gudang = new Gudang();
                gudang.setId(rs.getString("id"));
                gudang.setNama(rs.getString("nama"));
                gudang.setAlamat(rs.getString("alamat"));
                listGudang.add(gudang);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listGudang;
    }

    @Override
    public Gudang getGudangById(String id) throws RemoteException {
        Gudang gudang = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM gudang where id = '" + id + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                gudang = new Gudang();
                gudang.setId(rs.getString("id"));
                gudang.setNama(rs.getString("nama"));
                gudang.setAlamat(rs.getString("alamat"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return gudang;
    }

    @Override
    public ArrayList<Transaksi> getTransaksiByGudang(String idGudang) throws RemoteException {
        ArrayList<Transaksi> listTransaksi = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM transaksi WHERE id_gudang = '" + idGudang + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setId(rs.getString("id"));
                transaksi.setIdGudang(rs.getString("id_gudang"));
                transaksi.setIdBarang(rs.getString("id_barang"));
                transaksi.setJumlah(rs.getInt("jumlah"));
                transaksi.setKeterangan(rs.getString("keterangan"));
                transaksi.setTanggal(rs.getDate("tanggal"));
                transaksi.setIdPetugas(rs.getString("id_petugas"));
                listTransaksi.add(transaksi);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listTransaksi;
    }

    @Override
    public ArrayList<Transaksi> getTransaksiByFilter(String filter) throws RemoteException {
        ArrayList<Transaksi> listTransaksi = new ArrayList<>();
        String query = "SELECT * FROM transaksi WHERE " + filter;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setId(rs.getString("id"));
                transaksi.setIdGudang(rs.getString("id_gudang"));
                transaksi.setIdBarang(rs.getString("id_barang"));
                transaksi.setJumlah(rs.getInt("jumlah"));
                transaksi.setKeterangan(rs.getString("keterangan"));
                transaksi.setTanggal(rs.getDate("tanggal"));
                transaksi.setIdPetugas(rs.getString("id_petugas"));
                listTransaksi.add(transaksi);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listTransaksi;
    }

    @Override
    public ArrayList<Barang> getAllBarang() throws RemoteException {
        ArrayList<Barang> listBarang = new ArrayList<>();
        String query = "SELECT * FROM barang";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Barang barang = new Barang();
                barang.setId(rs.getString("id"));
                barang.setNama(rs.getString("id"));
                listBarang.add(barang);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listBarang;
    }

    @Override
    public ArrayList<Barang> searchBarangByName(String name) throws RemoteException {
        ArrayList<Barang> listBarang = new ArrayList<>();
        String query = "SELECT * FROM barang WHERE name LIKE '%" + name + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Barang barang = new Barang();
                barang.setId(rs.getString("id"));
                barang.setNama(rs.getString("nama"));
                listBarang.add(barang);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listBarang;
    }

    @Override
    public ArrayList<Transfer> getTransferByGudang(String idGudang) throws RemoteException {
        ArrayList<Transfer> listTransfers = new ArrayList<>();
        String query = "SELECT "
                + "id,"
                + "id_barang,"
                + "jumlah,"
                + "tanggal,"
                + "id_petugas,"
                + "status,"
                + "id_transaksi_tujuan "
                + "from transaksi i inner join transfer j on i.id = j.id_transaksi_asal where id like '%" + idGudang + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listTransfers;
    }

}

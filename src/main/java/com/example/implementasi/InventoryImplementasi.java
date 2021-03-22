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
import com.example.model.Stok;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String query = "SELECT id,nama,gudang FROM petugas WHERE id=? and password=? and status='aktif'";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                petugas = new Petugas(
                        rs.getString("id"),
                        rs.getString("nama"),
                        null,
                        null,
                        rs.getString("gudang")
                );
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return petugas;
    }

    @Override
    public Gudang getGudangById(String id) throws RemoteException {
        Gudang gudang = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM gudang where id = '" + id + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                gudang = new Gudang(
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getString("alamat")
                );
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return gudang;
    }

    @Override
    public ArrayList<Stok> getStokGudang(String idGudang) throws RemoteException {
        ArrayList<Stok> listStok = null;
        String query = "SELECT barang,sum(jumlah) as jumlah,nama FROM transaksi INNER JOIN barang ON transaksi.barang = barang.id WHERE transaksi.id like ? GROUP BY transaksi.barang";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + idGudang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (listStok == null) {
                    listStok = new ArrayList<>();
                }
                Stok stok = new Stok(
                        rs.getString("barang"),
                        rs.getString("nama"),
                        Integer.parseInt(rs.getString("jumlah"))
                );
                listStok.add(stok);
            }
        } catch (NumberFormatException e) {
            System.err.println(e);
        } catch (SQLException ex) {
            Logger.getLogger(InventoryImplementasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStok;
    }

    @Override
    public ArrayList<Transaksi> getTransaksiGudang(String idGudang) throws RemoteException {
        ArrayList<Transaksi> listTransaksi = null;
        String query = "SELECT * FROM transaksi WHERE id like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + idGudang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (listTransaksi == null) {
                    listTransaksi = new ArrayList<>();
                }
                Transaksi transaksi = new Transaksi(
                        rs.getString("id"),
                        rs.getString("barang"),
                        rs.getInt("jumlah"),
                        rs.getString("tanggal"),
                        rs.getString("petugas")
                );
                listTransaksi.add(transaksi);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return listTransaksi;
    }

    @Override
    public ArrayList<Transaksi> getTransaksiFilter(String filter) throws RemoteException {
        ArrayList<Transaksi> listTransaksi = null;
        String query = "SELECT * FROM transaksi WHERE " + filter;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (listTransaksi == null) {
                    listTransaksi = new ArrayList<>();
                }
                Transaksi transaksi = new Transaksi(
                        rs.getString("id"),
                        rs.getString("barang"),
                        rs.getInt("jumlah"),
                        rs.getString("tanggal"),
                        rs.getString("petugas")
                );
                listTransaksi.add(transaksi);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return listTransaksi;
    }

    @Override
    public ArrayList<Barang> getAllBarang() throws RemoteException {
        ArrayList<Barang> listBarang = null;
        String query = "SELECT * FROM barang";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (listBarang == null) {
                    listBarang = new ArrayList<>();
                }
                Barang barang = new Barang(
                        rs.getString("id"),
                        rs.getString("nama")
                );
                listBarang.add(barang);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return listBarang;
    }

    @Override
    public ArrayList<Transfer> getTransferGudang(String idGudang) throws RemoteException {
        ArrayList<Transfer> listTransfers = null;
        String query = "SELECT id,barang,jumlah,tanggal,petugas,status,transaksi_tujuan FROM transaksi INNER JOIN transfer ON id=transaksi_asal WHERE gudang_tujuan LIKE ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + idGudang + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (listTransfers == null) {
                    listTransfers = new ArrayList<>();
                }
                Transfer tx = new Transfer(
                        rs.getString("id"),
                        rs.getString("barang"),
                        rs.getInt("jumlah"),
                        rs.getString("tanggal"),
                        rs.getString("petugas"),
                        rs.getString("status"),
                        rs.getString("transaksi_tujuan")
                );
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return listTransfers;
    }

    /*
        Administrator field
     */
    @Override
    public ArrayList<Gudang> getAllGudang() throws RemoteException {
        ArrayList<Gudang> listGudang = null;
        String query = "SELECT * FROM gudang";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (listGudang == null) {
                    listGudang = new ArrayList<>();
                }
                Gudang gudang = new Gudang(
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getString("alamat")
                );
                listGudang.add(gudang);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return listGudang;
    }

    @Override
    public int updateGudang(Gudang g) throws RemoteException {
        String query = "UPDATE gudang set nama=?, alamat=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, g.getNama());
            ps.setString(2, g.getAlamat());
            ps.setString(3, g.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return -1;
    }

    @Override
    public ArrayList<Petugas> getAllPetugas() throws RemoteException {
        ArrayList<Petugas> listPetugas = null;
        String query = "SELECT * FROM petugas";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (listPetugas == null) {
                    listPetugas = new ArrayList<>();
                }
                Petugas petugas = new Petugas(
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getString("password"),
                        rs.getString("status"),
                        rs.getString("gudang")
                );
                listPetugas.add(petugas);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return listPetugas;
    }

    @Override
    public int insertGudang(Gudang g) throws RemoteException {
        String query = "INSERT gudang VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, g.getId());
            ps.setString(2, g.getNama());
            ps.setString(3, g.getAlamat());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return -1;
    }
}

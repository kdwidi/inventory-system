/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author riel
 */
public class Test {

    public static void main(String[] args) throws NoSuchAlgorithmException, NotBoundException, MalformedURLException, RemoteException {
//        Inventory inventory = (Inventory) Naming.lookup("rmi://localhost:5000/inventory");
//        System.out.println(inventory.test(45, 12));
//        System.out.println(inventory.getGudangById("GC").getNama());
//        for(Gudang g:inventory.getAllGudang()) {
//            System.out.println(g.getNama());
//        }

        Map<String, String> f = new HashMap<>();
        f.put("id_gudang", "GA");
        f.put("id_barang", "BB");
        test(f);
    }

    public static void test(Map<String, String> filter) {
        String query = "SELECT * FROM transaksi";
        if (!filter.isEmpty()) {
            query += " where ";
            for (Entry<String, String> entry : filter.entrySet()) {
                query += entry.getKey() + "='" + entry.getValue()+"' ";
                
            }
        }
        System.out.println(query);
    }
}

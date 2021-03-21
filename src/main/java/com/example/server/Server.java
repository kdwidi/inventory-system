/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.server;

import com.example.interfaces.Inventory;
import com.example.implementasi.InventoryImplementasi;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Server {

    public static void main(String[] args) {

        System.out.println("Menjalankan server");
        Registry registry;
        try {
            Inventory server = new InventoryImplementasi();
            Inventory stub = (Inventory) UnicastRemoteObject.exportObject((Inventory) server, 0);
            registry = LocateRegistry.createRegistry(5000);
            registry.rebind("inventory", stub);
            System.out.println("Server Telah Berjalan");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.server.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author riel
 */
public class DBConnection {
    private Connection connection = null;

    public DBConnection() {
        String Driver, url, user, pass;
        Driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/inventory?zeroDateTimeBehavior=convertToNull";
        user = "root";
        pass = "toor";
        try {
            Class.forName(Driver);
            this.connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Berhasil terhubung ke database");
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Connection getConnection() {
        return this.connection;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
package Koneksi;
import java.sql.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class KoneksiDataBase {
       Connection cn;
    public static Connection BukaKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/data_base_crud", "root", "");
            return cn;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}*/
package Koneksi;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/data_base_crud";
    private static final String USER = "root"; // ganti dengan username MySQL Anda
    private static final String PASSWORD = ""; // ganti dengan password MySQL Anda

    public static Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cn;
    }
}

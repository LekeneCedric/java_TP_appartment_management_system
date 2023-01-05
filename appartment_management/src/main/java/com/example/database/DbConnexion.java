package com.example.database;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnexion {
    private Connection con;
    private static DbConnexion dbc;
    private DbConnexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoow","root","root");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static DbConnexion getDatabaseConnection() {
        if (dbc == null) {
            dbc = new DbConnexion();
        }
        return dbc;
    }

    public Connection getConnection() {
        return con;
    }

    public static void main(String[] args) {
        new DbConnexion();
    }
}

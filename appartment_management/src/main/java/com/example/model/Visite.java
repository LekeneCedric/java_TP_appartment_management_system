package com.example.model;

import com.example.database.DbConnexion;
import com.example.interfaces.Ivisite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Visite implements Ivisite {
    static int counter = 1;
    private int id;
    public String remarque;
    public String decision;
    public Date date;
    public Appartement appartement;
    public Client client;

    private Connection con = DbConnexion.getDatabaseConnection().getConnection();
    public Visite(String remarque, String decision, Date date)
    {
        this.id = counter ;
        this.remarque = remarque;
        this.decision = decision;
        this.date = date;
        counter++;
    }
    public Visite(String remarque, String decision, Date date, Appartement appartement, Client client) {
        this.id = counter ;
        this.remarque = remarque;
        this.decision = decision;
        this.date = date;
        this.appartement = appartement;
        this.client = client;
        counter++;
    }

    @Override
    public void addVisite(String remarque, String decision, Date date, Appartement appartement, Client client) {
        String request = "INSERT INTO visite VALUE (?,?,?,?,?,?)";
        try
        {
            Statement stmt = this.con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1,id);
            pstmt.setInt(2,appartement.id);
            pstmt.setInt(3,client.id);
            pstmt.setString(2,remarque);
            pstmt.setString(3,decision);
            pstmt.setDate(4, (java.sql.Date) date);
            ResultSet res = pstmt.executeQuery();
            System.out.println("visite ajoute avec success !");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateVisite(String remarque, String decision, Date date, Appartement appartement, Client client) {
        String request = "UPDATE visite SET id_appartement='?',id_client='?',remarque='?',decision='?' date='?' WHERE id=?";
        try
        {
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1,appartement.id);
            pstmt.setInt(2,client.id);
            pstmt.setString(3,remarque);
            pstmt.setString(4,decision);
            pstmt.setDate(5,(java.sql.Date) date);
            pstmt.setFloat(6,this.id);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Visite modifie avec success ! ");
            this.appartement = appartement;
            this.client = client;
            this.remarque = remarque;
            this.decision = decision;
            this.date = date;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteVisite() {
        String request = "DELETE FROM visite WHERE id=?";
        try {
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1, this.id);
            ResultSet res = pstmt.executeQuery();
            System.out.println("visite supprime avec success ! ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

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
    private int id;
    public String remarque;
    public String decision;
    public Date date;
    public Appartement appartement;
    public Client client;

    private Connection con = DbConnexion.getDatabaseConnection().getConnection();
    public Visite(int id , String remarque, String decision, Date date, Appartement appartement, Client client) {
        this.id = id ;
        this.remarque = remarque;
        this.decision = decision;
        this.date = date;
        this.appartement = appartement;
        this.client = client;
    }

    @Override
    public void createVisite(String remarque, String decision, Date date, Appartement appartement, Client client) {
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
            System.out.println("Societe cree avec success !");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Map<String, ?> getVisite() {
        Map<String,String> map= new HashMap<String,String>();
        map.put("id", String.format("%d", this.id));
        map.put("remarque",this.remarque);
        return map;
    }

    @Override
    public void updateVisite(String remarque, String decision, Date date, Appartement appartement, Client client) {

    }

    @Override
    public void deleteVisite() {

    }
}

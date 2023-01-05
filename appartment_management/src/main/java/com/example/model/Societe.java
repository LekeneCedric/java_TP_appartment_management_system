package com.example.model;

import com.example.database.DbConnexion;
import com.example.interfaces.ISociete;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Societe implements ISociete {
    private static int counter=1;
    private int id ;
    public String name;
    public String adresse;
    public String location;

    private  Connection con;

    ResultSet res = null;

    public Societe(String name, String adresse, String location) {
        this.id = counter;
        this.name = name;
        this.adresse = adresse;
        this.location = location;
        counter ++;
        this.createSociete(this.name,this.adresse,this.location);
    }

    @Override
    public void createSociete(String name, String adresse, String location) {
        String request = "INSERT INTO societe VALUE (?,?,?,?)";
        try
        {
            Statement stmt = this.con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1,this.id);
            pstmt.setString(2,name);
            pstmt.setString(3,adresse);
            pstmt.setString(4,location);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Societe cree avec success");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Map getSociete() {
        Map<String,String> map= new HashMap<String,String>();
        map.put("id", String.format("%d", this.id) );
        map.put("name",this.name);
        map.put("adresse",this.adresse);
        map.put("location",this.location);
        return map;
    }

    @Override
    public void updateSociete(int id , String name, String adresse, String location) {
        String request = "UPDATE societe SET name='?',adresse='?',location='?' WHERE id=?";
        try
        {
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setString(1,name);
            pstmt.setString(2,adresse);
            pstmt.setString(3,location);
            pstmt.setInt(4,id);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Societe modifie avec success ! ");
            this.name = name ;
            this.adresse = adresse;
            this.location = location;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteSociete(int id_societe) {
        String request = "DELETE FROM societe WHERE id=?";
        try {
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1, id_societe);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Societe supprime avec success ! ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

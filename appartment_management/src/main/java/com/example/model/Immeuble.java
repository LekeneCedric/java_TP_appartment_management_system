package com.example.model;

import com.example.database.DbConnexion;
import com.example.interfaces.Iimmeuble;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Immeuble implements Iimmeuble {
    public static int counter=1;
    public int id =1;
    public String name;
    public String adresse;
    public int nb_appart;

    public Appartement[] appartements;
    private Connection con = DbConnexion.getDatabaseConnection().getConnection();
    public Immeuble()
    {}
    public Immeuble(String name, String adresse, int nb_appart) {
        this.id = counter;
        this.name = name;
        this.adresse = adresse;
        this.nb_appart = nb_appart;
        counter++;
    }

    @Override
    public void createImmeuble(String name ,String adresse , int nb_appart) {
        String request = "INSERT INTO immeuble VALUE (?,?,?,?)";
        try
        {
            Statement stmt = this.con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,adresse);
            pstmt.setInt(4,nb_appart);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Societe cree avec success !");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Map<String, String> getImmeuble() {
        Map<String,String> map= new HashMap<String,String>();
        map.put("id", String.format("%d", this.id) );
        map.put("name",this.name);
        map.put("adresse",this.adresse);
        map.put("nb_appart", String.format("%d",this.nb_appart ));
        return map;
    }

    @Override
    public void updateImmeuble(int id, String name , String adresse , int nb_appart) {
        String request = "UPDATE immeuble SET name='?',adresse='?',nb_appart='?' WHERE id=?";
        try
        {
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setString(1,name);
            pstmt.setString(2,adresse);
            pstmt.setInt(3,nb_appart);
            pstmt.setInt(4,id);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Immeuble modifie avec success ! ");
            this.name = name ;
            this.adresse = adresse;
            this.nb_appart = nb_appart;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteImmeuble(int id_immeuble) {
        String request = "DELETE FROM societe WHERE id=?";
        try {
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1, id_immeuble);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Societe supprime avec success ! ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void listAppart() {
        this.appartements = new Appartement[0];

    }
}

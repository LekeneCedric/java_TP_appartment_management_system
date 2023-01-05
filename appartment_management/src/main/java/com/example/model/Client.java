package com.example.model;

import com.example.database.DbConnexion;
import com.example.interfaces.Iclient;
import com.example.interfaces.Ipromesse;
import com.example.interfaces.Ivisite;
import com.example.interfaces.IvisiteClient;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Client extends Personne implements Iclient , IvisiteClient {

    private Connection con = DbConnexion.getDatabaseConnection().getConnection();
    public static int counter;
    public int id ;
    public String num_cni;
    public Client(String name, String surname, int age,String num_cni) {
        super(name, surname, age);
        this.id = counter;
        this.num_cni = num_cni;
        counter ++ ;
    }

    @Override
    public void createClient(String name, String surname, int age, String num_cni) {
        String request = "INSERT INTO client VALUE (?,?,?,?,?)";
        try
        {
            Statement stmt = this.con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1,this.id);
            pstmt.setString(2,name);
            pstmt.setString(3,surname);
            pstmt.setInt(4,age);
            pstmt.setString(5,num_cni);
            ResultSet res = pstmt.executeQuery();
            System.out.println("client cree avec success !");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Map<String, String> getClientEntreprise() {
        Map<String , String > map = new HashMap<>();
        map.put("name",this.name);
        map.put("surname",this.surname);
        map.put("age",String.format("%d",this.age));
        map.put("num_cni",this.num_cni);
        return map;
    }

    @Override
    public Map<String, String> getClient() {
        Map<String , String > map = new HashMap<>();
        map.put("name",this.name);
        map.put("surname",this.surname);
        map.put("age",String.format("%d",this.age));
        map.put("num_cni",this.num_cni);
        return map;
    }

    @Override
    public void updateClient(String name, String surname, int age, String num_cni) {
        String request = "UPDATE client SET name='?',surname='?',age='?',num_cni='?' WHERE id=?";
        try
        {
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setString(1,name);
            pstmt.setString(2,surname);
            pstmt.setInt(3,age);
            pstmt.setString(4,num_cni);
            pstmt.setFloat(5,this.id);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Immeuble modifie avec success ! ");
            this.name = name ;
            this.surname = surname ;
            this.age = age ;
            this.num_cni =  num_cni;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteClient(int id_client) {
        String request = "DELETE FROM client WHERE id=?";
        try {
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1, this.id);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Client supprime avec success ! ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void clientnewVisite(String remarque, String decision, Date date, Appartement appartement, Client client) {
        Visite visite = new Visite(remarque,decision,date,appartement,client);
        visite.addVisite(remarque, decision, date , appartement,client);
    }

    @Override
    public ArrayList<Visite> mesVisites() {
        ArrayList<Visite> visites = new ArrayList<Visite>();
        String request = "SELECT * FROM visite WHERE id_client = ? ";
        try
        {
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1,this.id);

            ResultSet res = pstmt.executeQuery();
            ResultSetMetaData rsmd = res.getMetaData();
            int nb_res = rsmd.getColumnCount();
            boolean next = res.next();
            while (next)
            {
                for(int i=1;i<=nb_res;i++)
                {
                    visites.add(new Visite(res.getString(1),res.getString(2),res.getDate(3)));
                }
                next = res.next();
            }
            return visites;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

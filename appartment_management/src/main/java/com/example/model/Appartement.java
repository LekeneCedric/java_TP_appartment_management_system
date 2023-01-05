package com.example.model;

import com.example.database.DbConnexion;
import com.example.interfaces.Iappartement;
import com.example.interfaces.IvisiteAppartement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Appartement implements Iappartement , IvisiteAppartement {

    public static int counter = 1;
    public int id_immeuble;
    public int id;
    public int num;
    public float superficie;
    public int nb_chambre;
    public float prix;
    public Connection con = DbConnexion.getDatabaseConnection().getConnection();
    public Appartement()
    {}
        public Appartement(int num,float superficie,int nb_chambre,float prix,int id_immeuble) {
        this.id_immeuble = id_immeuble;
        this.num = num ;
        this.superficie = superficie;
        this.nb_chambre = nb_chambre;
        this.prix = prix;
    }

    @Override
    public void createAppartement(int num, float superficie, int nb_chambre, float prix,int id_immeuble) {
        String request = "INSERT INTO appartement VALUE (?,?,?,?,?,?)";
        try
        {
            Statement stmt = this.con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1,id);
            pstmt.setInt(2,id_immeuble);
            pstmt.setInt(3,num);
            pstmt.setFloat(4,superficie);
            pstmt.setInt(5,nb_chambre);
            pstmt.setFloat(6,prix);
            ResultSet res = pstmt.executeQuery();
            System.out.println("appartement cree avec success !");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Map<String, String> getAppart() {
        Map<String,String> map= new HashMap<String,String>();
        map.put("id", String.format("%d", this.id) );
        map.put("id_immeuble",String.format("%d",this.id_immeuble));
        map.put("numero", String.format("%d",this.num ));
        map.put("nb_chambre",String.format("%d",this.nb_chambre ));
        map.put("superficie", String.format("%d",this.superficie ));
        map.put("prix",String.format("%d",this.prix));
        return map;
    }

    @Override
    public void updateAppartement(int num, float superficie, int nb_chambre, float prix) {
        String request = "UPDATE appartement SET num='?',superficie='?',nb_chambre='?',prix='?' WHERE id=?";
        try
        {
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1,num);
            pstmt.setFloat(2,superficie);
            pstmt.setInt(3,nb_chambre);
            pstmt.setFloat(4,prix);
            pstmt.setInt(5,id);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Immeuble modifie avec success ! ");
            this.num = num ;
            this.superficie = superficie;
            this.nb_chambre = nb_chambre;
            this.prix = prix;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAppartement(int id_appart) {
        String request = "DELETE FROM appartement WHERE id=?";
        try {
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1, id_appart);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Appartement supprime avec success ! ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void newVisite() {

    }

    @Override
    public ArrayList<Visite> listesVisites() {
        return null;
    }
}

package com.example.model;

import com.example.database.DbConnexion;
import com.example.interfaces.Ipromesse;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Promesse implements Ipromesse {
    private Connection con = DbConnexion.getDatabaseConnection().getConnection();
    static int counter = 0;
    public int id ;
    public float prix_TTC;
    public float avance_paiement;
    public Visite visite;
    public Avocat avocat;
    public Directeur directeur;
    public boolean is_signer;

    public Promesse(float prix_TTC, float avance_paiement, Visite visite , Avocat avocat , Directeur directeur) {
        this.id = counter;
        this.prix_TTC = prix_TTC;
        this.avance_paiement = avance_paiement;
        this.visite = visite;
        this.avocat = avocat;
        this.directeur = directeur;
        this.is_signer = false;
        counter++;
    }

    @Override
    public void nouvellePromesse() {
        String request = "INSERT into promesse VALUES (?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1,this.id);
            pstmt.setInt(2,this.visite.appartement.id);
            pstmt.setInt(3,this.visite.client.id);
            pstmt.setInt(4,this.avocat.id);
            pstmt.setInt(5,this.visite.client.id);
            pstmt.setFloat(6,this.prix_TTC);
            pstmt.setFloat(7,this.avance_paiement);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Promesse ajoute avec success ! ");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void annulerPromesse(int id,String cause) {
        String request = "DELETE * FROM promesse WHERE id = ?";
        String req2 = "INSERT INTO desistement VALUES (?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(request);
            pstmt.setInt(1,this.id);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Promesse supprime avec success ");
            PreparedStatement pstmt2 = con.prepareStatement(req2);
            pstmt2.setInt(1,this.id);
            pstmt2.setString(2, String.valueOf(java.time.LocalDate.now()));
            pstmt2.setString(3, cause);
        }
        catch (Exception e) {
        }

    }
}

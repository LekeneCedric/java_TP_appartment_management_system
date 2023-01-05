package com.example.model;

import com.example.database.DbConnexion;
import com.example.interfaces.Icontrat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Contrat implements Icontrat {
    static int counter;
    public int id ;
    public Client client;
    public Directeur directeur;
    public Avocat avocat;
    public float prix_vente;
    public Type_paiement type_paiement;
    public Date date_signature;
    private Connection con = DbConnexion.getDatabaseConnection().getConnection();
    public Contrat(float prix_vente, Type_paiement type_paiement, Date date_signature,Client client,Directeur directeur,Avocat avocat) {
        this.id = counter;
        this.prix_vente = prix_vente;
        this.type_paiement = type_paiement;
        this.date_signature = date_signature;
        this.client = client;
        this.directeur = directeur;
        this.avocat = avocat;
        counter ++;
    }

    @Override
    public void createContrat() {
        String req="INSERT INTO contrat VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement pstmt = con.prepareStatement(req);
            pstmt.setInt(1,this.id);
            pstmt.setInt(2,this.client.id);
            pstmt.setInt(3,this.directeur.id);
            pstmt.setInt(4,this.avocat.id);
            pstmt.setFloat(5,this.prix_vente);
            pstmt.setString(6, String.valueOf(this.type_paiement));
            pstmt.setDate(7, (java.sql.Date) this.date_signature);
            pstmt.setBoolean(8,false);
            ResultSet res = pstmt.executeQuery();
            System.out.println("Signature signe avec success");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

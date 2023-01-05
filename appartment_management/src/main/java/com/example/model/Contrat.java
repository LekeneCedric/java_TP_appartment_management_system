package com.example.model;

import java.util.Date;

public class Contrat {
    public Client client;
    public Directeur directeur;
    public Avocat avocat;
    public float prix_vente;
    public Type_paiement type_paiement;
    public Date date_signature;
    public Contrat(float prix_vente, Type_paiement type_paiement, Date date_signature,Client client,Directeur directeur,Avocat avocat) {
        this.prix_vente = prix_vente;
        this.type_paiement = type_paiement;
        this.date_signature = date_signature;
        this.client = client;
        this.directeur = directeur;
        this.avocat = avocat;
    }
}

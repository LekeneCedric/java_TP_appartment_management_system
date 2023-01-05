package com.example.model;

public class Promesse {
    public Appartement appartement;
    public float prix_TTC;
    public float avance_paiement;
    public Visite visite;
    public boolean is_signer;

    public Promesse(float prix_TTC, float avance_paiement, Visite visite,Appartement appartement) {
        this.appartement = appartement;
        this.prix_TTC = prix_TTC;
        this.avance_paiement = avance_paiement;
        this.visite = visite;
        this.is_signer = false;
    }
}

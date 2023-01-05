package com.example.interfaces;

import com.example.model.Appartement;
import com.example.model.Client;
import com.example.model.Visite;

import java.util.ArrayList;
import java.util.Date;

public interface IvisiteClient {
    void clientnewVisite(String remarque, String decision, Date date , Appartement appartement, Client client);
    ArrayList<Visite> mesVisites();
}

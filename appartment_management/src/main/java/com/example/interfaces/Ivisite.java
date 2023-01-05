package com.example.interfaces;

import com.example.model.Appartement;
import com.example.model.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
public interface Ivisite {
    void addVisite(String remarque, String decision, Date date, Appartement appartement, Client client);
    void updateVisite(String remarque, String decision, Date date, Appartement appartement, Client client);
    void deleteVisite();
}

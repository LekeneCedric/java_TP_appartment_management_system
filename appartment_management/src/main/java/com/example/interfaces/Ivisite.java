package com.example.interfaces;

import com.example.model.Appartement;
import com.example.model.Client;

import java.util.Date;
import java.util.Map;
public interface Ivisite {
    public void createVisite(String remarque, String decision, Date date, Appartement appartement, Client client);
    public Map<String,any> getVisite();
    public void updateVisite(String remarque, String decision, Date date, Appartement appartement, Client client);
    public void deleteVisite();
}

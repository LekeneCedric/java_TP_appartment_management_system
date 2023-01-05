package com.example.interfaces;

import com.example.model.Societe;
import java.util.Map;

public interface ISociete {
    public void createSociete(String name,String adresse,String location);
    public Map<String,String> getSociete();
    public void updateSociete(int id ,String name, String adresse, String location);
    public void deleteSociete(int id_societe);
}

package com.example.interfaces;

import com.example.model.Immeuble;

import java.util.Map;

public interface Iimmeuble {
    public void createImmeuble(String name , String adresse , int nb_appart);
    public Map<String,String> getImmeuble();
    public void updateImmeuble(int id , String name , String adresse , int nb_appart);
    public void deleteImmeuble(int id_immeuble);

    public void listAppart();
}

package com.example.interfaces;

import java.util.Map;

public interface Iappartement {
    public void createAppartement(int num,float superficie,int nb_chambre,float prix);
    public Map<String , String> getAppart();
    public void updateAppartement(int num,float superficie,int nb_chambre,float prix);
    public void deleteAppartement(int id_appart);
}

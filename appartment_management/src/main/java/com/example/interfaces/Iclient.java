package com.example.interfaces;

import java.util.Map;

public interface Iclient {
    public void createClient(String name , String surname , int age , String num_cni);
    public Map<String , String > getClientEntreprise();
    public Map<String , String > getClient();
    public void updateClient(String name , String surname , int age , String num_cni);
    public void deleteClient(int id_client);
}

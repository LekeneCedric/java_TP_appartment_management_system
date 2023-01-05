package com.example.model;

public class Client extends Personne{

    public static int counter;
    public int id ;
    public String num_cni;
    public Client(String name, String surname, int age,String num_cni) {
        super(name, surname, age);
        this.id = counter;
        this.num_cni = num_cni;
    }
}

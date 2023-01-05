package com.example.model;

public class Avocat extends Personne{

    public String num_auto;
    public Avocat(String name, String surname, int age,String num_auto) {
        super(name, surname, age);
        this.num_auto = num_auto;
    }
}

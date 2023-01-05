package com.example.model;

public class Directeur extends Personne{

    static int counter =1;
    public int id ;
    public Directeur(String name, String surname, int age)
    {
        super(name, surname, age);
        this.id = counter;
        counter++;
    }
}

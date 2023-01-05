package com.example.model;

public class Avocat extends Personne{
    static int counter = 1;
    public int id ;

    public String num_auto;
    public Avocat(String name, String surname, int age,String num_auto) {
        super(name, surname, age);
        this.id = counter;
        this.num_auto = num_auto;
        counter++;
    }
}

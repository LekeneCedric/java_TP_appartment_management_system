package com.example.model;

import java.util.Date;

public class Desistement {
    public int num_desis;
    public Date date;
    public String cause;
    public Promesse promesse;
    public boolean is_valider;

    public Desistement(int num_desis, Date date, String cause, Promesse promesse) {
        this.num_desis = num_desis;
        this.date = date;
        this.cause = cause;
        this.promesse = promesse;
        this.is_valider = false;
    }
}

package org.example.Models;

import java.security.PublicKey;

public class Rate {
    private int id;
    private  int iduser;

    private  int idincription;

    private int value;


    public  Rate(){}

    public Rate(int id, int iduser, int idincription, int value ) {
        this.id = id;
        this.iduser = iduser;
        this.idincription = idincription;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public int getIduser() {
        return iduser;
    }

    public int getIdincription() {
        return idincription;
    }

    public int getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public void setIdincription(int idincription) {
        this.idincription = idincription;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

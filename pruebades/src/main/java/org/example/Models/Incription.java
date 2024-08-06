package org.example.Models;

public class Incription {

    private int id ;
    private int iduser;

    private int idcorse;

    public Incription(int idcorsep, int iduserp){

    }
    public Incription(int id, int iduser, int idcorse) {
        this.id = id;
        this.iduser = iduser;
        this.idcorse = idcorse;
    }

    public int getId() {
        return id;
    }

    public int getIduser() {
        return iduser;
    }

    public int getIdcorse() {
        return idcorse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public void setIdcorse(int idcorse) {
        this.idcorse = idcorse;
    }
}

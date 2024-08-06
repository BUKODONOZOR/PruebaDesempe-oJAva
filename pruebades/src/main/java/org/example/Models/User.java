package org.example.Models;

public class User {

    private int id;
    private String name;
    private String email;

    private int state;

    public User(){

    }

    public User(String name , String email , int state ){
        this.id = id;
        this.name = name;
        this.email = email;
        this.state =state;
    }

    public User(int id ,String name , String email , int state ){
        this.id = id;
        this.name = name;
        this.email = email;
        this.state =state;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int isState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setState(int state) {
        this.state = state;
    }
}

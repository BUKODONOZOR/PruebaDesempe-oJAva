package org.example.Models;
/** Modelo de curso**/
public class Corse {

    private int id;
    private String name;

    private String description;

    public Corse(String name, String description){}

    /** constructor curso**/
    public Corse(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**Getters and Setters**/
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

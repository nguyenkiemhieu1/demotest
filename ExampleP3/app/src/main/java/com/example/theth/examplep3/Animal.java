package com.example.theth.examplep3;

/**
 * Created by Admin on 10/25/2017.
 */

public class Animal {
    private String ID;
    private String Name;
    private String Url;
    private String Id_Type;

    public Animal() {

    }

    public Animal(String ID, String name, String url, String id_Type) {
        this.ID = ID;
        Name = name;
        Url = url;
        Id_Type = id_Type;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public void setId_Type(String id_Type) {
        Id_Type = id_Type;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getUrl() {
        return Url;
    }

    public String getId_Type() {
        return Id_Type;
    }
}

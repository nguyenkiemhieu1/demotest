package com.example.btthuoi2.Bai1;

public class Model {
    String id;
    String Name;
    int Price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                '}';
    }
}

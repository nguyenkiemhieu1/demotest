package com.example.ktth_cd3_26_5;

import java.util.ArrayList;

public class dtproduct {
    String Name;
    int Price;
    ArrayList<String> Sizes;

    public dtproduct(String name, int price, ArrayList<String> sizes) {
        Name = name;
        Price = price;
        Sizes = sizes;
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

    public ArrayList<String> getSizes() {
        return Sizes;
    }

    public void setSizes(ArrayList<String> sizes) {
        Sizes = sizes;
    }
}

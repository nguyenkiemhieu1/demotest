package com.example.datajson;

public class demo {
    public String Name;
    public  String Career;
    public String Phone;

    @Override
    public String toString() {
        return "demo{" +
                "Name='" + Name + '\'' +
                ", Career='" + Career + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }

    public demo(){

    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCareer() {
        return Career;
    }

    public void setCareer(String career) {
        Career = career;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}


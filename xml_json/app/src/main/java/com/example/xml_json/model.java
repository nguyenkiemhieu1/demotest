package com.example.xml_json;

public class model {
    String Name;
    String Career;
    String Phone;

    public model(String name, String career, String phone) {
        Name = name;
        Career = career;
        Phone = phone;
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

    @Override
    public String toString() {
        return "model{" +
                "Name='" + Name + '\'' +
                ", Career='" + Career + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}

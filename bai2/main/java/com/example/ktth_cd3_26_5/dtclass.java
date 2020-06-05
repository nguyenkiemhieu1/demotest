package com.example.ktth_cd3_26_5;

public class dtclass {
    int id,lop,diem;
    String ten;

    public dtclass(int id, int lop, int diem, String ten) {
        this.id = id;
        this.lop = lop;
        this.diem = diem;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLop() {
        return lop;
    }

    public void setLop(int lop) {
        this.lop = lop;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}

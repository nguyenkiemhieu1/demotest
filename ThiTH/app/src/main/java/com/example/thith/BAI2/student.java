package com.example.thith.BAI2;

public class student {
    String id, lop, ten;
    int diem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return
                "id:'" + id + '\'' +
                ", lop:'" + lop + '\'' +
                ", ten:'" + ten + '\'' +
                ", diem:" + diem ;
    }
}


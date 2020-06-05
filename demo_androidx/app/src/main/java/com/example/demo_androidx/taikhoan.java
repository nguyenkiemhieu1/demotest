package com.example.demo_androidx;

public class taikhoan {
    public  int id_nguoidung;
    public  String taikhoan, matkhau;

    public taikhoan(int id_nguoidung, String taikhoan, String matkhau) {
        this.id_nguoidung = id_nguoidung;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public int getId_nguoidung() {
        return id_nguoidung;
    }

    public void setId_nguoidung(int id_nguoidung) {
        this.id_nguoidung = id_nguoidung;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}

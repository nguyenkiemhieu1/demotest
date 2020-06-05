package com.example.demo.Presenter.PresenterHocSinh;

import com.example.demo.Model.Model_hocsinh;
import com.example.demo.Model.ObjectClass.hocsinh;
import com.example.demo.ViewHienthi;

import java.util.ArrayList;
import java.util.List;

public class PresenterLogicHocSinh implements  IPresenterHocSinh {
    Model_hocsinh model_hocsinh;
    ViewHienthi viewHienthi;
    public PresenterLogicHocSinh(ViewHienthi viewHienthi){
        this.viewHienthi = viewHienthi;
        model_hocsinh = new Model_hocsinh();

    }
    @Override
    public void HienThiDanhSachHocSinh(int mahocsinh) {
        List<hocsinh> hocsinhList = new ArrayList<>();
        hocsinhList = model_hocsinh.LayDanhSachHocSinh("HienThiDanhSach", "DANHSACHHOCSINH", mahocsinh);
        if(hocsinhList.size() > 0){
            viewHienthi.hienthiDs(hocsinhList);
        }else {
            viewHienthi.LoiHienThi();
        }

    }


}

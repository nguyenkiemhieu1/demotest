package com.example.demo.Presenter.Them;

import com.example.demo.Model.Model_them;
import com.example.demo.Model.ObjectClass.hocsinh;
import com.example.demo.ViewThem;

public class PresenterThem implements IPresenterThem {
    ViewThem viewThem;
    Model_them model_them;

    public PresenterThem(ViewThem viewThem){
        this.viewThem = viewThem;
        model_them = new Model_them();
    }
    @Override
    public void Them(hocsinh hocsinh) {
        boolean kiemtra =model_them.Them(hocsinh);
        if(kiemtra){
            viewThem.themThanhCong();
        }else {
            viewThem.themThatBai();
        }
    }


}

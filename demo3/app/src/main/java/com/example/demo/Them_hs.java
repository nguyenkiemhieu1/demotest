package com.example.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.Model.ObjectClass.hocsinh;
import com.example.demo.Presenter.Them.PresenterThem;
import com.google.android.material.textfield.TextInputLayout;

public class Them_hs extends AppCompatActivity implements ViewThem, View.OnClickListener {
    PresenterThem presenterThem;
    EditText edt_name, edt_mark;
    Button btn_them1;
    TextInputLayout ip_edt_name,ip_edt_mark;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_them);

        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_mark = (EditText) findViewById(R.id.edt_mark);
        btn_them1 = (Button) findViewById(R.id.btnthem);
        ip_edt_mark = (TextInputLayout) findViewById(R.id.ip_edt_mark);
        ip_edt_name = (TextInputLayout) findViewById(R.id.ip_edt_name);

        btn_them1.setOnClickListener(this);

        presenterThem = new PresenterThem(this);
    }

    @Override
    public void themThanhCong() {
        Toast.makeText(this, " thành công", Toast.LENGTH_LONG).show();

    }

    @Override
    public void themThatBai() {
        Toast.makeText(this, "Thất bại", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View view) {
        String name = edt_name.getText().toString();
        String mark = edt_mark.getText().toString();
        if(name.trim().length()>0){
            ip_edt_name.setErrorEnabled(false);
            ip_edt_name.setError("");
        }else {
            ip_edt_name.setErrorEnabled(true);
            ip_edt_name.setError("Hãy Nhập Đầy Đủ Thông Tin");

        }

        if(mark.trim().length()>0){
            ip_edt_mark.setErrorEnabled(false);
            ip_edt_mark.setError("");
        }else {
            ip_edt_mark.setErrorEnabled(true);
            ip_edt_mark .setError("Hãy Nhập Đầy Đủ Thông Tin");

        }
        if(!ip_edt_mark.isErrorEnabled()&&!ip_edt_name.isErrorEnabled()){
            hocsinh hocsinh  = new hocsinh();
            hocsinh.setName(name);
            hocsinh.setMark(Integer.valueOf(mark));
            presenterThem.Them(hocsinh);
        }


    }

}

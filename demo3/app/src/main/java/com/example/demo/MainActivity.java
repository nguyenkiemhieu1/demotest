package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo.Adapter.AdapterDSHocSinh;
import com.example.demo.Model.ObjectClass.hocsinh;
import com.example.demo.Presenter.PresenterHocSinh.PresenterLogicHocSinh;


import java.util.List;

public class MainActivity extends AppCompatActivity implements  ViewHienthi {
    public  static final String SERVER_NAME  = "http://192.168.43.170/demo/xuly.php";
    RecyclerView recyclerView;
    PresenterLogicHocSinh presenterLogicHocSinh;
    int mahocsinh;
    Button btn_Them;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_ds);
        btn_Them = (Button) findViewById(R.id.btn_Them);
        btn_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getApplication(), Them_hs.class);
                startActivity(intent);
            }
        });


        presenterLogicHocSinh = new PresenterLogicHocSinh(this);
        presenterLogicHocSinh.HienThiDanhSachHocSinh(mahocsinh);

    }

    @Override
    public void hienthiDs(List<hocsinh> hocsinhList) {
        AdapterDSHocSinh adapterDSHocSinh = new AdapterDSHocSinh(this, hocsinhList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterDSHocSinh);
        adapterDSHocSinh.notifyDataSetChanged();
    }

    @Override
    public void LoiHienThi() {

    }


}

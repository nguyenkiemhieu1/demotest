package com.example.mot_so_thu;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mot_so_thu.database.DatabaseHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {
    String kq = "";
    Context contextct;
    int socau = 15;
    int index = 0;
    List<cauhoi> ds_cauhoi;
    cauhoi cauhientai;
    int caudung = 0;
    int monney = 0;
    int miligiay = 31000;
    CountDownTimer demthoigain, delay;
    TextView tvcauhoi, tvthongbao, tvthoigain, tvmoney;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    RadioGroup radioGroup;
    Button btnnext, btncheck;
    CheckBox cb50, cbhoi, cbgoi, cbdoi;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        anhxa();
        btncheck.setVisibility(View.GONE);
        DatabaseHandler db = new DatabaseHandler(PlayActivity.this);
        try {
            db.createdatabase();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(PlayActivity.this, "Lỗi tạo cơ sở dữ liệu", Toast.LENGTH_SHORT).show();
        }
        ds_cauhoi = new ArrayList<cauhoi>();
        ds_cauhoi = db.layngaunhien(socau);
        hienthi(index);
        thoigian();
        cb50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //cb50.setTextColor(Color.GRAY);
// vo hieu hoa khi chon vao
                cb50.setClickable(false);

                if (kq.equals("a")) {

                    radioButton2.setTextColor(Color.YELLOW);
                    radioButton3.setTextColor(Color.YELLOW);
                }
                if (kq.equals("b")) {
                    radioButton3.setTextColor(Color.YELLOW);
                    radioButton4.setTextColor(Color.YELLOW);

                }
                if (kq.equals("c")) {
                    radioButton1.setTextColor(Color.YELLOW);
                    radioButton2.setTextColor(Color.YELLOW);
                }
                if (kq.equals("d")) {
                    radioButton1.setTextColor(Color.YELLOW);
                    radioButton3.setTextColor(Color.YELLOW);
                }
            }
        });
        cbhoi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cbhoi.setClickable(false);
                Random rd = new Random();
                int a = 0, b = 0, c = 0, d = 0;
                if (kq.equals("a")) {
                    a = rd.nextInt((100 - 50 + 1) + 50);
                    b = rd.nextInt((100 - a + 1) + 0);
                    c = rd.nextInt((100 - a - b + 1) + 0);
                    d = 100 - a - b - c;
                }
                if (kq.equals("b")) {
                    b = rd.nextInt((100 - 50 + 1) + 50);
                    a = rd.nextInt((100 - b + 1) + 0);
                    c = rd.nextInt((100 - a - b + 1) + 0);
                    d = 100 - a - b - c;
                }
                if (kq.equals("c")) {
                    c = rd.nextInt((100 - 50 + 1) + 50);
                    b = rd.nextInt((100 - b + 1) + 0);
                    a = rd.nextInt((100 - c - b + 1) + 0);
                    d = 100 - a - b - c;
                }
                if (kq.equals("d")) {
                    d = rd.nextInt((100 - 50 + 1) + 50);
                    c = rd.nextInt((100 - d + 1) + 0);
                    b = rd.nextInt((100 - d - b + 1) + 0);
                    a = 100 - d - b - c;
                }
                String hoiykien = "-answer: A" + a + "%" + "\n-answer: B" + b + "%" + "\n -answer: C" + c + "%" + "\n- answer: D " + "%";
                Toast.makeText(getBaseContext(), hoiykien, Toast.LENGTH_LONG).show();
            }
        });
        cbgoi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cbgoi.setClickable(false);
                Random rd = new Random();
                int x = rd.nextInt((4 - 0 + 1) + 1);
                String goidien = "";
                if(x==1)
                {
                    goidien="your friend choose the answer: A";
                }else if(x==2)
                {
                    goidien="your friend choose the answer: B";
                }else if(x==3)
                {
                    goidien="your friend choose the answer: c";

                }else if(x==4)
                {
                    goidien="your friend choose the answer: d";
                }else{
                    goidien="your friend have no choose ";
                }
                Toast.makeText(getBaseContext(), goidien, Toast.LENGTH_LONG).show();
            }
        });
        cbdoi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cbdoi.setClickable(false);
                caudung += 1;
                switch(index)
                {
                    case 0:
                        monney = 500;
                        break;
                    case 1:
                        monney = 1000;
                        break;
                    case 2:
                        monney = 1500;
                        break;
                    case 3:
                        monney = 3000;
                        break;
                    case 4:
                        monney = 5000;
                        break;
                    case 5:
                        monney = 8000;
                        break;
                    case 6:
                        monney = 10000;
                        break;
                    case 7:
                        monney = 15000;
                        break;
                    case 8:
                        monney = 30000;
                        break;
                    case 9:
                        monney = 50000;
                        break;
                    case 10:
                        monney = 100000;
                        break;
                    case 11:
                        monney = 200000;
                        break;
                    case 12:
                        monney = 500000;
                        break;
                    case 13:
                        monney = 750000;
                        break;
                    case 14:
                        monney = 1000000;
                        break;

                }
                tvmoney.setTextColor(Color.BLACK);
                tvmoney.setText("you got:" + monney + "usd");
                index++;
                hienthi(index);
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getBaseContext(), "please choose one answer", Toast.LENGTH_SHORT).show();
                }else{
                    if(kq.equals("a"))
                    {
                        Toast.makeText(getBaseContext(), " đáp án dúng là "+kq.toUpperCase()+":"+cauhientai.cautraloi, Toast.LENGTH_SHORT).show();
                    }
                    if(kq.equals("b"))
                    {
                        Toast.makeText(getBaseContext(), " đáp án dúng là "+kq.toUpperCase()+":"+cauhientai.cautraloi, Toast.LENGTH_SHORT).show();
                    }
                    if(kq.equals("c"))
                    {
                        Toast.makeText(getBaseContext(), " đáp án dúng là "+kq.toUpperCase()+":"+cauhientai.cautraloi, Toast.LENGTH_SHORT).show();
                    }
                    if(kq.equals("d"))
                    {
                        Toast.makeText(getBaseContext(), " đáp án dúng là "+kq.toUpperCase()+":"+cauhientai.cautraloi, Toast.LENGTH_SHORT).show();
                    }
                    demthoigain.cancel();

                    kiemtracaudung();
                    index++;

                    if(index<socau)
                    {
                        hienthi(index);
                        thoigian();
                    }else{
                        index=0;
                        btnnext.setVisibility(View.GONE);
                        btncheck.setVisibility(View.VISIBLE);
                        tvthoigain.setVisibility(View.GONE);
                        cb50.setClickable(false);
                        cbhoi.setClickable(false);
                        cbgoi.setClickable(false);
                        cbdoi.setClickable(false);
                    }
                }
            }
        });
        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demthoigain.cancel();
                tvthoigain.setVisibility(View.GONE);
                index=socau;
                if(index>=socau)
                {
                    tvthongbao.setText("Total");
                    tvcauhoi.setText("your right choose "+caudung+"sentences");
                    radioButton1.setVisibility(View.GONE);
                    radioButton2.setVisibility(View.GONE);
                    radioButton3.setVisibility(View.GONE);
                    radioButton4.setVisibility(View.GONE);
                    index++;
                    btncheck.setText("continues");
                    index=0;
                    caudung=0;
                    monney=0;
                    // chay lai ham main lai
                    onCreate(savedInstanceState);


                }else{hienthi(index);
                kiemtralai();
                index++;
                }
            }
        });

    }

    public void thoigian() {
        demthoigain = new CountDownTimer(miligiay,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvthoigain.setText("Time:" + millisUntilFinished / 1000);

            }

            @Override
            public void onFinish() {
                kiemtracaudung();
                index++;
                if (index < socau) {
                    hienthi(index);
                    thoigian();
                } else {
                    index = 0;
                    btnnext.setVisibility(View.GONE);
                    btncheck.setVisibility(View.VISIBLE);
                    tvthoigain.setVisibility(View.GONE);
                    demthoigain.cancel();


                }

            }
        };
        demthoigain.start();
    }

    public void hienthi(int vitri) {

        radioButton1.setTextColor(Color.BLACK);
        radioButton2.setTextColor(Color.BLACK);
        radioButton3.setTextColor(Color.BLACK);
        radioButton4.setTextColor(Color.BLACK);
        tvthongbao.setText("Sentense:" + (vitri + 1) + "/" + (socau));

        cauhientai = ds_cauhoi.get(vitri);
        tvcauhoi.setText(cauhientai.cauhoi);
        tvmoney.setText("you got:" + monney + "usd");
        radioButton1.setText(cauhientai.a);
        radioButton2.setText(cauhientai.b);
        radioButton3.setText(cauhientai.c);
        radioButton4.setText(cauhientai.d);
        kq = cauhientai.dapan;
        // xoa check cua cac radiobutton cua radiogroup
        radioGroup.clearCheck();


    }

    public void kiemtracaudung() {
        String cautraloi = "";
        if (radioButton1.isChecked() == true) {
            cautraloi = "a";
        } else if (radioButton2.isChecked() == true) {
            cautraloi = "b";

        } else if (


                radioButton3.isChecked() == true) {
            cautraloi = "c";

        } else if (radioButton4.isChecked() == true) {
            cautraloi = "d";
        }
        // luu cau tra lio vao list danh sach
        ds_cauhoi.get(index).cautraloi = cautraloi;
        // kiem tra cau tra loi va dap an
        if (cautraloi.equalsIgnoreCase(cauhientai.dapan))
        {
            caudung += 1;
            switch(index)
            {
                case 0:
                    monney = 500;
                    break;
                case 1:
                    monney = 1000;
                    break;
                case 2:
                    monney = 1500;
                    break;
                case 3:
                    monney = 3000;
                    break;
                case 4:
                    monney = 5000;
                    break;
                case 5:
                    monney = 8000;
                    break;
                case 6:
                    monney = 10000;
                    break;
                case 7:
                    monney = 15000;
                    break;
                case 8:
                    monney = 30000;
                    break;
                case 9:
                    monney = 50000;
                    break;
                case 10:
                    monney = 100000;
                    break;
                case 11:
                    monney = 200000;
                    break;
                case 12:
                    monney = 500000;
                    break;
                case 13:
                    monney = 750000;
                    break;
                case 14:
                    monney = 1000000;
                    break;

            }
            tvmoney.setTextColor(Color.YELLOW);
            tvmoney.setText("you got:" + monney + "usd");

        } else {
            // kiem tra so cau khong dung
            if (index < 4) {
                monney = 0;
            }
            if (index < 9 && index >= 4) {
                monney = 5000;
            }
            if (index < 14 && index >= 9) {
                // tra vae tri gia cau10
                monney = 50000;
            }
            tvmoney.setTextColor(Color.RED);
            tvmoney.setText("you got:" + monney + "usd");
            //tra loi sai index bang so cau
            index = socau;
            if (index >= socau) {
                tvthongbao.setText("Total:");
                tvcauhoi.setText("you right chosse" + caudung + "sentences");
                radioButton1.setVisibility(View.GONE);
                radioButton2.setVisibility(View.GONE);
                radioButton3.setVisibility(View.GONE);
                radioButton4.setVisibility(View.GONE);
                btncheck.setText("Continue");


            }
        }
    }

    public void kiemtralai() {
        // dua tat ca radiobutton ve mau den moi khi an nut check
        radioButton1.setTextColor(Color.BLACK);
        radioButton2.setTextColor(Color.BLACK);
        radioButton3.setTextColor(Color.BLACK);
        radioButton4.setTextColor(Color.BLACK);
        // to mau cho dap an
        if (cauhientai.dapan.equalsIgnoreCase("a")) {
            radioButton1.setTextColor(Color.YELLOW);
        } else if (cauhientai.dapan.equalsIgnoreCase("b")) {
            radioButton2.setTextColor(Color.YELLOW);
        } else if (cauhientai.dapan.equalsIgnoreCase("c")) {
            radioButton3.setTextColor(Color.YELLOW);
        } else if (cauhientai.dapan.equalsIgnoreCase("d")) {
            radioButton1.setTextColor(Color.YELLOW);
        }
        //check vao cau tra loi nguoi dungf de nguoi dung check voi dap an
        if (cauhientai.cautraloi.equalsIgnoreCase("a")) {
            radioButton1.setChecked(true);
        } else if (cauhientai.cautraloi.equalsIgnoreCase("b")) {
            radioButton2.setChecked(true);
        } else if (cauhientai.cautraloi.equalsIgnoreCase("c")) {
            radioButton3.setChecked(true);
        } else if (cauhientai.cautraloi.equalsIgnoreCase("d")) {
            radioButton4.setChecked(true);
        }
        //disable  cac radiobutton ko cho nguoi dungf chon lai
        radioButton1.setEnabled(false);
        radioButton2.setEnabled(false);
        radioButton3.setEnabled(false);
        radioButton4.setEnabled(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // return super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.iconback, menu);
//        return true;
//    }

    private void anhxa() {
        //check box goi y
        cb50 = (CheckBox) findViewById(R.id.cb_5050);
        cbhoi = (CheckBox) findViewById(R.id.cb_hoiykien);
        cbdoi = (CheckBox) findViewById(R.id.cb_quacaunay);
        cbgoi = (CheckBox) findViewById(R.id.cb_goidien);
        //check&next
        btnnext = (Button) findViewById(R.id.btn_next);
        btncheck = (Button) findViewById(R.id.btn_check);
        //Radio group
        radioGroup = (RadioGroup) findViewById(R.id.rg_dapan);
        //radio button
        radioButton1 = (RadioButton) findViewById(R.id.rb_cau1);
        radioButton2 = (RadioButton) findViewById(R.id.rb_cau2);
        radioButton3 = (RadioButton) findViewById(R.id.rb_cau3);
        radioButton4 = (RadioButton) findViewById(R.id.rb_cau4);
        //textview goi y
        tvcauhoi = (TextView) findViewById(R.id.tv_cauhoi);
        tvmoney = (TextView) findViewById(R.id.tv_money);
        tvthoigain = (TextView) findViewById(R.id.tv_thoigian);
        tvthongbao = (TextView) findViewById(R.id.tv_thongbao);


    }

}

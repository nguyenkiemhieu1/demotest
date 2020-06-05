package com.example.mot_so_thu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class giaodien_fist extends AppCompatActivity {
Context context=this;
Button btnplay,btnuse,btnexits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodien_fist);
        anhxa();
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PlayActivity.class);
                startActivity(intent);
            }
        });
        btnuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerdialogbuilder=new AlertDialog.Builder(context);
alerdialogbuilder.setTitle(" How to play Who want to be MILLIONAIRE!"+"\n-Translate vie: Làm thế nào chơi vậy ai sẽ là triệu phú"
        );
alerdialogbuilder.setMessage("- Bạn có 15 câu hỏi để trở thành đồ đệ của anh Hưng"+"\n- Và sẽ có 4 sự trợ giúp khi trả lời xon tất cả câu hỏi"+"\n-Chúc may mắn bạn có thể trơt hành đồ đệ của anh Hưng")
        .setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
//create dialog
                AlertDialog alertDialog=alerdialogbuilder.create();
                //hiện thị
                alertDialog.show();
            }
        });
        btnexits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerdialogbuilder=new AlertDialog.Builder(context);
                alerdialogbuilder
                        .setMessage(" thoát trở thành đệ của đại ka hưng thật à?")
                        .setCancelable(false)
                        .setPositiveButton("yes,gà", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(0);
                            }
                        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog=alerdialogbuilder.create();
                alertDialog.show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerdialogbuilder=new AlertDialog.Builder(context);
        alerdialogbuilder.setMessage(" bạn có muốn thoát ra main đầu??").setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog=alerdialogbuilder.create();
        alertDialog.show();
      //  super.onBackPressed();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
////        return super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.iconback,menu);
//        return true;
//    }

    private void anhxa() {
        btnplay=(Button)findViewById(R.id.btn_play);
        btnuse=(Button)findViewById(R.id.btn_use);
        btnexits=(Button)findViewById(R.id.btn_exit);
    }
}

package com.example.mot_so_thu.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.mot_so_thu.cauhoi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    // Khai báo biến
    private Context dbContext;
    public SQLiteDatabase db;
    private static final String dbPath = "/data/data/com.example.mot_so_thu/databases/";
    private static final String dbName = "dapan.sqlite";
    private static final int dbVersion = 1;
    private SQLiteDatabase mydatabase;
    private static String Table_name = "bangcauhoi";
    private Context mycontext;


// Phương thức 1: Phương thức khởi dựng

//    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, Context dbContext) {
//        super(context, name, factory, version);
//        this.dbContext = dbContext;
//    }

    public DatabaseHandler(Context context) {
        super(context, dbName, null, dbVersion);
        mycontext = context;
//        this.dbContext = context;
    }

    public void copyDB2SDCard() {// throws IOException {
        boolean check = false;
        try {
            File file = new File(dbPath);
            check = file.exists();
            if (check) {
                this.close();
            } else if (!check) {
                this.getReadableDatabase();
                InputStream myInput = dbContext.getAssets().open(dbName);
                String outFileName = dbPath;
                OutputStream myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        } catch (Exception ex) {
            throw new Error("Lỗi không copy được database");
        }
    }

    public void copyDB2SDCard1() {
        SQLiteDatabase dbCheck = null;
        try {
            dbCheck = SQLiteDatabase.openDatabase(dbPath, null,
                    SQLiteDatabase.OPEN_READWRITE);
            if (dbCheck != null) {
                dbCheck.close();
            } else if (dbCheck == null) {
                InputStream myInput = dbContext.getAssets().open("dapan.sqlite");
                String outFileName = dbPath;
                OutputStream myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        } catch (Exception ex) {

        }
    }

    private void copydatabase() throws IOException {
        InputStream myinput = mycontext.getAssets().open(dbName);
        String outfilename = dbPath + dbName;
        OutputStream myoutput = new FileOutputStream(outfilename);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myinput.read(buffer)) > 0) {
            myoutput.write(buffer, 0, length);
        }
        myoutput.flush();
        myoutput.close();
        myinput.close();
    }

    // Phương thức 3: Mở CSDL
    public void opendatabase() throws SQLiteException {
        String mypath = dbPath + dbName;
        mydatabase = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READONLY);


    }

    public void openDB() {
        db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    // Phương thức 4: Đóng CSDL

    public synchronized void close() {
        if (mydatabase != null)
            mydatabase.close();
        super.close();
    }

    public void closeDB() {
        db.close();
    }

    //check database
    private boolean checkDatabase() {
        SQLiteDatabase checkdb = null;
        try {
            String mypath = dbPath + dbName;
            checkdb = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READONLY);

        } catch (SQLiteException e) {

        }
        if (checkdb != null)
            checkdb.close();
        return checkdb != null ? true : false;
    }

    //create database
    public void createdatabase() throws IOException {
        boolean dbExit = checkDatabase();
        if (dbExit) {

        } else {
            this.getReadableDatabase();
            try {
                copydatabase();
            }catch (IOException e){
                throw new Error("loi copy database");
            }
        }
    }
//lay tat ca cau hoi
    public  Cursor  laytatcacauhoi()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor contro=db.rawQuery("select*from bangcauhoi",null);
        return contro;
    }
    //lisst cau hoi
    public List<cauhoi>layngaunhien(int socau)
    {
        List<cauhoi> ds_cauhoi=new ArrayList<cauhoi>();
        String limit="0,"+socau;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor contro=db.query(Table_name,null,null,null,null,null,"random()",limit);

        contro.moveToFirst();
        do{
            cauhoi x=new cauhoi();
            x.id=Integer.parseInt(contro.getString(0));
            x.cauhoi=contro.getString(1);
            x.a=contro.getString(2);
            x.b=contro.getString(3);
            x.c=contro.getString(4);
            x.d=contro.getString(5);
            x.dapan=contro.getString(6);
            x.cautraloi="";
            ds_cauhoi.add(x);


        }while (contro.moveToNext());
        return ds_cauhoi;
    }

    //Phương thức 5: Đọc CSDL
    public Cursor getCursor(String strSQL) {
        //B1
        openDB();
        //B2
        Cursor c = db.rawQuery(strSQL, null);
        //B3
        return c;
    }


    public Cursor getCursor2(String sql) {
        openDB();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(sql, null);
        } catch (SQLiteException e) {
            e.printStackTrace();
            db.close();
        }
        return cursor;
    }


    //Phương thức 6: thực thi câu lệnh SQL: Insert, Update, Delete
    public void excuteSQL(String sql) {
        //B1
        openDB();
        //B2
        db.execSQL(sql);
        //B3
        closeDB();
    }

    // Phương thức 7: đếm đối tượng trong SQL
    public int GetCount(String sql) {
        openDB();
        Cursor cur = db.rawQuery(sql, null);
        int count = cur.getCount();
        closeDB();
        return count;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
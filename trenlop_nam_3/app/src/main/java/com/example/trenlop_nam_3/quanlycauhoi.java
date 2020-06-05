//package com.example.trenlop_nam_3;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//public class quanlycauhoi extends SQLiteOpenHelper {
//    private  Context myContext;
//    public SQLiteDatabase db;
//
//    private static final String dbPath = "/data/data/com.example.phantom/databases/dapan.sqlite";
//    private static final String dbName = "dapan.sqlite";
//    private static final int dbVersion = 1;
//private  static final String TABLE_NAME=  "tabcauhoi";
//    public void openDB() {
//        db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
//    }
//
//    public quanlycauhoi( Context context, String name,  SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//    }
//}

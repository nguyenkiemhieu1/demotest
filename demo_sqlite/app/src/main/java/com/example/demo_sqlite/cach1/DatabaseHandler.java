package com.example.demo_sqlite.cach1;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private  Context dbcontext;
    private  SQLiteDatabase db;
    private static String dbPath="/data/data/com.example/databases";
    private static String dbName="sss.db";
    private static final int dbVersion=1;
    private final Context mycontext;
    private  SQLiteDatabase sqLiteDatabase;

    public DatabaseHandler(Context context) {
        super(context,dbName, null, dbVersion);
        mycontext = context;
        createdatabase();
        this.getReadableDatabase();
    }

    public boolean openDatabase() throws SQLException{
        sqLiteDatabase = SQLiteDatabase.openDatabase(dbPath + dbName, null, SQLiteDatabase.CREATE_IF_NECESSARY) ;
   return  sqLiteDatabase != null;
    }

    public synchronized void close(){
        if(sqLiteDatabase!=null)
            sqLiteDatabase.close();
        super.close();
    }
    private boolean checkdatabase(){
//        SQLiteDatabase checkDB= null;
//        String myPath = dbPath + dbName;
//        checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
//        return checkDB != null ? true : false;
        File dbfile = new File(dbName+dbPath);
        return dbfile.exists();
    }
    public  void copydatabase() throws Exception{
        InputStream myInput=mycontext.getAssets().open(dbName);
        String openFilename= dbName + dbPath;
        OutputStream myOutput = new FileOutputStream(openFilename);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {

            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }
    public void createdatabase() throws Exception {
        boolean dbExit = checkdatabase();
        if (dbExit) {

        } else {

            this.getReadableDatabase();
            try {
                copydatabase();
            } catch (IOException e) {
                throw new Error("lỗi copy database");
            }
        }
    }
  /*  public  Cursor layhetcauhoi(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM bangcauhoi", null);
        return cursor;
    }*/


    public List<listcauhoi> layngaunhien( final  int i){
        openDatabase();
        List<listcauhoi> ds_cauhoi= new ArrayList<listcauhoi>();
       // String limit="0," + a;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from bangcauhoi order by random() limit 1", null );
        cursor.moveToFirst();
        do{
            listcauhoi c;
            c = new listcauhoi(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getInt(6));
            //c.cautraloi="";
            ds_cauhoi.add(c);
        }while (cursor.moveToNext());
            return ds_cauhoi;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

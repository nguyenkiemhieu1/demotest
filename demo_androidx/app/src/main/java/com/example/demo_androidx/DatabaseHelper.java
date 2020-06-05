package com.example.demo_androidx;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper  extends SQLiteOpenHelper {
    private static String DB_PATH = "/data/data/com.example.demo_androidx/databases/";
    private static String DB_NAME = "aaaa.sqlite";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase mdatabase;
    private final Context mcontext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if (android.os.Build.VERSION.SDK_INT >= 17)
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        else
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        this.mcontext = context;

        copyDataBase();

        this.getReadableDatabase();

    }



    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    private void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private void copyDBFile() throws IOException {
        InputStream mInput = mcontext.getAssets().open(DB_NAME);
        //InputStream mInput = mContext.getResources().openRawResource(R.raw.info);
        OutputStream mOutput = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0)
            mOutput.write(mBuffer, 0, mLength);
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public boolean openDataBase() throws SQLException {
        mdatabase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return mdatabase != null;
    }

    public List<taikhoan> getDaTa() {
        openDataBase();
        List<taikhoan> CauHoi = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        for (int i = 1; i < 16; i++) {
            Cursor cursor = db.rawQuery("select * from tblTiengViet order by random() limit 1", null);
            cursor.moveToFirst();
            do {
                taikhoan item;
                item = new taikhoan(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                CauHoi.add(item);
            } while (cursor.moveToNext());
        }
        db.close();
        return CauHoi;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

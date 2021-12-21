package com.rizaluardi.ppsdt1184102.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.rizaluardi.ppsdt1184102.model.Dosen;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_dosen"; // NAMA DATABASE
    private static final String TABLE_DOSEN = "table_dosen"; // NAMA TABEL
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DOSEN = "dosen";
    private static final String COLUMN_NIK = "nik";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // FUNGSI UNTUK MEMBUAT DATABASENYA
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_DOSEN + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_DOSEN + " TEXT,"
                + COLUMN_NIK + " TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    // FUNGSI UNTUK MENGECEK DATABASE ADA ATAU TIDAK.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOSEN);
        onCreate(db);
    }

    // FUNGSI UNTUK TAMBAH DATA DOSEN
    public void tambahDosen(Dosen dosen){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DOSEN, dosen.getDosen());
        values.put(COLUMN_NIK, dosen.getNik());

        db.insert(TABLE_DOSEN, null, values);
        db.close();
    }

    // FUNGSI UNTUK AMBIL 1 DATA DOSEN
    public Dosen getDosen(int id_dosen){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DOSEN, new String[]{COLUMN_ID, COLUMN_DOSEN, COLUMN_NIK},
                COLUMN_ID + "=?", new String[]{String.valueOf(id_dosen)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Dosen dosen = new Dosen(cursor.getString(1), cursor.getString(2));
        return dosen;
    }

    // FUNGSI UNTUK AMBIL SEMUA DATA DOSEN
    public List<Dosen> getSemuaDosen(){
        List<Dosen> dosenList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_DOSEN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Dosen dosen = new Dosen(cursor.getString(1), cursor.getString(2));
                dosenList.add(dosen);
            } while (cursor.moveToNext());
        }
        return dosenList;
    }

    // FUNGSI MENGHITUNG ADA BEBERAPA DATA
    public int getDosenCount(){
        String countQuery = "SELECT * FROM " + TABLE_DOSEN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // FUNGSI UPDATE DATA DOSEN
    public int updateDataDosen(Dosen dosen) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DOSEN, dosen.getDosen());
        values.put(COLUMN_NIK, dosen.getNik());
        return db.update(TABLE_DOSEN, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(dosen.getId())});
    }

    // FUNGSI HAPUS DATA 1 DOSEN
    public void hapusDataDosen(Dosen dosen) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DOSEN, COLUMN_ID + " = ?",
                new String[]{String.valueOf(dosen.getId())});
        db.close();
    }

    // FUNGSI UNTUK MENGHAPUS SEMUA DATA DOSEN
    public void hapusSemuaDataDosen(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_DOSEN);
    }
}

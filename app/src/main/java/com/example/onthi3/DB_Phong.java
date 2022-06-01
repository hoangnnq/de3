package com.example.onthi3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DB_Phong extends SQLiteOpenHelper {

    public static final String TableName = "Phong_MaDe";
    public static final String Id = "Id";
    public static final String HoTen = "HoTen";
    public static final String SoPhong = "SoPhong";
    public static final String DonGia = "DonGia";
    public static final String SoNgayLuuTru = "SoNgayLuuTru";

    public DB_Phong(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate="Create table if not exists "+TableName +"("+Id+" Integer Primary Key Autoincrement, "+HoTen+" Text,"+
                SoPhong+" Int,"+DonGia+" Int,"+SoNgayLuuTru+" Int)";
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists "+TableName);
        onCreate(db);
    }

    public void addTaxi(Phong_User taxi){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Id,taxi.getId());
        values.put(HoTen,taxi.getHoTen());
        values.put(SoPhong,taxi.getSoPhong());
        values.put(DonGia,taxi.getDonGia());
        values.put(SoNgayLuuTru,taxi.getSoNgayLuuTru());
        db.insert(TableName,null,values);
        db.close();
    }
    public ArrayList<Phong_User> getAllContact(){
        ArrayList<Phong_User> list =new ArrayList<>();
        String sql="Select * from "+TableName+ " ORDER BY "+SoPhong+" DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor curor= db.rawQuery(sql,null);
        if(curor!=null){
            while(curor.moveToNext()){
                Phong_User contact= new Phong_User(
                        curor.getInt(0),
                        curor.getString(1),
                        curor.getInt(2),
                        curor.getInt(3),
                        curor.getInt(4)
                );
                list.add(contact);
            }
        }
        return list;
    }
    public ArrayList<Phong_User> getbyTienPhong(int tien){
        ArrayList<Phong_User> list =new ArrayList<>();
        String sql="Select * from "+TableName+  " Where DonGia*SoNgayLuuTru " +" > "+tien+" ORDER BY "+SoPhong+" DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor curor= db.rawQuery(sql,null);
        if(curor!=null){
            while(curor.moveToNext()){
                Phong_User contact= new Phong_User(
                        curor.getInt(0),
                        curor.getString(1),
                        curor.getInt(2),
                        curor.getInt(3),
                        curor.getInt(4)
                );
                list.add(contact);
            }
        }
        return list;
    }
}

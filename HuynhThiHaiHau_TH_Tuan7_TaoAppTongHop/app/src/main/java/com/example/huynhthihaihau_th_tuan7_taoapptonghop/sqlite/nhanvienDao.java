package com.example.huynhthihaihau_th_tuan7_taoapptonghop.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.huynhthihaihau_th_tuan7_taoapptonghop.model.nhanvien;

import java.util.ArrayList;
import java.util.List;

public class nhanvienDao {
    private SQLiteDatabase db;
    //cótrustor cho phep khoi tao csdl
    public nhanvienDao(Context context){
        DBHelper1 helper = new DBHelper1(context);
        db = helper.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<nhanvien> get(String sql, String ...selectArgs){
        List<nhanvien> list = new ArrayList<>();
        Cursor cursor =db.rawQuery(sql,selectArgs);
        while (cursor.moveToNext()){
            nhanvien nv = new nhanvien();
            nv.setId(cursor.getString(cursor.getColumnIndex("id")));
            nv.setName(cursor.getString(cursor.getColumnIndex("name")));
            nv.setLuong(cursor.getFloat(cursor.getColumnIndex("luong")));
            //tra ve ds
            list.add(nv);
        }
        return list;
    }
    public  List<nhanvien> getAll(){
        String sql = "SELECT * FROM nhanvien";
        return get(sql);
    }
    //truyen vao id cua sinh vien
    public nhanvien getById(String id){
        String sql = "SELECT * FROM nhanvien WHERE id =?";
        List<nhanvien> list = get(sql,id);//gọi danh sach
        return list.get(0);
    }
    //them sinh vien đc truyen vao
    public long insert(nhanvien nv){
        ContentValues values = new ContentValues();
        values.put("id",nv.getId());
        values.put("name",nv.getName());
        values.put("luong",nv.getLuong());

        return db.insert("nhanvien",null,values);
    }
    public long update(nhanvien nv){
        ContentValues values = new ContentValues();
        values.put("name",nv.getName());
        values.put("luong",nv.getLuong());

        return db.update("nhanvien",values,"id=?",new String[]{nv.getId()});
    }
    public int delete(String id){

        return  db.delete("nhanvien","id=?",new String[]{id});
    }
}

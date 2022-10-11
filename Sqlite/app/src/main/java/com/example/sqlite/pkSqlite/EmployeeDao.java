package com.example.sqlite.pkSqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlite.pkModel.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private SQLiteDatabase db;

    public EmployeeDao(Context context) {
        DBHelper helper = new DBHelper(context);
        db = helper.getWritableDatabase();

    }
    @SuppressLint("Range")
    public List<Employee> get(String sql, String ...selectArgs) {
        List<Employee> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectArgs);
        while (cursor.moveToNext()) {
            Employee emp = new Employee();
            emp.setId(cursor.getString(cursor.getColumnIndex("id")));
            emp.setName(cursor.getString(cursor.getColumnIndex("name")));
            emp.setSalary(cursor.getFloat(cursor.getColumnIndex("salary")));

            list.add(emp);
        }
        return list;

    }
    public List<Employee> getAll(){
        String sql = "SELECT * FROM nhanvien";

        return get(sql);
    }
    public  Employee getById(String id){
        String sql = "SELECT * FROM nhanvien WHERE id = ?";
        List<Employee> list = get(sql, id);

        return list.get(0);

    }

    //chèn thông tin của 1 nhân viên dưới dạng đối số
    public long insert(Employee emp){
        ContentValues values = new ContentValues();
        values.put("id", emp.getId());
        values.put("name", emp.getName());
        values.put("salary", emp.getSalary());

        //gọi thực hiện phương thức insert
        return db.insert("nhanvien", null, values);

    }

    //cập nhận thông tin của 1 nhân viên dưới dạng đối số
    public long update(Employee emp){
        ContentValues values = new ContentValues();
        values.put("name", emp.getName());
        values.put("salary", emp.getSalary());

        //gọi thực hiện phương thức update
        return db.update("nhanvien",values, "id=?", new String[]{emp.getId()});

    }
    public int delete(String id){
        return db.delete("nhanvien", "id=?", new String[]{id});
    }
}

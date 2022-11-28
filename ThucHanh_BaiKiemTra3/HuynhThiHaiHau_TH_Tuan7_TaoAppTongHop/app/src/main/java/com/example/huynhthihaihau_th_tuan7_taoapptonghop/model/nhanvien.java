package com.example.huynhthihaihau_th_tuan7_taoapptonghop.model;

public class nhanvien {
    private String id,name;
    private float luong;

    public nhanvien() {
    }

    public nhanvien(String id, String name, float luong) {
        this.id = id;
        this.name = name;
        this.luong = luong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }
}


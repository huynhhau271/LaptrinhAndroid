package com.example.huynhthihaihau_th_tuan7_taoapptonghop;

public class Menu {
    private String Ten;
    private String MoTa;
    private String Tien;
    private int Hinh;

    public Menu(String ten, String moTa, String tien, int hinh) {
        Ten = ten;
        MoTa = moTa;
        Tien = tien;
        Hinh = hinh;

    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getTien() {
        return Tien;
    }

    public void setTien(String tien) {
        Tien = tien;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}

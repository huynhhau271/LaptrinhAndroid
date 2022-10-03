package com.example.huynhthihaihau_th_tuan7_taoapptonghop;

public class Menu {
    private String Ten;
    private String MoTa;
    private int Hinh;

    public Menu(String ten, String moTa, int hinh) {
        Ten = ten;
        MoTa = moTa;
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

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}

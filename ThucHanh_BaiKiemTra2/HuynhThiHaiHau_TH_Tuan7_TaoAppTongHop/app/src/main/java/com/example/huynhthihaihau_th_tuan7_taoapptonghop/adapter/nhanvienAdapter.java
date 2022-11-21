package com.example.huynhthihaihau_th_tuan7_taoapptonghop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.huynhthihaihau_th_tuan7_taoapptonghop.R;
import com.example.huynhthihaihau_th_tuan7_taoapptonghop.model.nhanvien;

import java.util.List;

public class nhanvienAdapter extends BaseAdapter {
    private Context context;
    private List<nhanvien> list;

    public nhanvienAdapter(Context context, List<nhanvien> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view ==null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_nhanvien_item,null);
        }
        TextView tvname = view.findViewById(R.id.tvName);
        TextView tvd = view.findViewById(R.id.tvLuong);

        nhanvien nv = list.get(i);
        tvname.setText(nv.getName());
        tvd.setText(""+nv.getLuong());//vì diem là kieu float nen phai chuyen doi sang chuoi thi moi có the setText

        return view;
    }
}


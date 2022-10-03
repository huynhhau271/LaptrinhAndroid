package com.example.huynhthihaihau_th_bt7_taoapptonghop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MenuAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private List<Menu> menuList;

    public MenuAdapter(Context context, int layout, List<Menu> menuList) {
        this.context = context;
        this.layout = layout;
        this.menuList = menuList;
    }

    @Override
    public int getCount() {
        return menuList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        //anh xa view
        TextView txtwTen = (TextView) view.findViewById(R.id.txtTen);
        TextView txtwMoTa = (TextView) view.findViewById(R.id.txtMoTa);
        ImageView imagHinh = (ImageView) view.findViewById(R.id.imgHinh);

        //gan gia tri
        Menu menu = menuList.get(i);
        txtwTen.setText(menu.getTen());
        txtwMoTa.setText(menu.getMoTa());
//        imagHinh.setImageResource(menu.getHinh());
        return view;
    }
}


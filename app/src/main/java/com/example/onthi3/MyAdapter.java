package com.example.onthi3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Phong_User> data;
    private LayoutInflater inflater;

    public MyAdapter(Activity activity,ArrayList<Phong_User>data){
        this.activity=activity;
        this.data=data;
        this.inflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        Phong_User s=data.get(i);
        return s.getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v =view;
        if(v==null){
            v=inflater.inflate(R.layout.list_item,null);
            TextView txtSoxe=v.findViewById(R.id.hoten);
            txtSoxe.setText(data.get(i).getHoTen());

            TextView txtQuangDuong=v.findViewById(R.id.Phong);
            txtQuangDuong.setText("Phòng :"+data.get(i).getSoPhong());

            TextView txtTongTien=v.findViewById(R.id.TongTien);
            txtTongTien.setText(String.valueOf(data.get(i).getDonGia()*data.get(i).getSoNgayLuuTru()));
        }
        return v;
    }
}

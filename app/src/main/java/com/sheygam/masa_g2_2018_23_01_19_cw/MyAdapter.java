package com.sheygam.masa_g2_2018_23_01_19_cw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<String> list;
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("Name " + i);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.my_row,parent,false);
        }
        String str = list.get(position);
        TextView titleTxt = convertView.findViewById(R.id.title_txt);
        titleTxt.setText(str);
        return convertView;
    }

    public void add(String name) {
        list.add(2,name);
        notifyDataSetChanged();
    }
}

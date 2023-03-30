package com.example.myfirstapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.myfirstapp.R;

public class CountrySpinnerAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spinner_row, null);
        AppCompatImageView imgCountryIcon = convertView.findViewById(R.id.img_country_icon);
        AppCompatTextView tvCountryName = convertView.findViewById(R.id.tv_country_name);
        return convertView;
    }
}

package com.example.myfirstapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.myfirstapp.CountryModel;
import com.example.myfirstapp.R;

import java.util.List;

public class CountrySpinnerAdapter extends BaseAdapter {

    private final List<CountryModel> countryList;

    public CountrySpinnerAdapter(List<CountryModel> countryList){
        this.countryList = countryList;
    }

    @Override
    public int getCount() {
        return !this.countryList.isEmpty() ? this.countryList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return this.countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    // method for spinner selection
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spinner_row, null);
        AppCompatImageView imgCountryIcon = convertView.findViewById(R.id.img_country_icon);
        AppCompatTextView tvCountryName = convertView.findViewById(R.id.tv_country_name);
        CountryModel model = this.countryList.get(position);
        imgCountryIcon.setImageResource(model.getCountryImage());
        tvCountryName.setText(model.getCountryName());

        return convertView;
    }

    // method for spinner drop down item
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spinner_dropdown_row, null);
        AppCompatImageView imgCountryIcon = convertView.findViewById(R.id.img_country_icon);
        AppCompatTextView tvCountryName = convertView.findViewById(R.id.tv_country_name);
        CountryModel model = this.countryList.get(position);
        imgCountryIcon.setImageResource(model.getCountryImage());
        tvCountryName.setText(model.getCountryName());

        return convertView;
    }
}

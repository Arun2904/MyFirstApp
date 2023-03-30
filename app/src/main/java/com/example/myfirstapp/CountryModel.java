package com.example.myfirstapp;

import androidx.annotation.IntegerRes;

public class CountryModel {

    private @IntegerRes int countryImage;
    private String countryName;

    public CountryModel(@IntegerRes int countryImage, String countryName){
        this.countryImage = countryImage;
        this.countryName = countryName;
    }

    public int getCountryImage() {
        return countryImage;
    }

    public String getCountryName() {
        return countryName;
    }
}

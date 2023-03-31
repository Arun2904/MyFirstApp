package com.example.myfirstapp;

import androidx.annotation.DrawableRes;

public class CountryModel {

    private @DrawableRes int countryFlagImage;
    private String countryName;

    public CountryModel(@DrawableRes int countryFlagImage, String countryName){
        this.countryFlagImage = countryFlagImage;
        this.countryName = countryName;
    }

    public int getCountryImage() {
        return countryFlagImage;
    }

    public String getCountryName() {
        return countryName;
    }
}

package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.myfirstapp.adapter.CountrySpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ActivityTwo extends AppCompatActivity {

    public final static String KEY_GENDER_DATA = "gender_data";
    private AppCompatTextView tvSelectedGender;
    private AppCompatSpinner countrySpinner;

    public static void navigateToActivityTwo(String selectedGender, Context context) {
        Intent intent = new Intent(context, ActivityTwo.class);
        intent.putExtra(ActivityTwo.KEY_GENDER_DATA, selectedGender);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        tvSelectedGender = findViewById(R.id.tv_gender);
        countrySpinner = findViewById(R.id.sp_custom);

        if(getIntent() != null && getIntent().hasExtra(KEY_GENDER_DATA)){
            String gender = getIntent().getStringExtra(KEY_GENDER_DATA);
            tvSelectedGender.setText(gender);
        }

        List<CountryModel> list = createCountryList();
        CountrySpinnerAdapter countrySpinnerAdapter = new CountrySpinnerAdapter(list);
        countrySpinner.setAdapter(countrySpinnerAdapter);
    }

    private ArrayList<CountryModel> createCountryList() {
        ArrayList<CountryModel> list = new ArrayList();
        list.add(new CountryModel(R.drawable.india, "India"));
        list.add(new CountryModel(R.drawable.pakistan, "Pakistan"));
        list.add(new CountryModel(R.drawable.nepal, "Nepal"));
        list.add(new CountryModel(R.drawable.myanmar, "Myanmar (Burma)"));
        list.add(new CountryModel(R.drawable.bhutan, "Bhutan"));
        list.add(new CountryModel(R.drawable.srilanka, "Srilanka"));
        return list;
    }
}
package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int rotationCount = 0;
    TextView rotateCount;
    private String KEY_DATA = "data";
    private AppCompatSpinner genderSpinner;
    private MaterialButton submitButton, submitImplicitButton;
    private int selectedGenderPosition = 0;
    private String selectedGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rotateCount = (TextView) findViewById(R.id.tv_rotation_count);
        Toast.makeText(this, "Callback : onCreate", Toast.LENGTH_LONG).show();

        initSpinner();
    }

    private void initSpinner() {
        genderSpinner = findViewById(R.id.sp_gender);
        submitButton = findViewById(R.id.btn_submit);
        submitImplicitButton = findViewById(R.id.btn_submit_implicit);

        ArrayList<String> genderList = new ArrayList<>();
        genderList.add("Choose Gender");
        genderList.add("Male");
        genderList.add("Female");
        genderList.add("Transgender");
        genderList.add("Bisexual");
        genderList.add("Others");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genderList){
            @Override
            public boolean isEnabled(int position) {
                return position > 0;
            }
        };
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedGenderPosition = position;

                selectedGender = (String) parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        genderSpinner.setAdapter(dataAdapter);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedGenderPosition > 0){
                    Toast.makeText(MainActivity.this, "Selected gender is " + genderList.get(selectedGenderPosition), Toast.LENGTH_LONG).show();
                    ActivityTwo.navigateToActivityTwo(genderList.get(selectedGenderPosition), MainActivity.this);
                }else
                    Toast.makeText(MainActivity.this, "Please choose appropriate gender", Toast.LENGTH_LONG).show();
                 //  Toast.makeText(MainActivity.this, selectedGender, Toast.LENGTH_LONG).show();

            }
        });


        submitImplicitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.tutlane.com"));
                startActivity(intent);
            }
        });
    }
}
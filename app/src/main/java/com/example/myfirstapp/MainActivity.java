package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

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
    private MaterialButton submitButton;
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
             /*   if(selectedGenderPosition > 0){
                    Toast.makeText(MainActivity.this, "Selected gender is " + genderList.get(selectedGenderPosition), Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(MainActivity.this, "Please choose appropriate gender", Toast.LENGTH_LONG).show();
            */
                   Toast.makeText(MainActivity.this, selectedGender, Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        rotationCount = savedInstanceState.getInt(KEY_DATA);
        Toast.makeText(this, "Callback : onRestoreInstanceState", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Callback : onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        rotateCount.setText(String.valueOf(rotationCount));
        Toast.makeText(this, "Callback : onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Callback : onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Callback : onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Callback : onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        rotationCount = rotationCount + 1;
        outState.putInt(KEY_DATA, rotationCount);
        super.onSaveInstanceState(outState);
        Toast.makeText(this, "Callback : onSaveInstanceState", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Callback : onDestroy", Toast.LENGTH_SHORT).show();
    }
}
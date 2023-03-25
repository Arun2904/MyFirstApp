package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int rotationCount = 0;
    TextView rotateCount;
    private String KEY_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rotateCount = (TextView) findViewById(R.id.tv_rotation_count);
        Toast.makeText(this, "Callback : onCreate", Toast.LENGTH_LONG).show();
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
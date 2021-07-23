package com.semenov.pharmacy_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonPreparationList(View view) {
        Intent intent = new Intent(this, PreparationListActivity.class);
        startActivity(intent);
    }

    public void buttonPreparationAdd(View view) {
        Intent intent = new Intent(this, PreparationAddActivity.class);
        startActivity(intent);
    }


}
package com.semenov.pharmacy_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.semenov.pharmacy_app.clientsActivity.ClientAddActivity;
import com.semenov.pharmacy_app.clientsActivity.ClientsListActivity;
import com.semenov.pharmacy_app.preparationActivity.PreparationAddActivity;
import com.semenov.pharmacy_app.preparationActivity.PreparationListActivity;

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

    public void buttonClientsList(View view) {
        Intent intent = new Intent(this, ClientsListActivity.class);
        startActivity(intent);
    }

    public void buttonClientAdd(View view) {
        Intent intent = new Intent(this, ClientAddActivity.class);
        startActivity(intent);
    }
}
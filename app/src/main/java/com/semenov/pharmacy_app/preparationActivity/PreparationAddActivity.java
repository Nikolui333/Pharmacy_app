package com.semenov.pharmacy_app.preparationActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.semenov.pharmacy_app.R;
import com.semenov.pharmacy_app.database.PreparationDBHelper;

public class PreparationAddActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd;
    EditText etName, etTextPreparation;
    PreparationDBHelper preparationDBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparation_add);

        btnAdd = (Button) findViewById(R.id.buttonSavePreparation);
        btnAdd.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.editTextPreparation2);
        etTextPreparation = (EditText) findViewById(R.id.editTextPreparation1);

        preparationDBHelper = new PreparationDBHelper(this);
    }

    @Override
    public void onClick(View v) {

        String name = etName.getText().toString();
        String text = etTextPreparation.getText().toString();

        SQLiteDatabase database = preparationDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch (v.getId()) {

            case R.id.buttonSavePreparation:
                contentValues.put(preparationDBHelper.KEY_NAME, name);
                contentValues.put(preparationDBHelper.KEY_TEXT, text);

                database.insert(preparationDBHelper.TABLE_TEXT, null, contentValues);
                break;
        }
        preparationDBHelper.close();
    }
}
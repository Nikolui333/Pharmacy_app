package com.semenov.pharmacy_app.clientsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.semenov.pharmacy_app.R;
import com.semenov.pharmacy_app.database.ClientDBHelper;
import com.semenov.pharmacy_app.database.PreparationDBHelper;

public class ClientAddActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd;
    EditText etName, etPhoneNumber, etEmail;
    ClientDBHelper clientDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_add);

        btnAdd = (Button) findViewById(R.id.buttonSaveClients);
        btnAdd.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.editName);
        etPhoneNumber = (EditText) findViewById(R.id.editPhoneNumber);
        etEmail = (EditText) findViewById(R.id.editEmail);

        clientDBHelper = new ClientDBHelper(this);
    }

    @Override
    public void onClick(View v) {

        String name = etName.getText().toString();
        String phoneNumber = etPhoneNumber.getText().toString();
        String email = etEmail.getText().toString();

        SQLiteDatabase database = clientDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch (v.getId()) {

            case R.id.buttonSaveClients:
                contentValues.put(clientDBHelper.KEY_NAME, name);
                contentValues.put(clientDBHelper.KEY_PHONE_NUMBER, phoneNumber);
                contentValues.put(clientDBHelper.KEY_EMAIL, email);
                Log.d("data", name);
                Log.d("data", phoneNumber);
                Log.d("data", email);

                database.insert(clientDBHelper.TABLE_TEXT, null, contentValues);
                break;
        }
        clientDBHelper.close();
    }

}
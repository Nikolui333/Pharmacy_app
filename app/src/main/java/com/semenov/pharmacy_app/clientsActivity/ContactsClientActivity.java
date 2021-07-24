package com.semenov.pharmacy_app.clientsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.semenov.pharmacy_app.R;

public class ContactsClientActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_client);

        textView = (TextView) findViewById(R.id.nameClient);
        textView2 = (TextView) findViewById(R.id.phone);
        textView3 = (TextView) findViewById(R.id.email);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");

        textView.setText(name);
        textView2.setText(phone);
        textView3.setText(email);
    }
}
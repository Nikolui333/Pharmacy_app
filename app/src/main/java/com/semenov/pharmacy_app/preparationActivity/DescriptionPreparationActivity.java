package com.semenov.pharmacy_app.preparationActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.semenov.pharmacy_app.R;

public class DescriptionPreparationActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_preparation);

        textView = (TextView) findViewById(R.id.name);
        textView2 = (TextView) findViewById(R.id.UpText);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String text = intent.getStringExtra("text");

        textView.setText(name);
        textView2.setText(text);

        textView2.setMovementMethod(new ScrollingMovementMethod());
    }
}
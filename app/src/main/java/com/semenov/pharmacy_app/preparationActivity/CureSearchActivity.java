package com.semenov.pharmacy_app.preparationActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.semenov.pharmacy_app.R;
import com.semenov.pharmacy_app.TextPreparation;
import com.semenov.pharmacy_app.adapters.PreparationAdapter;
import com.semenov.pharmacy_app.database.PreparationDBHelper;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class CureSearchActivity extends AppCompatActivity implements View.OnClickListener {

    EditText userFilter;
    Button buttonSearch;
    RecyclerView recyclerView;
    PreparationDBHelper preparationDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cure_search);

        userFilter = (EditText)findViewById(R.id.userFilter);

        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.rvCureSearch);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        preparationDBHelper = new PreparationDBHelper(this);

    }


    @Override
    public void onClick(View view) {

        String name = userFilter.getText().toString();

        switch (view.getId()){

        case R.id.buttonSearch:
        ArrayList<TextPreparation> textPreparations = new ArrayList<>();
        textPreparations.add(preparationDBHelper.getContact(name));

        PreparationAdapter preparationAdapter = new PreparationAdapter(textPreparations, this);
      //  MainAdapter mainAdapter = new MainAdapter(contacts);
        recyclerView.setAdapter(preparationAdapter);
        Log.d("mLog","onClick_2");
        break;
    }

    }
}
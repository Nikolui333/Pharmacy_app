package com.semenov.pharmacy_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PreparationListActivity extends AppCompatActivity implements Serializable {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private PreparationDBHelper mDataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparation_list);

        recyclerView = (RecyclerView) findViewById(R.id.rvPreparation); //находим список

        layoutManager = new LinearLayoutManager(this);  //задаёт способ распределения элементов списка (в данном случае горизонтально сверху вниз)
        recyclerView.setLayoutManager(layoutManager);

        mDataBaseHelper = new PreparationDBHelper(this);

        if(this.mDataBaseHelper == null){
            this.mDataBaseHelper = new PreparationDBHelper(this);
        }

        SQLiteDatabase db = mDataBaseHelper.getReadableDatabase();//чтение базы данных
        String sql = "select name, text from textTable";//получение доступа к данным в таблице
        Cursor c = db.rawQuery(sql, new String[]{});//извлечение данных из таблицы
        List<TextPreparation> myDataset = new ArrayList<>();
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    int idName= c.getColumnIndex("name");
                    int idText= c.getColumnIndex("text");
                    myDataset.add(new TextPreparation(c.getString(idName),c.getString(idText)));
                } while (c.moveToNext());
            }
            c.close();
        }

        try {
            mAdapter = new PreparationAdapter(myDataset, this);
            recyclerView.setAdapter(mAdapter);
        }catch (Exception ex){

        }
    }
}
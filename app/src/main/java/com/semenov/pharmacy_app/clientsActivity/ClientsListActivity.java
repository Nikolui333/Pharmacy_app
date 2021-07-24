package com.semenov.pharmacy_app.clientsActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.semenov.pharmacy_app.R;
import com.semenov.pharmacy_app.TextClients;
import com.semenov.pharmacy_app.adapters.ClientAdapter;
import com.semenov.pharmacy_app.adapters.PreparationAdapter;
import com.semenov.pharmacy_app.database.ClientDBHelper;
import com.semenov.pharmacy_app.database.PreparationDBHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClientsListActivity extends AppCompatActivity implements Serializable {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ClientDBHelper mDataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_list);

        recyclerView = (RecyclerView) findViewById(R.id.rvClients); //находим список

        layoutManager = new LinearLayoutManager(this);  //задаёт способ распределения элементов списка (в данном случае горизонтально сверху вниз)
        recyclerView.setLayoutManager(layoutManager);

        mDataBaseHelper = new ClientDBHelper(this);

        if(this.mDataBaseHelper == null){
            this.mDataBaseHelper = new ClientDBHelper(this);
        }

        SQLiteDatabase db = mDataBaseHelper.getReadableDatabase();//чтение базы данных
        String sql = "select name, phone, email from ClientTable";//получение доступа к данным в таблице
        Cursor c = db.rawQuery(sql, new String[]{});//извлечение данных из таблицы
        List<TextClients> myDataset = new ArrayList<>();
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    int idName= c.getColumnIndex("name");
                    int idPhone= c.getColumnIndex("phone");
                    int idEmail= c.getColumnIndex("email");

                    myDataset.add(new TextClients(c.getString(idName),c.getString(idPhone), c.getString(idEmail)));
                } while (c.moveToNext());
            }
            c.close();
        }

        try {
            mAdapter = new ClientAdapter(myDataset, this);
            recyclerView.setAdapter(mAdapter);
        }catch (Exception ex){
            Log.d("data","no data for recyclerview");
        }
    }
}
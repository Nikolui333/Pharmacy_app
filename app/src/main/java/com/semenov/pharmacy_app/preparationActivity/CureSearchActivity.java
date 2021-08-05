package com.semenov.pharmacy_app.preparationActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.semenov.pharmacy_app.R;
import com.semenov.pharmacy_app.database.PreparationDBHelper;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class CureSearchActivity extends AppCompatActivity {

    PreparationDBHelper sqlHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    ListView userList;
    EditText userFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cure_search);

        userList = (ListView)findViewById(R.id.userList);
        userFilter = (EditText)findViewById(R.id.userFilter);

        sqlHelper = new PreparationDBHelper(getApplicationContext());
        // создаем базу данных
       // sqlHelper.create_db();
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            db = sqlHelper.open();
           // db = sqlHelper.getReadableDatabase();//чтение базы данных
            userCursor = db.rawQuery("select * from " + PreparationDBHelper.TABLE_TEXT, null);
            String[] headers = new String[]{PreparationDBHelper.KEY_NAME/*, PreparationDBHelper.KEY_TEXT*/};
            userAdapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
                    userCursor, headers, new int[]{android.R.id.text1/*, android.R.id.text2*/}, 0);

            // если в текстовом поле есть текст, выполняем фильтрацию
            // данная проверка нужна при переходе от одной ориентации экрана к другой
            if(!userFilter.getText().toString().isEmpty())
                userAdapter.getFilter().filter(userFilter.getText().toString());

            // установка слушателя изменения текста
            userFilter.addTextChangedListener(new TextWatcher() {

                public void afterTextChanged(Editable s) { }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                // при изменении текста выполняем фильтрацию
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    userAdapter.getFilter().filter(s.toString());
                }
            });

            // устанавливаем провайдер фильтрации
            userAdapter.setFilterQueryProvider(new FilterQueryProvider() {
                @Override
                public Cursor runQuery(CharSequence constraint) {

                    if (constraint == null || constraint.length() == 0) {

                        return db.rawQuery("select * from " + PreparationDBHelper.TABLE_TEXT, null);
                    }
                    else {
                        return db.rawQuery("select * from " + PreparationDBHelper.TABLE_TEXT + " where " +
                                PreparationDBHelper.DATABASE_NAME + " like ?", new String[]{"%" + constraint.toString() + "%"});
                    }
                }
            });

            userList.setAdapter(userAdapter);
        }
        catch (SQLException ex){}
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }
}
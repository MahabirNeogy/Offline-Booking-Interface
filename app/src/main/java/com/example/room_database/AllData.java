package com.example.room_database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AllData extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> title,amount;
    MyAdapter adapter;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_data);
        title = new ArrayList<>();
        amount = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
//        adapter = new MyAdapter(this,title,amount);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DisplayData();
    }

    private void DisplayData() {

        DatabaseHelper db = DatabaseHelper.getDB(this);
        ExpenseDAO expenseDAO = db.expenseDAO();
        List<Expense> expenses =expenseDAO.getAllExpense();
        MyAdapter adapter=new MyAdapter(expenses);
        recyclerView.setAdapter(adapter);

//        Cursor cursor= db.getdata();
//        if(cursor.getCount()==0){
//            Toast.makeText(AllData.this,"no data exists",Toast.LENGTH_SHORT).show();
//            return;
//        }
//        else{
//            while (cursor.moveToNext()){
//                title.add(cursor.getString(0));
//                amount.add((cursor.getString(1)));
//            }
//        }
    }
}
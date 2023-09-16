package com.example.room_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText, editAmount;
    Button btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText= findViewById(R.id.edttxt1);
        editAmount= findViewById(R.id.edttxt2);
        btn= findViewById(R.id.btnsave);
        btn2=findViewById(R.id.btnshow);

        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=editText.getText().toString();
                String amount = editAmount.getText().toString();
                databaseHelper.expenseDAO().addTx(
                        new Expense(title,amount)
                );
                ArrayList<Expense> arrExpense = (ArrayList<Expense>)
                databaseHelper.expenseDAO().getAllExpense();

                for (int i=0;i<arrExpense.size();i++){
                    Log.d("Data","Title: "+arrExpense.get(i).getTitle() + "Amount: "+arrExpense.get(i).getAmount());
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AllData.class));
            }
        });


    }
}
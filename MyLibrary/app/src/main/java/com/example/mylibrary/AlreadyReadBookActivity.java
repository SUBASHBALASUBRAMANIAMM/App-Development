package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class AlreadyReadBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_book);
        RecyclerView AlreadyReadBookRecyclerView = findViewById(R.id.AlreadyReadBookRecyclerView);
        BookRecViewAdapter adapter = new BookRecViewAdapter(this,"alreadyRead");
        AlreadyReadBookRecyclerView.setAdapter(adapter);
        AlreadyReadBookRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getAlreadyReadBooks());
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
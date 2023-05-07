package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class CurrentlyReadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading);
        RecyclerView currentlyReadingRecyclerView = findViewById(R.id.currentlyReadingRecyclerView);
        BookRecViewAdapter adapter = new BookRecViewAdapter(this,"currentlyRead");
        currentlyReadingRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getCurrentlyReadingBooks());
        currentlyReadingRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
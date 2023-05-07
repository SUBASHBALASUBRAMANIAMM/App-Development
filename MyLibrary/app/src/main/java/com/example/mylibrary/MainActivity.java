package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnSeeAllBooks,btnCurrentlyReadingBooks,btnAlreadyreadBooks,btnYourWishlist,btnSeeYourFavourites,btnAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiViews();
        btnSeeAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });
        btnAlreadyreadBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });
        btnCurrentlyReadingBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });
        Utils.getInstance();

    }
    private void intiViews(){
        btnSeeAllBooks = findViewById(R.id.btnSeeAllBooks);
        btnCurrentlyReadingBooks = findViewById(R.id.btnCurrentlyReadingBooks);
        btnAlreadyreadBooks = findViewById(R.id.btnAlreadyreadBooks);
        btnYourWishlist = findViewById(R.id.btnYourWishlist);
        btnAbout = findViewById(R.id.btnAbout);
    }
}
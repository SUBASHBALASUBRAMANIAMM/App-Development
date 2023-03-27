package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout parent;
    private Button btnshowSnackBar;
    private MaterialCardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parent = findViewById(R.id.parent);
        btnshowSnackBar = findViewById(R.id.snackbar);
        btnshowSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 showSnackBar();
            }
        });
        cardView = findViewById(R.id.cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Cardview selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showSnackBar(){
        Snackbar.make(parent,"this is a snackbar", Snackbar.LENGTH_INDEFINITE).setAction("Retry", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Retry clicked", Toast.LENGTH_SHORT).show();
            }
        }).setActionTextColor(getColor(R.color.teal_700)).setTextColor(Color.YELLOW).show();


    }
}
 package com.example.fonts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {
        private TextView helText;
        private Button  changebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helText = findViewById(R.id.helText);
        changebtn = findViewById(R.id.changebtn);
        final Typeface typeface = ResourcesCompat.getFont(this,R.font.anonymous_pro);
        changebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   helText.setTypeface(typeface);
            }
        });
    }
}
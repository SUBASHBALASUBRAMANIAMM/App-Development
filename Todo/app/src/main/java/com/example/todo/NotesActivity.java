package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class NotesActivity extends AppCompatActivity {
        ImageView iconBack;
        EditText editTxtTitle,editTxtDescription;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NotesActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        iconBack = findViewById(R.id.iconBack);
        editTxtDescription = findViewById(R.id.editTxtDescription);
        editTxtTitle = findViewById(R.id.editTxtTitle);
        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Intent intent =getIntent();
        Bundle extras = intent.getExtras();
        if(extras.getInt("Activity")==1){
            String Title = extras.getString("TITLE");
            String Description = extras.getString("DESCRIPTION");
            editTxtDescription.setText(Description);
            editTxtTitle.setText(Title);
        }
        if(extras.getInt("Activity")==2){
            String Title1 = extras.getString("Title");
            String desc = extras.getString("DESC");
            editTxtTitle.setText(Title1);
            editTxtDescription.setText(desc);
        }







    }
}
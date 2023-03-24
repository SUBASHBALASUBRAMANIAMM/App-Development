package com.example.uibasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private EditText editText;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.helloButton:
                Toast.makeText(this, "hello button clicked", Toast.LENGTH_SHORT).show();
                textView.setText("Hello " + editText.getText().toString());
                break;
            default:
                break;
        }
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =  findViewById(R.id.helloButton);
        button.setOnClickListener(this);

        editText = findViewById(R.id.edttxtName);
        textView = findViewById(R.id.txtviewHello);

    }


}
package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText noteEdtTxt;
    private Spinner spinner;
    private ListView noteListView;
    ArrayList<String> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notes.add("note");
        noteListView = findViewById(R.id.noteListView);
        ArrayAdapter<String> notesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,notes);
        noteListView.setAdapter(notesAdapter);
        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, notes.get(i) + "selected", Toast.LENGTH_SHORT).show();
            }
        });
        spinner = findViewById(R.id.spinner);
//        ArrayList<String> spin = new ArrayList<>();
//        spin.add("select 1");
//        spin.add("select 2");
//        spin.add("select 3");
//        spin.add("select 4");
//        ArrayAdapter<String> spinAdap = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,spin);
//        spinner.setAdapter(spinAdap);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, spinner.getSelectedItem().toString() + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void submit(View view){
        noteEdtTxt = findViewById(R.id.noteEdtTxt);
        notes.add(noteEdtTxt.getText().toString());

    }
}
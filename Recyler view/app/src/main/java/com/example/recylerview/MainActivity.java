package com.example.recylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        private RecyclerView contactsRecView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactsRecView = findViewById(R.id.contactsRecView);
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("subash","subash,it20@bitsathy.ac.in","https://i.pinimg.com/originals/08/3a/68/083a68071698506a2e71a55a638514a0.jpg"));
        contacts.add(new Contact("loga","loga.it20@bitsathy.ac.in","https://i.pinimg.com/236x/a0/30/18/a03018325a896ff030b374b5fbfa4aac.jpg"));
        contacts.add(new Contact("raj","raj.it20@bitsathy.ac.in","https://i.pinimg.com/736x/54/26/a5/5426a51fe15b4bb1dca378b3f6963d30.jpg"));
        contacts.add(new Contact("tamil","tamil.it20@bitsathy.ac.in","https://i.pinimg.com/170x/0f/5d/7c/0f5d7c103bfb74ee882fbf387596848b.jpg"));
        contacts.add(new Contact("tamil","tamil.it20@bitsathy.ac.in","https://i.pinimg.com/170x/0f/5d/7c/0f5d7c103bfb74ee882fbf387596848b.jpg"));

        ContactRecViewAdapter adapter = new ContactRecViewAdapter(this);
        adapter.setContacts(contacts);
        contactsRecView.setAdapter(adapter);
        contactsRecView.setLayoutManager(new GridLayoutManager(this,2));


    }
}
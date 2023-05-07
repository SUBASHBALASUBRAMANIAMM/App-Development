package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.InputType;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
       private ExtendedFloatingActionButton extended_fab;
       private TextInputEditText sample;
       private RecyclerView recyclerNeedToComplete;
       private RecyclerViewAdapter adapter;
       private ImageView backgroundImage;

        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        extended_fab = findViewById(R.id.extended_fab);
        recyclerNeedToComplete = findViewById(R.id.recyclerNeedToComplete);
        backgroundImage = findViewById(R.id.backgroundImage);
        adapter = new RecyclerViewAdapter(this);

        extended_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    showDialog(adapter);
            }
        });
        Utils.getInstance();


        adapter.setall(Utils.getInstance().getNeedToCompleted());
        recyclerNeedToComplete.setAdapter(adapter);
        recyclerNeedToComplete.setLayoutManager(new LinearLayoutManager(this));
        if(Utils.getInstance().getNeedToCompleted().size()==0){
            backgroundImage.setVisibility(View.VISIBLE);

        }else{
            backgroundImage.setVisibility(View.INVISIBLE);

        }

    }
    private void showDialog(RecyclerViewAdapter adapter){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_layout);
        TextInputEditText inputEditTextTitle = dialog.findViewById(R.id.inputEditTextTitle);
        TextInputEditText inputEditTextDescription = dialog.findViewById(R.id.inputEditTextDescription);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        inputEditTextTitle.requestFocus();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                inputEditTextTitle.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 0f, 0f, 0));
                inputEditTextTitle.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, 0f, 0f, 0));
            }
        }, 100);

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        ImageView iconFullScreen = dialog.findViewById(R.id.iconFullScreen);
        iconFullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NotesActivity.class);
                Bundle extras = new Bundle();
                extras.putString("TITLE",inputEditTextTitle.getText().toString());
                extras.putString("DESCRIPTION",inputEditTextDescription.getText().toString());
                extras.putInt("Activity",1);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String title = inputEditTextTitle.getText().toString();
                    String desc = inputEditTextDescription.getText().toString();
                    task t = new task(title,false,desc);
                    if(!title.equals("")){
                        Utils.getInstance().setNeedToCompleted(t);
                        adapter.notifyDataSetChanged();
                        dialog.cancel();
                    }
                    isEmpty();

                }
            });




    }
    public void isEmpty(){
        if(adapter.getItemCount()==0){
            backgroundImage.setVisibility(View.VISIBLE);

        }else{
            backgroundImage.setVisibility(View.INVISIBLE);

        }

    }

}
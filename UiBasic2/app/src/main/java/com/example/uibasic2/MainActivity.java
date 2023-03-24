package com.example.uibasic2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkHarry,checkMatrix,checkMarvel;
    private RadioGroup gender;
    private ProgressBar progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkHarry = findViewById(R.id.CheckHarry);
        if(checkHarry.isChecked()){
            Toast.makeText(MainActivity.this, "you selected a harry", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(MainActivity.this, "you deselected a harry", Toast.LENGTH_SHORT).show();


        }
        checkHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "you selected a harry", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "you deselected a harrry", Toast.LENGTH_SHORT).show();
                }
            }
        });
        gender = findViewById(R.id.genderRadioGroup);
        progressbar = findViewById(R.id.progressBar);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    progressbar.incrementProgressBy(10);
                    SystemClock.sleep(500);

                }
            }
        });
        thread.start();

        int checkedRadio = gender.getCheckedRadioButtonId();
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.Maleradiobutton:
                        Toast.makeText(MainActivity.this,"male is selected" , Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Femaleradiobutton:
                        Toast.makeText(MainActivity.this, "Female is selected", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }


            }
        });

    }
}
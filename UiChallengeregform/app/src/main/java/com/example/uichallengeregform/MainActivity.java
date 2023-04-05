package com.example.uichallengeregform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText editName,editEmail,editPassword,editRePassword;
    private TextView namePopup,emailPopup,passwordPopup,rePasswordPopup;
    private Button btnPickImage,btnRegister;
    private Spinner countriesSpinner;
    private RadioGroup genderRadioGroup;
    private CheckBox AgreeCheckBox;
    private RelativeLayout parentLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        
        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Not Available right now!", Toast.LENGTH_SHORT).show();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRegister();
            }
        });
    }
    private void initRegister(){
        Log.d(TAG, "initRegister: started");
        if(validateData()){
            if(AgreeCheckBox.isChecked()){
                    showSnackBar();
            }else{
                Toast.makeText(this, "You need to agree the license", Toast.LENGTH_SHORT).show();
            }

        }
    }
    private void showSnackBar(){
        Log.d(TAG, "showSnackBar: started");
        namePopup.setVisibility(View.GONE);
        emailPopup.setVisibility(View.GONE);
        passwordPopup.setVisibility(View.GONE);
        rePasswordPopup.setVisibility(View.GONE);

        String name = editName.getText().toString();
        String email = editEmail.getText().toString();
        String country = countriesSpinner.getSelectedItem().toString();
        String gender = "";
        switch (genderRadioGroup.getCheckedRadioButtonId()){
            case R.id.rbMale:
                gender = "Male";
                break;
            case R.id.rbFemale:
                gender = "Female";
                break;
            case R.id.rbOther:
                gender = "Other";
                break;
            default:
                gender = "Unknown";
                break;
        }
        String snacktext = "Name :"+ name + "\n" +
                "Email :" + email + "\n" +
                "Gender :"+ gender + "\n"+
                "Country :" + country;
        Log.d(TAG, "showSnackBar: snack bar text"+ snacktext);
        Snackbar.make(parentLayout,snacktext,Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editName.setText("");
                        editPassword.setText("");
                        editEmail.setText("");
                        editRePassword.setText("");
                    }
                }).show();
    }
    private boolean validateData(){
        if(editName.getText().toString().equals("")){
            namePopup.setVisibility(View.VISIBLE);
            return false;
        }
        if(editPassword.getText().toString().equals("")){
            passwordPopup.setVisibility(View.VISIBLE);
            return false;
        }
        if(editEmail.getText().toString().equals("")){
            emailPopup.setVisibility(View.VISIBLE);
            return false;
        }
        if(editRePassword.getText().toString().equals("")){
            rePasswordPopup.setVisibility(View.VISIBLE);
            return false;
        }
        if(!editPassword.getText().toString().equals(editRePassword.getText().toString())){
            rePasswordPopup.setVisibility(View.VISIBLE);
            rePasswordPopup.setText("Password doesn't match");
            return false;
        }
        return true;
    }
    private void initviews(){
        Log.d(TAG, "initviews: started");
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editRePassword = findViewById(R.id.editRePassword);

        namePopup = findViewById(R.id.namePopup);
        emailPopup = findViewById(R.id.emailPopup);
        passwordPopup = findViewById(R.id.passwordPopup);
        rePasswordPopup = findViewById(R.id.rePasswordPopup);

        btnPickImage = findViewById(R.id.btnPickImage);
        btnRegister = findViewById(R.id.btnRegister);

        countriesSpinner = findViewById(R.id.countriesSpinner);
        genderRadioGroup =findViewById(R.id.genderRadioGroup);

        AgreeCheckBox = findViewById(R.id.AgreeCheckBox);
        parentLayout = findViewById(R.id.parentLayout);
    }
}
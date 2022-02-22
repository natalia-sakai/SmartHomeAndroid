package com.nataliasakai.smarthome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    ImageButton buttonBack;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        buttonBack = findViewById(R.id.btn_back);
        buttonSave = findViewById(R.id.btn_save);

        buttonBack.setOnClickListener(view -> switchToBack());
        buttonSave.setOnClickListener(view -> updateProfile());
    }

    public void switchToBack() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    public void updateProfile(){
        EditText newName = findViewById(R.id.edt_name);
        System.out.println(newName.getText().toString());
    }
}
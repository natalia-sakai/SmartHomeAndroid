package com.nataliasakai.smarthome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {
    Button buttonAdd;
    Button buttonAutomation;
    Button buttonProfile;
    Button buttonPower1;
    Button buttonPower2;
    Button buttonImage1;
    Button buttonImage2;
    Button buttonImage3;

    boolean[] b = new boolean[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Arrays.fill(b, true);

        buttonAdd = findViewById(R.id.btn_add);
        buttonAutomation = findViewById(R.id.btn_automation);
        buttonProfile = findViewById(R.id.btn_profile);
        buttonPower1 = findViewById(R.id.btn_power1);
        buttonPower2 = findViewById(R.id.btn_power2);
        buttonImage1 = findViewById(R.id.image1);
        buttonImage2 = findViewById(R.id.image2);
        buttonImage3 = findViewById(R.id.image3);

        buttonAdd.setOnClickListener(view -> switchToAdd());
        buttonAutomation.setOnClickListener(view -> switchToAutomation());
        buttonProfile.setOnClickListener(view -> switchToProfile());
        buttonPower1.setOnClickListener(view -> switchButton(buttonPower1,0, R.id.txt_status1, R.string.txt_status1));
        buttonPower2.setOnClickListener(view -> switchButton(buttonPower2,1, R.id.txt_status2, R.string.txt_status2));
        buttonImage1.setOnClickListener(view -> switchButton(buttonImage1,2, 0, 0));
        buttonImage2.setOnClickListener(view -> switchButton(buttonImage2,3, 0, 0));
        buttonImage3.setOnClickListener(view -> switchButton(buttonImage3,4, 0, 0));

    }

    public void switchToAdd() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void switchToAutomation() {
        Intent intent = new Intent(getApplicationContext(), RoomActivity.class);
        startActivity(intent);
    }

    public void switchToProfile() {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
    }

    public void switchButton(Button button, int index, int id, int texto) {

        if(b[index])
            button.setBackgroundTintList(this.getResources().getColorStateList(R.color.grey));
        else
            button.setBackgroundTintList(this.getResources().getColorStateList(R.color.pink_sweetie));

        if(id != 0){
            TextView text = findViewById(id);
            if (b[index])
                text.setText(" ");
            else
                text.setText(texto);
        }

        b[index] = !b[index];
    }
}
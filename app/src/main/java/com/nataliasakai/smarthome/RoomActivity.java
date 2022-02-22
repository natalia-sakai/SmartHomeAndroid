package com.nataliasakai.smarthome;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class RoomActivity extends AppCompatActivity {
    ImageButton buttonBack;
    ImageButton buttonEditDevice1;
    AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        buttonBack = findViewById(R.id.btn_back);
        buttonEditDevice1 = findViewById(R.id.btn_editDevice1);
        buttonBack.setOnClickListener(view -> switchToBack());
        buttonEditDevice1.setOnClickListener(view -> handleDevice1());
    }

    public void switchToBack() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    public void handleDevice1() {
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("Delete Room");
        builder.setMessage("Are you sure that you want to delete this Room?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                CardView card = findViewById(R.id.card1);
                card.setVisibility(View.GONE);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });
        alerta = builder.create();
        alerta.show();
    }
}
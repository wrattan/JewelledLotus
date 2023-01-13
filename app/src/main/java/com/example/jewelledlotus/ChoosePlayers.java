package com.example.jewelledlotus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoosePlayers extends AppCompatActivity {
    Button FourPlayers;
    Button ThreePlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_players);

        FourPlayers = findViewById(R.id.FourPlayersSelected);
        ThreePlayers = findViewById(R.id.ThreePlayersSelected);

        FourPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoosePlayers.this, MainGameFourPlayers.class);
                startActivity(intent);
                finish();
            }
        });

        ThreePlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoosePlayers.this, MainGameThreePlayers3.class);
                startActivity(intent);
                finish();
            }
        });



    }




}
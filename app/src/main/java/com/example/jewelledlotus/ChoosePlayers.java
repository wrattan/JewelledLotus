package com.example.jewelledlotus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoosePlayers extends AppCompatActivity {
    Button FourPlayers;
    Button ThreePlayers;
    Button FivePlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_players);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);


        FivePlayers = findViewById(R.id.FivePlayersSelected);
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

        FivePlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoosePlayers.this, MainGameFivePlayers.class);
                startActivity(intent);
                finish();
            }
        });


    }




}
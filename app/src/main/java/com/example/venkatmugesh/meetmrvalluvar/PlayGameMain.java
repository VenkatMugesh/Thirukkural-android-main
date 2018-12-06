package com.example.venkatmugesh.meetmrvalluvar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayGameMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game_main);
        Button startgame = (Button)findViewById(R.id.startGame);
        Button practiceKurals = (Button)findViewById(R.id.practiceKurals);
        Button howWorks = (Button) findViewById(R.id.howItWorks);

        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayGameMain.this , PlayGame.class);
                startActivity(intent);
            }
        });
        practiceKurals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlayGameMain.this , PracticeKurals.class);
                startActivity(i);
            }
        });
    }
}

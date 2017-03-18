package com.example.fredrick_tam.animonbattle;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BattleResult extends AppCompatActivity {
    private MediaPlayer track;
    int win = R.raw.tada;
    int loss = R.raw.loss;
    int draw = R.raw.tie;


    private class MyClick implements View.OnClickListener {
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.play_again:
                    Intent intent = new Intent(BattleResult.this,PickFighter.class);
                    startActivity(intent);
                    break;
                case R.id.home:
                    Intent intent2 = new Intent(BattleResult.this,WelcomeScreen.class);
                    startActivity(intent2);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_result);
        String result = getIntent().getExtras().getString("result");
        ImageView battleView = (ImageView)findViewById(R.id.battle_outcome);
        if (result.equals("win")) {
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.drawable.youwin);
            battleView.setImageResource(R.drawable.dragonite);
            track = MediaPlayer.create(this,win);
            track.start();

        } else if (result.equals("loss")) {
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.drawable.youlose);
            track = MediaPlayer.create(this,loss);
            battleView.setImageResource(R.drawable.lost);
            track.start();

        } else if (result.equals("tie")){
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.drawable.draw);
            battleView.setImageResource(R.drawable.tie);
            track = MediaPlayer.create(this,draw);
            track.start();
        }




        Button play, home;

        play = (Button) findViewById(R.id.play_again);
        home = (Button) findViewById(R.id.home);

        BattleResult.MyClick myClickListener = new BattleResult.MyClick();

        play.setOnClickListener(myClickListener);
        home.setOnClickListener(myClickListener);


    }
}


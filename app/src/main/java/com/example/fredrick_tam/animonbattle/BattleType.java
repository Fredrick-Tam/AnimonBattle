package com.example.fredrick_tam.animonbattle;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BattleType extends AppCompatActivity {
    private MediaPlayer track;

    // effect source
    int song = R.raw.pikachu_echo;

    // MyCLick class that is executed when buttons are clicked
    private class MyClick implements View.OnClickListener {
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.RandoBattle:
                    Intent intent = new Intent(BattleType.this,PickFighter.class);
                    startActivity(intent);
                    track.start();
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_type);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.battletype);
        track = MediaPlayer.create(this,song);

        // creates random battle button and links it to MyClick class
        Button random;

        random = (Button) findViewById(R.id.RandoBattle);

        BattleType.MyClick myClickListener = new BattleType.MyClick();

        random.setOnClickListener(myClickListener);

    }
}

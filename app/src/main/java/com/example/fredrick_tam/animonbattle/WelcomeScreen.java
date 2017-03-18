package com.example.fredrick_tam.animonbattle;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {

    private MediaPlayer opening;
    int song = R.raw.opening;
    private MediaPlayer about;
    int effect = R.raw.pikachu;

    private class MyClick implements View.OnClickListener {
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button:
                    Intent intent = new Intent(WelcomeScreen.this,BattleType.class);
                    startActivity(intent);
                    opening.pause();
                    break;
                case R.id.button2:
                    opening.stop();
                    about.start();
                    Intent intent2 = new Intent(WelcomeScreen.this,About.class);
                    startActivity(intent2);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.animonlogo);

        opening = MediaPlayer.create(this,song);
        about = MediaPlayer.create(this,effect);

        if (!opening.isPlaying()){
            opening.start();
        } else {
            opening.start();
        }
        
        Button play, about;

        play = (Button) findViewById(R.id.button);
        about = (Button) findViewById(R.id.button2);

        MyClick myClickListener = new WelcomeScreen.MyClick();

        play.setOnClickListener(myClickListener);
        about.setOnClickListener(myClickListener);
    }


}

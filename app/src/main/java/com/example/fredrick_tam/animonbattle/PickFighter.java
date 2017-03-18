package com.example.fredrick_tam.animonbattle;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.fredrick_tam.animonbattle.R.id.Elephant;
import static com.example.fredrick_tam.animonbattle.R.string.cat;
import static com.example.fredrick_tam.animonbattle.R.string.elephant;
import static com.example.fredrick_tam.animonbattle.R.string.lizard;
import static com.example.fredrick_tam.animonbattle.R.string.mouse;
import static com.example.fredrick_tam.animonbattle.R.string.turtle;

public class PickFighter extends AppCompatActivity {
    // initializing important private variables
    private MediaPlayer battle;
    int tune = R.raw.battlesong;
    private int count  = 0;
    private int cpuWins = 0;
    private int userWins = 0;

    // implementation of OnCLickListener as MyCLick
    private class MyClick implements View.OnClickListener {
        public void onClick(View v) {
            TextView fighter = (TextView) findViewById(R.id.characname);
            TextView rounds = (TextView) findViewById(R.id.Round);
            TextView cpu = (TextView) findViewById(R.id.computer);
            TextView player = (TextView) findViewById(R.id.user);
            // depending on image button chosen, populate textview descritpion
            switch(v.getId()){
                case R.id.Turtle:
                    fighter.setText(getResources().getString(turtle));
                    break;
                case Elephant:
                    fighter.setText(getResources().getString(elephant));
                    break;
                case R.id.Mouse:
                    fighter.setText(getResources().getString(mouse));
                    break;
                case R.id.Lizard:
                    fighter.setText(getResources().getString(lizard));
                    break;
                case R.id.Cat:
                    fighter.setText(getResources().getString(cat));
                    break;
                case R.id.Ball:
                    // whenever pokeball is clicked, reset round and score data
                    fighter.setText("");
                    count = 0;
                    userWins = 0;
                    cpuWins = 0;
                    rounds.setText("Round");
                    cpu.setText("Computer " + Integer.toString(cpuWins));
                    player.setText("Player " + Integer.toString(userWins));
                    break;
                case R.id.Fight:
                    if (fighter.getText().equals("")){
                        fighter.setText("\n *Choose a character first");
                    }
            }
        }
    }

    // fight button actions
    private class FightClick implements View.OnClickListener {
        TextView fighters = (TextView) findViewById(R.id.characname);
        TextView rounds = (TextView) findViewById(R.id.Round);
        ImageButton cpuAnimon = (ImageButton) findViewById(R.id.cpuselection);
        TextView cpuselection = (TextView) findViewById(R.id.cpuCharacter);

        @Override
        public void onClick(View v) {
            // count is the round, increment with each time fight button is pressed
            ++count;
            TextView cpu = (TextView) findViewById(R.id.computer);
            TextView player = (TextView) findViewById(R.id.user);

            rounds.setText("Round "+ count);

            // randomly pick one of the 5 characters
            int rand = (int) (Math.random() * 5 + 1);

             /*
            selection is based on the following criterion:
            1 is mouse
            2 is turtle
            3 is cat
            4 is elephant
            5 is lizard
            */

            switch (rand) {
                case 1:
                    cpuAnimon.setImageResource(R.drawable.raichu);
                    cpuselection.setText(getResources().getString(mouse));
                    switch ((String) fighters.getText()) {
                        case "Persian Cat":
                            userWins++;
                            break;
                        case "Raichu Mouse":
                            userWins++;
                            cpuWins++;
                            break;
                        case "Phanpy Elephant":
                            cpuWins++;
                            break;
                        case "Squirtle Turtle":
                            cpuWins++;
                            break;
                        case "Charmander Lizard":
                            userWins++;
                            break;
                    }
                    break;
                case 2:
                    cpuAnimon.setImageResource(R.drawable.squirtle);
                    cpuselection.setText(getResources().getString(turtle));
                    switch ((String) fighters.getText()) {
                        case "Persian Cat":
                            cpuWins++;
                            break;
                        case "Raichu Mouse":
                            userWins++;
                            break;
                        case "Phanpy Elephant":
                            cpuWins++;
                            break;
                        case "Squirtle Turtle":
                            cpuWins++;
                            userWins++;
                            break;
                        case "Charmander Lizard":
                            userWins++;
                            break;
                    }
                    break;
                case 3:
                    cpuAnimon.setImageResource(R.drawable.cat);
                    cpuselection.setText(getResources().getString(cat));
                    switch ((String) fighters.getText()) {
                        case "Persian Cat":
                            userWins++;
                            cpuWins++;
                            break;
                        case "Raichu Mouse":
                            cpuWins++;
                            break;
                        case "Phanpy Elephant":
                            userWins++;
                            break;
                        case "Squirtle Turtle":
                            userWins++;
                            break;
                        case "Charmander Lizard":
                            cpuWins++;
                            break;
                    }
                    break;
                case 4:
                    cpuAnimon.setImageResource(R.drawable.phant);
                    cpuselection.setText(getResources().getString(elephant));
                    switch ((String) fighters.getText()) {
                        case "Persian Cat":
                            cpuWins++;
                            break;
                        case "Raichu Mouse":
                            userWins++;
                            break;
                        case "Phanpy Elephant":
                            cpuWins++;
                            userWins++;
                            break;
                        case "Squirtle Turtle":
                            userWins++;
                            break;
                        case "Charmander Lizard":
                            cpuWins++;
                            break;
                        }
                    break;
               case 5:
                   cpuAnimon.setImageResource(R.drawable.charmander);
                   cpuselection.setText(getResources().getString(lizard));
                   switch ((String) fighters.getText()) {
                       case "Persian Cat":
                           userWins++;
                           break;
                       case "Raichu Mouse":
                           cpuWins++;
                           break;
                       case "Phanpy Elephant":
                           userWins++;
                           break;
                       case "Squirtle Turtle":
                           cpuWins++;
                           break;
                       case "Charmander Lizard":
                           userWins++;
                           cpuWins++;
                           break;
                   }
            }

            // display user and computer scores
            cpu.setText("Computer: " + Integer.toString(cpuWins));
            player.setText("Player: " + Integer.toString(userWins));

            // if 3 rounds have elapsed, determine the winner
            if (count ==3 && !fighters.getText().equals("")) {
                Intent intent = new Intent(PickFighter.this,BattleResult.class);
                battle.pause();
                if (userWins > cpuWins) {
                    intent.putExtra("result", "win");
                } else if (userWins < cpuWins) {
                    intent.putExtra("result", "loss");
                } else if (userWins == cpuWins){
                    intent.putExtra("result","tie");
                }
                startActivity(intent);
                battle.release();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_fighter);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setIcon(R.drawable.animon_fight);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // sound effects
        battle = MediaPlayer.create(this,tune);
        battle.start();
        if (!battle.isPlaying()){
            battle.start();
        }

        // linking various buttons to implementation classes
        TextView rounds = (TextView) findViewById(R.id.Round);
        rounds.setText("Round");

        ImageButton cat, mouse, elephant, lizard, turtle,ball ;
        Button fight;

        cat = (ImageButton) findViewById(R.id.Cat);
        mouse = (ImageButton) findViewById(R.id.Mouse);
        lizard = (ImageButton) findViewById(R.id.Lizard);
        elephant = (ImageButton) findViewById(Elephant);
        turtle = (ImageButton) findViewById(R.id.Turtle);
        ball = (ImageButton) findViewById(R.id.Ball);
        fight = (Button) findViewById(R.id.Fight);

        PickFighter.MyClick myClickListener = new PickFighter.MyClick();
        PickFighter.FightClick fightListener = new PickFighter.FightClick();

        cat.setOnClickListener(myClickListener);
        mouse.setOnClickListener(myClickListener);
        lizard.setOnClickListener(myClickListener);
        elephant.setOnClickListener(myClickListener);
        turtle.setOnClickListener(myClickListener);
        fight.setOnClickListener(fightListener);
        ball.setOnClickListener(myClickListener);
    }
}
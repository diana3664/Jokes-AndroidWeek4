package com.moringaschool.joke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JokeList extends AppCompatActivity {

    @BindView(R.id.jokeView) TextView mJokeView;

    private String[] jokes = new String[] {"What did the sniper say to his girlfirend after they broke up? I wont miss you ", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_list);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mJokeView.setText("Hello" +" "+ name+",Jokes to start you off:" );
        ButterKnife.bind(this);
    }
}
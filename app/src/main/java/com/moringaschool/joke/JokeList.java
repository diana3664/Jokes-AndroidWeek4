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
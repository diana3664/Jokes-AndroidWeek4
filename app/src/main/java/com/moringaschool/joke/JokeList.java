package com.moringaschool.joke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JokeList extends AppCompatActivity {

    @BindView(R.id.jokeView) TextView mJokeView;
    @BindView(R.id.listView) ListView mListView;

    private String[] jokes = new String[] {"Animals ", "Family",
            "Knock Knock", "Kids", "blonde", "Dad jokes", "Random","Create your own Joke"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_list);
        ButterKnife.bind(this);

        MyJokesArrayAdapter  adapter = new MyJokesArrayAdapter(this, android.R.layout.simple_list_item_1,jokes);
        mListView.setAdapter(adapter);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mJokeView.setText("Hello" +" "+ name+",Joke Categories to start you off (:P" );
        ButterKnife.bind(this);
    }
}
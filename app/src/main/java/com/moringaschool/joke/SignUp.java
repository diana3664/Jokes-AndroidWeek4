package com.moringaschool.joke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.viewJokesButton) Button mViewJokesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);

        mViewJokesButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        //Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(SignUp.this,JokeList.class);
        startActivity(intent);

    }
}
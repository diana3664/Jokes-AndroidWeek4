
package com.moringaschool.joke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView (R.id.signUpButton) Button msignUpButton;
    @BindView(R.id.LoginInButton) Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        msignUpButton.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        //Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_LONG).show();

        if(v==msignUpButton){
            Intent intent = new Intent(MainActivity.this,SignUp.class);
            startActivity(intent);
            finish();
        }
        if(v== mLoginButton){
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

    }

}
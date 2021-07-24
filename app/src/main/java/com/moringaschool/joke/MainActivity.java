
package com.moringaschool.joke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView (R.id.signUpButton) Button msignUpButton;
    @BindView(R.id.LoginInButton) Button mLoginButton;
    @BindView(R.id.appNameTextView1) TextView mAppNameTextView1;
    @BindView(R.id.appNameTextView2) TextView mAppNameTextView2;
    @BindView(R.id.appNameTextView3) TextView mAppNameTextView3;
    //variables
    Animation topAnim, buttomAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        msignUpButton.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);

        //animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        buttomAnim = AnimationUtils.loadAnimation(this,R.anim.buttom_animation);

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
package com.moringaschool.joke;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = SignUp.class.getSimpleName();
    @BindView(R.id.viewJokesButton) Button mViewJokesButton;
    @BindView(R.id.signEditText) EditText mSignEditText;
    @BindView(R.id.signEditText2) EditText mSignEditText2;
    @BindView(R.id.password) EditText mPassword;
    @BindView(R.id.cofirmPassword) EditText mConfirmPassword;
    @BindView(R.id.loginTextView) TextView mLoginTextView;
    private FirebaseAuth mAuth; //creating user in Firebase
    private FirebaseAuth.AuthStateListener mAuthListener;//inform our application when the user's account is successfully authenticated.
    private String mName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();//this is to accure tools provided in Firebase Authentification SDK

        mViewJokesButton.setOnClickListener(this);
        mLoginTextView.setOnClickListener(this);

        createAuthStateListener();
        
    }

    @Override
    public void onClick(View v) {

        if(v==mLoginTextView){
            Intent intent = new Intent(SignUp.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        if(v == mViewJokesButton) { //sign up button

            createNewUser();

        }


    }


    private void createNewUser() {
        final String name = mSignEditText.getText().toString().trim();
        final String email = mSignEditText2.getText().toString().trim();
         String password = mPassword.getText().toString().trim();
         String confirmPassword = mConfirmPassword.getText().toString().trim();
        mName = mSignEditText.getText().toString().trim();

        boolean validmName = isValidName(mName);
        boolean validEmail = isValidEmail(email);
        boolean validName = isValidName(name);
        boolean validPassword = isValidPassword(password, confirmPassword);
        if (!validEmail || !validName || !validPassword) return;



        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,task -> {
                    if(task.isSuccessful()){
                        Log.d(TAG, "Authentication successful");
                    }else {
                        Toast.makeText(SignUp.this, "Authentification failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private boolean isValidPassword(String password, String confirmPassword) {
        if(password.length() < 6){
            mConfirmPassword.setError("Please create a password containing at least 6 characters");
            return false;
        } else if (!password.equals(confirmPassword)){
            mConfirmPassword.setError("Passwords do not match");
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        boolean isGoodEmail = (email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if(!isGoodEmail){
            mSignEditText2.setError("Please enter a valid email address");
            return false;
        }
        return isGoodEmail;
    }

    private boolean isValidName(String name) {
        if(name.equals("")){
            mSignEditText.setError("Please enter your name");
            return false;
        }
        return true;
    }


    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(SignUp.this, JokeList.class);
                    Log.e(TAG,"User was signed " + user );
                  //  Toast.makeText(SignUp.this, "User is not null", Toast.LENGTH_SHORT).show();
                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                   startActivity(intent);
                    finish();
                }else
                    Toast.makeText(SignUp.this, "User is null", Toast.LENGTH_SHORT).show();

            }

        };
        }





    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop(){
        super.onStop();
        if(mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
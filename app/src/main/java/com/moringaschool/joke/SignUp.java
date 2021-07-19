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

    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(SignUp.this,JokeList.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }

            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v == mViewJokesButton) {
//            if(mSignEditText.length()==0){
//                mSignEditText.setError("Enter your name");
//            }else if (mSignEditText2.length() == 0){
//                mSignEditText2.setError("Enter email");
//            }else {
//                String name = mSignEditText.getText().toString();
//                Log.d(TAG, name);
//                validateEmail(mSignEditText2);
//                Intent intent = new Intent(SignUp.this, JokeList.class);
//                intent.putExtra("name", name);
//                startActivity(intent);
//            }

            createNewUser();

        }
        if(v==mLoginTextView){
            Intent intent = new Intent(SignUp.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

    }

    private void createNewUser() {
        final String name = mSignEditText.getText().toString().trim();
        final String email = mSignEditText2.getText().toString().trim();
        final String password = mPassword.getText().toString().trim();
        final String confirmPassword = mConfirmPassword.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,task -> {
                    if(task.isSuccessful()){
                        Log.d(TAG, "Authentication successful");
                    }else {
                        Toast.makeText(SignUp.this, "Authentification failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private boolean validateEmail(EditText mSignEditText2){
        String email = mSignEditText2.getText().toString();
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this,"Email validated sucesfully",Toast.LENGTH_SHORT).show();
            return true;

        }else{
            Toast.makeText(this,"Invalid Email",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
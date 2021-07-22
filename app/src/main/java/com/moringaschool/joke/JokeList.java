package com.moringaschool.joke;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringaschool.Constants;
import com.moringaschool.joke.adapters.CategoryListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeList extends AppCompatActivity {

    @BindView(R.id.jokeView) TextView mJokeView;
    @BindView(R.id.catList) RecyclerView mCatList;
    List<String> categories;
    CategoryListAdapter adapter;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
//test the mshared preference
    private SharedPreferences mSharedPreferences;
    private String mRecentAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_list);
        categories = new ArrayList<>();
        //insert few data
        categories.add("Any");
        categories.add("Programming");
        categories.add("Miscellaneous");
        categories.add("Dark");
        categories.add("Pun");
        categories.add("Spooky");
        categories.add("Christmas");


        Context mContext;
        adapter = new CategoryListAdapter(categories );
        ButterKnife.bind(this);
        mCatList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mCatList.setAdapter(adapter);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mJokeView.setText("Hello" +" "+ name+" " +",Joke Categories Include:" );
        ButterKnife.bind(this);




        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction().replace(R.id.fragmentContainerView,new JokeDetailFragment(getResources().getString(R.string.Url)+"Any?amount=2"));
        transaction.commitNow();

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //display welcome message
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "!");
                } else {

                }
            }
        };


        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);// retrieve our shared preferences from the preference manager
        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_EMAIL_KEY, null);//pull data from it by calling getString()
        Log.d("Shared Pref Location", mRecentAddress);
        String email = mRecentAddress;//pass the email  stored in our sharedPreference as the current email.
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//inflate our menue in OCOM
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//tell app what action to perform when user selects logout
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {

        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(JokeList.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
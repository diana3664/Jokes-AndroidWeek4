package com.moringaschool.joke;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class JokeDetailFragment extends Fragment {

//@BindView(R.id.Fragment) TextView mFragment;
public static final String TAG = "TAG";
String jokeApiURL ;

//implement our recycler view for our jokes

    RecyclerView jokesListUpdated;
public JokeDetailFragment(String url){
    this.jokeApiURL = url;
    Log.d(TAG,"Main"+ jokeApiURL);
}

    public JokeDetailFragment() {
        // doesn't do anything special
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_joke_detail2,container,false);
        ButterKnife.bind(this, view);
        return view;
    }
}
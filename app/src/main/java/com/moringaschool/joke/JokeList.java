package com.moringaschool.joke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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



        adapter = new CategoryListAdapter(categories);
        ButterKnife.bind(this);
        mCatList.setLayoutManager(new LinearLayoutManager(this));
        mCatList.setAdapter(adapter);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mJokeView.setText("Hello" +" "+ name+" " +",Joke Categories Include:" );
        ButterKnife.bind(this);

//        JokeApi client = JokeClient.getClient();
//        Call<CategoriesSearchResponse> call = client.getCategories(Constants.Categories_URL);
//
//        call.enqueue(new Callback<CategoriesSearchResponse>() {
//            @Override
//            public void onResponse(Call<CategoriesSearchResponse> call, Response<CategoriesSearchResponse> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<CategoriesSearchResponse> call, Throwable t) {
//
//            }
//        });
    }
}
package com.moringaschool.joke;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.Constants;
import com.moringaschool.joke.adapters.GeneratedJokesAdapter;
import com.moringaschool.joke.models.Joke;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class JokeDetailFragment extends Fragment {
public static final String TAG = "TAG";
String jokeApiURL ;
RecyclerView jokesListUpdated; //implement our recycler view for our joke
GeneratedJokesAdapter adapter; //instance of our adapter
    List<Joke> allJokes;


public JokeDetailFragment(String url){
    this.jokeApiURL = url;
    Log.d(TAG,"Main"+ jokeApiURL);
    allJokes = new ArrayList<>();//inistiate our all jokes
}

    public JokeDetailFragment() {
        // doesn't do anything special
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_joke_detail2,container,false);
        jokesListUpdated = v.findViewById(R.id.recyclerJokeList);
        jokesListUpdated.setLayoutManager(new LinearLayoutManager(v.getContext()));
        getJokes(jokeApiURL);//pass the url to our getJokes method

        adapter = new GeneratedJokesAdapter(allJokes);//send our jokes to the adapter
        jokesListUpdated.setAdapter(adapter);//our connected recycler view to our  adapter





        return v;
    }
    //set our JSON response to the adapter
    public void getJokes(String url){
    //extract Json data
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG ,"onResponse"+response.toString());

                try {
                    int amount = Integer.parseInt(response.getString("amount"));
                    JSONArray jokesArray = response.getJSONArray("jokes");//because our array is an array of jokes
                    for(int i= 0; i< amount;i++){//a forLoop to call our jokes everytime
                        JSONObject jokes = jokesArray.getJSONObject(i);
                        Joke j = new Joke();//call our Joke class
                        j.setType(jokes.getString("type"));

                        if(jokes.getString("type").equals("single")){
                            j.setJoke(jokes.getString("joke"));
                        }else {
                            j.setSetUp(jokes.getString("setup"));
                            j.setDelivery(jokes.getString("delivery"));


                        }
                        allJokes.add(j);
                        adapter.notifyDataSetChanged();//to notify adapter that our data has been changed
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show(); //display the message we get from the

            }
        });

        queue.add(objectRequest);
    }



}
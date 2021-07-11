package com.moringaschool.joke.network;

import com.moringaschool.joke.Constants;
import com.moringaschool.joke.network.JokeApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JokeClient {

    private static Retrofit retrofit = null;

    public static JokeApi getClient() {
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.Categories_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
return retrofit.create(JokeApi.class);
    }


}

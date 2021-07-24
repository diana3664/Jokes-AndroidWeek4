package com.moringaschool.joke.models;

import org.parceler.Parcel;

//for our recycler view GeneratedJokesAdapter
@Parcel
public class Joke {
    private String type;
    private String setUp;
    private String delivery;
    private String joke;


    public Joke () {

    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetUp() {
        return setUp;
    }

    public void setSetUp(String setUp) {
        this.setUp = setUp;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }


}

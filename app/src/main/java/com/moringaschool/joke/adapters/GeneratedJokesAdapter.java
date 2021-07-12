package com.moringaschool.joke.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.joke.R;
import com.moringaschool.joke.models.Joke;

import java.util.List;

public class GeneratedJokesAdapter extends RecyclerView.Adapter<GeneratedJokesAdapter.ViewHolder> {
    List<Joke> allJokes; //from models

    public GeneratedJokesAdapter(List<Joke> jokes){
        this.allJokes = jokes;
    }
    @NonNull
    @Override
    public GeneratedJokesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.jokes_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GeneratedJokesAdapter.ViewHolder holder, int position) {
            //check joke types
        if (allJokes.get(position).getType().equals("single")){
            holder.firstLine.setText(allJokes.get(position).getJoke());
            holder.secondLine.setText("");
        }else{
            holder.firstLine.setText(allJokes.get(position).getJoke());
            holder.secondLine.setText(allJokes.get(position).getDelivery());
        }

    }

    @Override
    public int getItemCount() {
        return allJokes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView firstLine,secondLine;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            firstLine = itemView.findViewById(R.id.firstLine);
            secondLine =itemView.findViewById(R.id.secondLine);
        }
    }
}

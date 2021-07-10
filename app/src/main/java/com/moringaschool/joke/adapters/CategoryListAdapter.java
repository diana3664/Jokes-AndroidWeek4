package com.moringaschool.joke.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.joke.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {

    List<String> category;
    Context mContext; //context

   public CategoryListAdapter(Context context,List<String> category){
       this.category=category;
       mContext = context;
   }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list, parent, false);
       return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
       holder.categoryName.getText(Integer.parseInt(category.get(position)));

    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
       @BindView(R.id.textView3) TextView mTextview3;
       @BindView(R.id.textView4) TextView mTextview4;
       @BindView(R.id.textView5) TextView mTextview5;
       @BindView(R.id.textView6) TextView mTextview6;
       @BindView(R.id.textView7) TextView mTextview7;
       @BindView(R.id.textView8) TextView mTextview8;
       Context categoryName;

       public CategoryViewHolder(@NonNull View itemView) {
           super(itemView);

           ButterKnife.bind(this,itemView);
           categoryName = itemView.getContext();
       }


   }
}

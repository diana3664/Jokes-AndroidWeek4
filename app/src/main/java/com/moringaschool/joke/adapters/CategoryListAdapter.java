package com.moringaschool.joke.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.joke.JokeDetailFragment;
import com.moringaschool.joke.JokeList;
import com.moringaschool.joke.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {

    List<String> mCategory;
    int positionOfCard;

    public CategoryListAdapter(List<String> category){
       this.mCategory=category;

   }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list, parent, false);
       return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
       holder.textView3.setText(mCategory.get(position));
       if(positionOfCard  == position){
           //set red
           holder.cardItem.setCardBackgroundColor(Color.RED);

       }else {
           //set white
           holder.cardItem.setCardBackgroundColor(Color.YELLOW);
       }

    }

    @Override
    public int getItemCount() {
        return mCategory.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
          TextView textView3;
          CardView cardItem;

       public CategoryViewHolder(@NonNull View itemView) {
           super(itemView);

           textView3=itemView.findViewById(R.id.textView3);
           cardItem=itemView.findViewById(R.id.cardItem);
           itemView.setOnClickListener(this);
       }


        @Override
        public void onClick(View v) {
           notifyItemChanged(positionOfCard);
           positionOfCard = getAdapterPosition();
           notifyItemChanged(positionOfCard);

           if(mCategory.get(positionOfCard).equals("Any")){
               AppCompatActivity activity = (AppCompatActivity) v.getContext();

               FragmentManager manager = activity.getSupportFragmentManager();
               FragmentTransaction transaction = manager.beginTransaction().replace(R.id.fragmentContainerView,new JokeDetailFragment(activity.getResources().getString(R.string.Url)+"Any"));
               transaction.commitNow();           }
            if(mCategory.get(positionOfCard).equals("Programming")){
                Toast.makeText(v.getContext(),"Programming category selected",Toast.LENGTH_SHORT).show();
            }
            if(mCategory.get(positionOfCard).equals("Miscellaneous")){
                Toast.makeText(v.getContext(),"Miscellaneous category selected",Toast.LENGTH_SHORT).show();
            }
            if(mCategory.get(positionOfCard).equals("Dark")){
                Toast.makeText(v.getContext(),"Dark category selected",Toast.LENGTH_SHORT).show();
            }
            if(mCategory.get(positionOfCard).equals("Pun")){
                Toast.makeText(v.getContext(),"Pun category selected",Toast.LENGTH_SHORT).show();
            }
            if(mCategory.get(positionOfCard).equals("Spooky")){
                Toast.makeText(v.getContext(),"Spooky category selected",Toast.LENGTH_SHORT).show();
            }
            if(mCategory.get(positionOfCard).equals("Christmas")){
                Toast.makeText(v.getContext(),"Christmas category selected",Toast.LENGTH_SHORT).show();
            }

        }
    }
}

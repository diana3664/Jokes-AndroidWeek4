package com.moringaschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.moringaschool.joke.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JokeImage extends AppCompatActivity implements View.OnClickListener{
    @BindView (R.id.Imagebutton) Button mImageButton;
    @BindView(R.id.picView) ImageView mPicView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_image);
        ButterKnife.bind(this);
        mImageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==mImageButton){
            YoYo.with(Techniques.Tada)
                    .duration(700)
                    .repeat(5)
                    .playOn(findViewById(R.id.picView));

        }

    }
}
package com.example.fouractivityapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class Faves extends AppCompatActivity {
    @Nullable
    @BindView(R.id.favorite_one)
    Button favoriteOneButton;
    @Nullable
    @BindView(R.id.favorite_two)
    Button favoriteTwoButton;
    @Nullable
    @BindView(R.id.favorite_three)
    Button favoriteThreeButton;
    @Nullable
    @BindView(R.id.favorite_four)
    Button getFavoriteFourButton;
    @Nullable
    FavesFragment favesFragment;
    @Nullable
    @BindView(R.id.back)
    Button backButton;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faves);
        Log.d("Faves", "In onCreate method in Faves activity");
        ButterKnife.bind(this);
        favesFragment= new FavesFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.favesLayoutTopLeftLand, favesFragment).commit();
    }

    @OnClick({R.id.favorite_one, R.id.favorite_two, R.id.favorite_three, R.id.favorite_four, R.id.back})
    public void onClick(View view) {
        Intent intent = new Intent(this, Profile.class);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Log.d("Profile - onCreate", "In the second activity");
        if(sharedPreferences.contains("userProfile")) {
            Gson gson = new Gson();
            UserProfile userProfile = gson.fromJson(sharedPreferences.getString("userProfile", ""), UserProfile.class);
            switch (view.getId()) {
                case R.id.favorite_one:
                    Log.d("Faves-buttonPress", "Favorite one button pressed");
                    favesFragment.textView.setText(userProfile.getFave1());
                    break;
                case R.id.favorite_two:
                    Log.d("Faves-buttonPress", "Favorite two button pressed");
                    favesFragment.textView.setText(userProfile.getFave2());                    break;
                case R.id.favorite_three:
                    Log.d("Faves-buttonPress", "Favorite three button pressed");
                    favesFragment.textView.setText(userProfile.getFave3());                    break;
                case R.id.favorite_four:
                    Log.d("Faves-buttonPress", "Favorite four button pressed");
                    favesFragment.textView.setText(userProfile.getFave4());                    break;
                case R.id.back:
                    startActivity(intent);
                    break;
            }
        }
    }
}

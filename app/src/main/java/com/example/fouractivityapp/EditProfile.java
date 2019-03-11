package com.example.fouractivityapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditProfile extends AppCompatActivity {

    @BindView(R.id.editTextProfile1) EditText MyFirstProfileText;
    @BindView(R.id.editTextProfile2) EditText MySecondProfileText;
    @BindView(R.id.editTextProfile3) EditText MyThirdProfileText;
    @BindView(R.id.editTextProfile4) EditText MyFourthProfileText;
    @BindView(R.id.editTextProfile5) EditText MyFirstFavorite;
    @BindView(R.id.editTextProfile6) EditText MySecondFavorite;
    @BindView(R.id.editTextProfile7) EditText MyThirdFavorite;
    @BindView(R.id.editTextProfile8) EditText MyFourthFavorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile_and_faves);
        ButterKnife.bind(EditProfile.this);
        Log.d("editProfile", "In onCreate method in EditProfile activity");
    }

    @OnClick(R.id.buttonsubmit)
    public void clickSubmit(){
        Intent intent =new Intent(EditProfile.this, Profile.class);
        intent.putExtra("ProfileText1", MyFirstProfileText.getText().toString());
        intent.putExtra("ProfileText2", MySecondProfileText.getText().toString());
        intent.putExtra("ProfileText3", MyThirdProfileText.getText().toString());
        intent.putExtra("ProfileText4", MyFourthProfileText.getText().toString());
        intent.putExtra("FavoriteText1", MyFirstFavorite.getText().toString());
        intent.putExtra("FavoriteText2", MySecondFavorite.getText().toString());
        intent.putExtra("FavoriteText3", MyThirdFavorite.getText().toString());
        intent.putExtra("FavoriteText4", MyFourthFavorite.getText().toString());
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("ProfileText1",MyFirstProfileText.getText().toString());
        editor.putString("ProfileText2",MySecondProfileText.getText().toString());
        editor.putString("ProfileText3",MyThirdProfileText.getText().toString());
        editor.putString("ProfileText4",MyFourthProfileText.getText().toString());
        editor.putString("FavoriteText1",MyFirstFavorite.getText().toString());
        editor.putString("FavoriteText2",MySecondFavorite.getText().toString());
        editor.putString("FavoriteText3",MyThirdFavorite.getText().toString());
        editor.putString("FavoriteText4",MyFourthFavorite.getText().toString());
        editor.apply();
        startActivity(intent);
    }

}


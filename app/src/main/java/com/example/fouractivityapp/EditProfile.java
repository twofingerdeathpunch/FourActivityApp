package com.example.fouractivityapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditProfile extends AppCompatActivity {

    @BindView(R.id.editTextProfile1) EditText myFirstProfileText;
    @BindView(R.id.editTextProfile2) EditText mySecondProfileText;
    @BindView(R.id.editTextProfile3) EditText myThirdProfileText;
    @BindView(R.id.editTextProfile4) EditText myFourthProfileText;
    @BindView(R.id.editTextProfile5) EditText myFirstFavorite;
    @BindView(R.id.editTextProfile6) EditText mySecondFavorite;
    @BindView(R.id.editTextProfile7) EditText myThirdFavorite;
    @BindView(R.id.editTextProfile8) EditText myFourthFavorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile_and_faves);
        ButterKnife.bind(EditProfile.this);
        Log.d("editProfile", "In onCreate method in EditProfile activity");
    }

    @OnClick(R.id.buttonsubmit)
    public void clickSubmit(){
        UserProfile tempProfile = new UserProfile("Name", myFirstProfileText.getText().toString(),
                mySecondProfileText.getText().toString(), myThirdProfileText.getText().toString(),
                myFourthProfileText.getText().toString(), myFirstFavorite.getText().toString(),
                mySecondFavorite.getText().toString(), myThirdFavorite.getText().toString(), myFourthFavorite.getText().toString());
        Intent intent =new Intent(EditProfile.this, Profile.class);
        Gson gson = new Gson();
        String json = gson.toJson(tempProfile);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userProfile", json).apply();
        startActivity(intent);
    }

}


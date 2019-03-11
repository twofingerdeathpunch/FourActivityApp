package com.example.fouractivityapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Profile extends AppCompatActivity {

    @BindView(R.id.faves_button)
    Button favesButton;
    @BindView(R.id.edit_button)
    Button editButton;
    @BindView(R.id.logout_button)
    Button logoutButton;
    @BindView(R.id.ProfileText1)
    TextView textProfile1;
    @BindView(R.id.ProfileText2)
    TextView textProfile2;
    @BindView(R.id.ProfileText3)
    TextView textProfile3;
    @BindView(R.id.ProfileText4)
    TextView textProfile4;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Log.d("Profile - onCreate", "In the second activity");
        if(sharedPreferences.contains("userProfile")) {
            Gson gson = new Gson();
            UserProfile userProfile = gson.fromJson(sharedPreferences.getString("userProfile","") , UserProfile.class);
            textProfile1.setText(userProfile.getLike());
            textProfile2.setText(userProfile.getBeenTo());
            textProfile3.setText(userProfile.getWantToGo());
            textProfile4.setText(userProfile.getInterests());
        }
    }

    @OnClick({R.id.faves_button, R.id.edit_button, R.id.logout_button})
    public void onClick(View view) {
        Intent intent = new Intent();

        int buttonClicked = view.getId();
        Log.d("Profile - onClick", "Inside onClick method, before switch statement");
        switch (buttonClicked) {
            case R.id.faves_button:
                intent = intent.setClass(this, Faves.class);
                Log.d("Profile -  onClick","Detect button press for faves button");
                break;
            case R.id.edit_button:
                intent = intent.setClass(this, EditProfile.class);
                Log.d("Profile -  onClick","Detect button press for edit button");
                break;
            case R.id.logout_button:
                intent = intent.setClass(this, MainActivity.class);
                Log.d("Profile -  onClick","Detect button press for logout button");
                break;
        }
        startActivity(intent);
    }
    @OnClick(R.id.logout_button)
    public void clickSubmit() {
        Toast.makeText(this, "Finishing...", Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("loggedIn", false).apply();
        finish();
    }
}

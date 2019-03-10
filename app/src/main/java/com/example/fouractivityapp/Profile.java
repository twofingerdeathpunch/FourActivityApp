package com.example.fouractivityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        Log.d("Profile - onCreate", "In the second activity");
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
                Log.d("Profile -  onClick","Detect button press for faves button");
                break;
            case R.id.logout_button:
                intent = intent.setClass(this, MainActivity.class);
                Log.d("Profile -  onClick","Detect button press for faves button");
                break;
        }
        startActivity(intent);
    }
    @OnClick(R.id.logout_button)
    public void clickSubmit() {
        Toast.makeText(this, "Finishing...", Toast.LENGTH_SHORT).show();
        finish();
    }
}

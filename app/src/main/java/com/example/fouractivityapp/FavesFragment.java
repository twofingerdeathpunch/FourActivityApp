package com.example.fouractivityapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FavesFragment extends Fragment {

    TextView textView;

    public FavesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faves_fragment, container, false);
        textView = view.findViewById(R.id.faves_fragment);
        textView.setText("Fragment Works YAY!!!!!!");
        return view;
    }
}

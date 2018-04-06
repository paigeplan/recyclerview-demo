package com.example.paigeplander.april6_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.my_recycler_view);

        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i<50; i++) {
            data.add("item #" + i);
        }
        mRecyclerView.setAdapter(new MyAdapter(data, this));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}

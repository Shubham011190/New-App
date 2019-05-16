package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class summaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        RecyclerView newRecycler = (RecyclerView)findViewById(R.id.summaryRecycler);
        newRecycler.setLayoutManager(new LinearLayoutManager(this));
        newRecycler.setAdapter(new summaryAdapter());


    }
}

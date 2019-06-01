package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class summaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        RecyclerView newRecycler = findViewById(R.id.summaryRecycler);
        newRecycler.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Data> temp = getIntent().getParcelableExtra("DATA");
        Context context = getApplicationContext();
        newRecycler.setAdapter(new summaryAdapter(context,temp));

    }
}
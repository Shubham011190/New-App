package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogNewAdd.DialogNewAddListener {
    ArrayList<Data> data = new ArrayList<>();
    Database db;
    private RecyclerView.Adapter mAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView newList = findViewById(R.id.recyclerView);
        newList.setLayoutManager(new LinearLayoutManager(this));
        db= new Database(this);

        mContext = getApplicationContext();

        Data temp = new Data();
        temp.setName("Shubham");
        temp.setDate("16/09/2018");
        temp.setID("4541");
        temp.setDebitAmt(5000.00);
        temp.setCreditAmt(2000.00);
        temp.setBalanceAmt(temp.getDebitAmt()-temp.getCreditAmt());
        data.add(temp);

        Data temp2 = new Data();
        temp2.setName("Vishal");
        temp2.setDate("15/02/2018");
        temp2.setID("51165");
        temp2.setDebitAmt(6000.00);
        temp2.setCreditAmt(2000.00);
        temp2.setBalanceAmt(temp.getDebitAmt()-temp.getCreditAmt());
        data.add(temp2);

        mAdapter = new rAdapter(mContext, data);

        final Intent intent = new Intent(this,summaryActivity.class);
        intent.putExtra("DATA",data);
        newList.setAdapter(mAdapter);

        Button btnAdd = findViewById(R.id.addBtn);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogNewAdd dialog = new DialogNewAdd();
                dialog.show(getSupportFragmentManager(),"");
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    @Override
    public void apply(Data mData) {
        data.add(mData);
        mAdapter.notifyDataSetChanged();

    }

}
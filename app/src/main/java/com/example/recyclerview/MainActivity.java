package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Data mData = new Data();
//    Data[] data;
    public void createNewData(Data d){
        mData=d;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView newList = findViewById(R.id.recyclerView);
        newList.setLayoutManager(new LinearLayoutManager(this));
        Data temp = new Data();
        temp.setName("Shubham");
        temp.setDate("16/09/2018");
        temp.setID("4541");
        temp.setDebitAmt(5000.00);
        temp.setCreditAmt(2000.00);

        newList.setAdapter(new rAdapter(temp));

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
                activitySummary();
            }
        });


    }

    private void activitySummary() {
        TextView idval = findViewById(R.id.balanceDisplay);
        TextView dateval = findViewById(R.id.dateDisplay);
        TextView nameval = findViewById(R.id.nameDisplay);
        TextView idbal = findViewById(R.id.balanceDisplay);
        Intent intent = new Intent(this,summaryActivity.class);
        startActivity(intent);
    }

}

package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

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
        temp.setBalanceAmt(temp.getDebitAmt()-temp.getCreditAmt());
        final Intent intent = new Intent(this,summaryActivity.class);
        intent.putExtra("DATA",temp);

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

                activitySummary(intent);
            }
        });


    }

    private void activitySummary(Intent intent) {
        startActivity(intent);
    }

}
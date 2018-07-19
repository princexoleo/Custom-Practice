package com.app.leo.taptargetview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Main3Activity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    String [] names={"Leo","Neymar","Messi","Pogba","Ronaldo","Costa","Hulk","Pepe"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new ViewAdapter(names));
    }


    //for initilize all
    private void init() {
        mRecyclerView=findViewById(R.id.myrecyclerview);
    }
}

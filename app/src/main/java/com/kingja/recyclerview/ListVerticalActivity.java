package com.kingja.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

/**
 * Description：TODO
 * Create Time：2017/7/721:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ListVerticalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vertical);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
//        ListVerticalAdapter mListVerticalAdapter = new ListVerticalAdapter(this, Arrays.asList("A", "B", "C"));
//        rv.setAdapter(mListVerticalAdapter);
        rv.addItemDecoration(new ListVerticalDecoration());

    }
}

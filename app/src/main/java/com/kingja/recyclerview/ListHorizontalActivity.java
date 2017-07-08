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
public class ListHorizontalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ListHorizontalAdapter mListHorizontalAdapter = new ListHorizontalAdapter(this, Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"));
        rv.setAdapter(mListHorizontalAdapter);
        rv.addItemDecoration(new ListHorizontalDecoration());

    }
}

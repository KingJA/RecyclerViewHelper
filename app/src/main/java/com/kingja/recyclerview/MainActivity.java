package com.kingja.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kingja.recyclerviewhelper.LayoutHelper;
import com.kingja.recyclerviewhelper.RecyclerViewHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Data> datas = new ArrayList<>();
    private int[] imgarr = {R.mipmap.image_mycar, R.mipmap.image_mycare, R.mipmap.image_myhouse,
            R.mipmap.image_myintermediary, R.mipmap.image_myrental, R.mipmap.image_mycare, R.mipmap.image_myhouse,
            R.mipmap.image_myintermediary, R.mipmap.image_myrental, R.mipmap.image_mycare, R.mipmap.image_myhouse,
            R.mipmap.image_myintermediary, R.mipmap.image_myrental};
    private MoveableAdapter mMoveableAdapter;
    private NormalAdapter mNormalAdapter;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        for (int i = 0; i < imgarr.length; i++) {
            datas.add(new Data("Item" + i, imgarr[i]));
        }


        mMoveableAdapter = new MoveableAdapter(this, datas);
        mNormalAdapter = new NormalAdapter(this, datas);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        rv = (RecyclerView) findViewById(R.id.rv);
        switch (item.getItemId()) {
            case R.id.action_vertical_list:
                new RecyclerViewHelper.Builder(this)
                        .setAdapter(mMoveableAdapter)
                        .setLayoutStyle(LayoutHelper.LayoutStyle.VERTICAL_LIST)
                        .setDividerHeight(8)
                        .setDividerColor(0xffff0000)
                        .setSwipeable(true)
                        .setDragable(true)
                        .build()
                        .attachToRecyclerView(rv);
                break;
            case R.id.action_horizontal_list:
                new RecyclerViewHelper.Builder(this)
                        .setAdapter(mMoveableAdapter)
                        .setLayoutStyle(LayoutHelper.LayoutStyle.HORIZONTAL_LIST)
                        .setDividerHeight(8)
                        .setDividerColor(0xffff0000)
                        .build()
                        .attachToRecyclerView(rv);
                break;
            case R.id.action_grid:
                new RecyclerViewHelper.Builder(this)
                        .setAdapter(mNormalAdapter)
                        .setLayoutStyle(LayoutHelper.LayoutStyle.GRID)
                        .setDividerHeight(4)
                        .setColumns(4)
                        .setDividerColor(0xffff0000)
                        .setDragable(true)
                        .build()
                        .attachToRecyclerView(rv);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

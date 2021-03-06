package com.kingja.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.kingja.recyclerviewhelper.BaseRvAdaper;
import com.kingja.recyclerviewhelper.LayoutHelper;
import com.kingja.recyclerviewhelper.RecyclerViewHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:TODO
 * Create Time:2017/7/8 14:39
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SampleActivity extends AppCompatActivity {
    private String[] musicNames = {"Hot2Touch (Kyle Watson Remix)", "Glory (Bunker Sessions)", "Sweat", "Something To" +
            " " +
            "Tell You", "4:44", "ISSA", "Do Not Revenge", "Hug of Thunder", "Swimming Pool Summer", "Get Low",
            "Hearts"};
    private String[] musicAuthors = {"Felix Jaehn", "Bastille", "The All-American Rejects", "HAIM",
            "4:44", "21 Savage", "Dan Black", "Broken Social Scene", "Capital Cities", "Zedd",
            "Gill Chang"};
    private int resIds[] = {R.mipmap.music_1, R.mipmap.music_2, R.mipmap.music_3, R.mipmap.music_4, R.mipmap.music_5,
            R.mipmap.music_6, R
            .mipmap.music_7, R.mipmap.music_8, R.mipmap.music_9, R.mipmap.music_10, R.mipmap.music_11};
    private RecyclerView mRv;
    private TextView mTvDivideWidth;
    private AppCompatSeekBar mSeekbarDivideWidth;
    private TextView mTvDivideColor;
    private ImageView mIvDivideColor;
    private AppCompatSpinner mSpinnerOrientation;
    private AppCompatCheckBox mCbDragable;
    private AppCompatCheckBox mCbSlideable;
    private List<Music> musics = new ArrayList<>();
    private String[] styles = {"vertical", "horizontal", "grid"};
    private RecyclerViewHelper recyclerViewHelper;
    private int dividerHeight;
    private int dividerColor = 0xffFF4081;
    private RecyclerView.ItemDecoration itemDecoration;
    private BaseRvAdaper mAdapter;
    private LayoutHelper.LayoutStyle layoutStyle;
    private boolean dragable;
    private boolean slideable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        initData();
        initView();
        initEvent();
        setData();
    }

    private void initData() {
        for (int i = 0; i < musicNames.length; i++) {
            musics.add(new Music(musicNames[i], musicAuthors[i], resIds[i]));
        }
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mTvDivideWidth = (TextView) findViewById(R.id.tv_divide_width);
        mSeekbarDivideWidth = (AppCompatSeekBar) findViewById(R.id.seekbar_divide_width);
        mTvDivideColor = (TextView) findViewById(R.id.tv_divide_color);
        mIvDivideColor = (ImageView) findViewById(R.id.iv_divide_color);
        mSpinnerOrientation = (AppCompatSpinner) findViewById(R.id.spinner_orientation);
        mCbDragable = (AppCompatCheckBox) findViewById(R.id.cb_dragable);
        mCbSlideable = (AppCompatCheckBox) findViewById(R.id.cb_slideable);


    }


    private void setData() {
        mAdapter = new ListVerticalAdapter(this, musics);
        layoutStyle = LayoutHelper.LayoutStyle.VERTICAL_LIST;
        refreshRv();
    }

    private void refreshRv() {
        if (itemDecoration != null) {
            mRv.removeItemDecoration(itemDecoration);
        }
        recyclerViewHelper = new RecyclerViewHelper.Builder(this)
                .setAdapter(mAdapter)
                .setLayoutStyle(layoutStyle)
                .setDividerHeight(dividerHeight)
                .setDividerColor(dividerColor)
                .setSwipeable(slideable)
                .setDragable(dragable)
                .setColumns(3)
                .build();
        recyclerViewHelper.attachToRecyclerView(mRv);
        itemDecoration = recyclerViewHelper.getItemDecoration();
    }


    private void setOrientation(int position) {
        switch (position) {
            case 0:
                mAdapter = new ListVerticalAdapter(this, musics);
                layoutStyle = LayoutHelper.LayoutStyle.VERTICAL_LIST;
                break;
            case 1:
                mAdapter = new ListHorizontalAdapter(this, musics);
                layoutStyle = LayoutHelper.LayoutStyle.HORIZONTAL_LIST;
                break;
            case 2:
                mAdapter = new GridAdapter(this, musics);
                layoutStyle = LayoutHelper.LayoutStyle.GRID;
                break;

        }
    }

    private void initEvent() {
        mSpinnerOrientation.setAdapter(new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, styles));
        mSpinnerOrientation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setOrientation(position);
                refreshRv();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mSeekbarDivideWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTvDivideWidth.setText(progress + "dp");
                dividerHeight = progress;
                refreshRv();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mCbDragable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                dragable = isChecked;
                refreshRv();
            }
        });
        mCbSlideable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                slideable = isChecked;
                refreshRv();
            }
        });
    }


}

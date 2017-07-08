package com.kingja.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.kingja.recyclerviewhelper.BaseRvAdaper;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2016/8/16 13:58
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ListHorizontalAdapter extends BaseRvAdaper<Music>  {


    public ListHorizontalAdapter(Context context, List<Music> list) {
        super(context, list);
    }

    @Override
    protected ViewHolder createViewHolder(View v) {
        return new GiftViewHolder(v);
    }

    @Override
    protected int getItemView() {
        return R.layout.item_list_horizontal;
    }

    @Override
    protected void bindHolder(ViewHolder baseHolder, Music bean, final int position) {
        final GiftViewHolder holder = (GiftViewHolder) baseHolder;
//        holder.tv_test.setText(bean);
    }




    class GiftViewHolder extends ViewHolder {
        public TextView tv_test;

        public GiftViewHolder(View itemView) {
            super(itemView);
            tv_test = (TextView) itemView.findViewById(R.id.tv_test);
        }
    }
}

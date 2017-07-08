package com.kingja.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingja.recyclerviewhelper.BaseRvAdaper;
import com.kingja.recyclerviewhelper.RecyclerViewHelper;

import java.util.Collections;
import java.util.List;

/**
 * Description：TODO
 * Create Time：2016/8/16 13:58
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ListVerticalAdapter extends BaseRvAdaper<Music>implements RecyclerViewHelper.OnItemCallback   {


    public ListVerticalAdapter(Context context, List<Music> list) {
        super(context, list);
    }

    @Override
    protected ViewHolder createViewHolder(View v) {
        return new GiftViewHolder(v);
    }

    @Override
    protected int getItemView() {
        return R.layout.item_list_vertical;
    }

    @Override
    protected void bindHolder(ViewHolder baseHolder, Music bean, final int position) {
        final GiftViewHolder holder = (GiftViewHolder) baseHolder;
        holder.tv_music_name.setText(bean.getMusicName());
        holder.tv_music_author.setText(bean.getMusicAuthor());
        holder.iv_music_img.setBackgroundResource(bean.getMusicResId());
    }

    @Override
    public void onMove(int fromPosition, int toPosition) {
        Collections.swap(list, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onSwipe(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }


    class GiftViewHolder extends ViewHolder {
        public TextView tv_music_name;
        public TextView tv_music_author;
        public ImageView iv_music_img;

        public GiftViewHolder(View itemView) {
            super(itemView);
            tv_music_name = (TextView) itemView.findViewById(R.id.tv_music_name);
            tv_music_author = (TextView) itemView.findViewById(R.id.tv_music_author);
            iv_music_img = (ImageView) itemView.findViewById(R.id.iv_music_img);
        }
    }
}

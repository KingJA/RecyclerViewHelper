package com.kingja.recyclerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Description：TODO
 * Create Time：2017/7/721:43
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ListHorizontalDecoration extends RecyclerView.ItemDecoration {

    private final int dividerHeight;
    private final Paint dividerPaint;

    public ListHorizontalDecoration() {
        dividerPaint = new Paint();
        dividerPaint.setColor(0xffFF4081);
        dividerHeight = 10;
    }

    /**
     * 可以实现类似绘制背景的效果，内容在上面
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        drawHorizontal(c, parent);
    }

    /**
     * 可以绘制在内容的上面，覆盖内容
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        drawHorizontal(c, parent);
    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        for (int i = 0; i < childCount - 1; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = view.getBottom() + dividerHeight;
            c.drawRect(left, top, right, bottom, dividerPaint);
        }
    }

    /**
     * item 的left，top，right，bottom的padding,每次都会调用
     * outRect.set(0,0,dividerHeight,0) 设置的区域,RecyclerView的背景会显示出来
     *
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int itemCount = state.getItemCount();
        int position = parent.getChildAdapterPosition(view);
        if (position != itemCount - 1) {
            outRect.set(0,0,dividerHeight,0);
        }

    }
}

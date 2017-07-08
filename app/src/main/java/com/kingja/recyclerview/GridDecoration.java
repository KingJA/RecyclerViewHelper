package com.kingja.recyclerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * Description：TODO
 * Create Time：2017/7/721:43
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class GridDecoration extends RecyclerView.ItemDecoration {

    private final int dividerHeight;
    private final Paint dividerPaint;

    public GridDecoration() {
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
        Log.e(TAG, "onDrawOver: " );
        drawHorizontal(c, parent);
        drawVertical(c, parent);
    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int left = child.getLeft();
            int right = child.getRight()+dividerHeight;
            float top = child.getBottom();
            float bottom = top + dividerHeight;
            c.drawRect(left, top, right, bottom, dividerPaint);
        }
    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int left = child.getRight();
            int right = left+dividerHeight;
            float top = child.getTop();
            float bottom =child.getBottom();
            c.drawRect(left, top, right, bottom, dividerPaint);
        }
    }

    /**
     * item 的left，top，right，bottom的padding,每个item回调一次,item自己本身的尺寸不变
     * outRect中的值会被计算到item的padding里，如果RecyclerView的尺寸被固定了，那么item将会被压缩，即时它们是具体尺寸的。
     *
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
        int spanCount = layoutManager.getSpanCount();
        int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        int itemCount = state.getItemCount();
        int lastRow=itemCount/spanCount;

        if (isLastColum(position, spanCount)) {
            outRect.set(0,0,0,dividerHeight);
            Log.e(TAG, "position: " + position+ "isLastColum: " + isLastColum(position, spanCount));
        }else if (isLastRow(position,spanCount,lastRow)){
            outRect.set(0,0,dividerHeight,0);
            Log.e(TAG, "position: " + position+ "isLastColum: " + isLastColum(position, spanCount));
        }else{
            outRect.set(0,0,dividerHeight,dividerHeight);
        }






    }

    private boolean isLastColum(int position, int spanCount) {
        return (position+1)%spanCount==0;
    }

    private boolean isLastRow(int position, int spanCount, int lastRow) {
        return (position + 1) / spanCount == lastRow;
    }


}

package com.besome.sketch.editor.view.item;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

import com.besome.sketch.beans.ViewBean;
import com.sketchware.remod.R;

import a.a.a.sy;
import a.a.a.wB;

public class ItemProgressBar extends LinearLayout implements sy {

    public ViewBean a;
    public boolean b;
    public boolean c;
    public Paint d;
    public float e;
    public ImageView f;

    public ItemProgressBar(Context var1) {
        super(var1);
        a(var1);
    }

    public void a(Context var1) {
        e = wB.a(var1, 1.0F);
        d = new Paint(Paint.ANTI_ALIAS_FLAG);
        d.setColor(0x9599d5d0);
        setDrawingCacheEnabled(true);
        f = new ImageView(getContext());
        LinearLayout.LayoutParams var2 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        f.setLayoutParams(var2);
        f.setImageResource(R.drawable.progressbar_circle_48dp);
        f.setScaleType(ScaleType.FIT_XY);
        f.setPadding(0, 0, 0, 0);
        addView(f);
        setGravity(Gravity.CENTER);
    }

    public ViewBean getBean() {
        return a;
    }

    public boolean getFixed() {
        return c;
    }

    public boolean getSelection() {
        return b;
    }

    public void onDraw(Canvas var1) {
        if (b) {
            var1.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), d);
        }
        super.onDraw(var1);
    }

    public void setBean(ViewBean var1) {
        a = var1;
    }

    public void setFixed(boolean var1) {
        c = var1;
    }

    public void setPadding(int var1, int var2, int var3, int var4) {
        float var5 = (float) var1;
        float var6 = e;
        super.setPadding((int) (var5 * var6), (int) ((float) var2 * var6), (int) ((float) var3 * var6), (int) ((float) var4 * var6));
    }

    public void setProgressBarStyle(String var1) {
        if ("?android:progressBarStyle".equals(var1)) {
            f.setImageResource(R.drawable.progressbar_circle_48dp);
            f.getLayoutParams().width = (int) (e * 30F);
            f.getLayoutParams().height = (int) (e * 30F);
        } else if ("?android:progressBarStyleHorizontal".equals(var1)) {
            f.setImageResource(R.drawable.progressbar_horizontal_48dp);
            f.getLayoutParams().width = (int) (e * 320F);
            f.getLayoutParams().height = (int) (e * 30F);
        }
    }

    public void setSelection(boolean var1) {
        b = var1;
        invalidate();
    }
}

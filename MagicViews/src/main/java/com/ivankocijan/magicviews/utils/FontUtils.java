package com.ivankocijan.magicviews.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ivankocijan.magicviews.MagicViews;
import com.ivankocijan.magicviews.R;

/**
 * Created by ivankocijan on 18.05.2014..
 */
public class FontUtils {

    public static void setTypeface (Context ctx, AttributeSet attrs, TextView view) {


        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.MagicTextView);
        String fontStyle = a.getString(R.styleable.MagicTextView_typeFace);
        view.setTypeface(MagicViews.getTypeface(ctx, fontStyle));
        a.recycle();

    }

}

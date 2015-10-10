package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.MagicFont;
import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.utils.MagicUtils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 11/10/15
 */
class AttrsUtils {

    /**
     * Set's attributes to TextView if they exist
     */
    public static void setAttributes(Context ctx, AttributeSet attrs, TextView view) {

        if (attrs != null && ctx != null && view != null) {

            TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.MagicFont);
            String fontStyle = a.getString(R.styleable.MagicFont_typeFace);
            float letterSpacing = a.getFloat(R.styleable.MagicFont_letter_spacing, 0);

            if (fontStyle != null) {
                view.setTypeface(MagicFont.getInstance(ctx).getTypeface(ctx, fontStyle));
            }

            if (letterSpacing != 0) {
                MagicUtils.addLetterSpacing(letterSpacing, view);
            }

            a.recycle();

        }

    }

}

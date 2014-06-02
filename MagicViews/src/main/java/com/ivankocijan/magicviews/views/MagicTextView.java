package com.ivankocijan.magicviews.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ivankocijan.magicviews.utils.FontUtils;

/**
 * Created by ivankocijan on 17.05.2014.
 */
public class MagicTextView extends TextView {

    public MagicTextView (Context context) {
        super(context);
        init(context, null);
    }

    public MagicTextView (Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            init(context, attrs);
        }
    }

    public MagicTextView (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode()) {
            init(context, attrs);
        }
    }


    private void init (Context ctx, AttributeSet attrs) {

        FontUtils.setTypeface(ctx, attrs, this);

    }

}



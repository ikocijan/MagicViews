package com.ivankocijan.magicviews.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.ivankocijan.magicviews.utils.FontUtils;

/**
 * Created by ivankocijan on 18.05.2014..
 */
public class MagicButton extends Button {

    public MagicButton (Context context) {
        super(context);
    }

    public MagicButton (Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            init(context, attrs);
        }

    }

    public MagicButton (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode()) {
            init(context, attrs);
        }

    }

    private void init (Context ctx, AttributeSet attrs) {

        FontUtils.setTypeface(ctx, attrs, this);

    }
}

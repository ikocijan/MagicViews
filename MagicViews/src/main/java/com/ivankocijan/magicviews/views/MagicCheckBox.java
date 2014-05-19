package com.ivankocijan.magicviews.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.ivankocijan.magicviews.utils.FontUtils;

/**
 * Created by ivankocijan on 19.05.2014..
 */
public class MagicCheckBox extends CheckBox {

    public MagicCheckBox (Context context) {
        super(context);
    }

    public MagicCheckBox (Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            init(context, attrs);
        }

    }

    public MagicCheckBox (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode()) {
            init(context, attrs);
        }

    }

    private void init (Context ctx, AttributeSet attrs) {

        FontUtils.setTypeface(ctx, attrs, this);

    }
}

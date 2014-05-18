package com.ivankocijan.magicviews.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.ivankocijan.magicviews.utils.FontUtils;

/**
 * Created by ivankocijan on 18.05.2014..
 */
public class MagicEditText extends EditText {

    public MagicEditText (Context context) {
        super(context);
    }

    public MagicEditText (Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            init(context, attrs);
        }

    }

    public MagicEditText (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            init(context, attrs);
        }
    }

    private void init (Context ctx, AttributeSet attrs) {

        FontUtils.setTypeface(ctx, attrs, this);

    }

}

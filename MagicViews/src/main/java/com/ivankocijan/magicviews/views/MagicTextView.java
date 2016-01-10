package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.interfaces.MagicView;
import com.ivankocijan.magicviews.utils.FontUtils;
import com.ivankocijan.magicviews.utils.AttrsUtils;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by ivankocijan on 17.05.2014.
 */
public class MagicTextView extends AppCompatTextView implements MagicView {


    public MagicTextView(Context context) {
        this(context, null);
    }

    public MagicTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MagicTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode()) {
            init(attrs);
        }
    }

    private void init(AttributeSet attrs) {
        AttrsUtils.setAttributes(getContext(), attrs, this);
    }

    @Override
    public void setFont(String fontName) {
        FontUtils.setTypeface(getContext(), fontName, this);
    }
}



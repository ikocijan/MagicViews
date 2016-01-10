package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.interfaces.MagicView;
import com.ivankocijan.magicviews.utils.FontUtils;
import com.ivankocijan.magicviews.utils.AttrsUtils;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

/**
 * Created by ivankocijan on 19.05.2014.
 */
public class MagicCheckBox extends AppCompatCheckBox implements MagicView {

    public MagicCheckBox(Context context) {
        this(context, null);
    }

    public MagicCheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.checkboxStyle);
    }

    public MagicCheckBox(Context context, AttributeSet attrs, int defStyle) {
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

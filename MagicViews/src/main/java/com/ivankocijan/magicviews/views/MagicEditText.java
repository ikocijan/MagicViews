package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.interfaces.MagicView;
import com.ivankocijan.magicviews.utils.FontUtils;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by ivankocijan on 18.05.2014..
 */
public class MagicEditText extends AppCompatEditText implements MagicView {

    public MagicEditText(Context context) {
        this(context, null);
    }

    public MagicEditText(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.editTextStyle);
    }

    public MagicEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode()) {
            init(attrs);
        }
    }

    private void init(AttributeSet attrs) {

        FontUtils.setTypeface(getContext(), attrs, this);

    }

    @Override
    public void setFont(String fontName) {
        FontUtils.setTypeface(getContext(), fontName, this);

    }

}

package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.interfaces.MagicView;
import com.ivankocijan.magicviews.utils.FontUtils;
import com.ivankocijan.magicviews.utils.AttrsUtils;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by ivankocijan on 18.05.2014..
 */
public class MagicButton extends AppCompatButton implements MagicView {

    public MagicButton(Context context) {
        this(context, null);
    }

    public MagicButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.buttonStyle);

    }

    public MagicButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);

    }

    private void init(AttributeSet attrs) {
        if (!isInEditMode()) {
            AttrsUtils.setAttributes(getContext(), attrs, this);
        }

    }

    @Override
    public void setFont(String fontName) {
        if (!isInEditMode()) {
            FontUtils.setTypeface(getContext(), fontName, this);
        }
    }

}

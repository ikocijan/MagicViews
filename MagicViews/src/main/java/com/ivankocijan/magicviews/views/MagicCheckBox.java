package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.FontView;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

/**
 * Created by ivankocijan on 19.05.2014.
 */
public class MagicCheckBox extends AppCompatCheckBox implements FontView {

    private MagicViewDelegate delegate;

    public MagicCheckBox(Context context) {
        this(context, null);
    }

    public MagicCheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.checkboxStyle);
    }

    public MagicCheckBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (!isInEditMode()) {
            delegate = new MagicViewDelegate(this);
            delegate.setAttributes(attrs);
        }
    }

    @Override
    public void setFont(String fontName) {
        delegate.setFont(fontName);
    }

    @Override
    public void setCharacterSpacing(float characterSpacing) {
        delegate.setCharacterSpacing(characterSpacing);
    }

}

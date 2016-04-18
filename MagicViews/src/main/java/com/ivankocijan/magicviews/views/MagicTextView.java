package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.FontView;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by ivankocijan on 17.05.2014.
 */
public class MagicTextView extends AppCompatTextView implements FontView {

    private MagicViewDelegate delegate;

    public MagicTextView(Context context) {
        this(context, null);
    }

    public MagicTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MagicTextView(Context context, AttributeSet attrs, int defStyle) {
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



package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.TypefaceView;

import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 23.05.15.
 */
public class MagicRadioButton extends AppCompatRadioButton implements TypefaceView {

    private MagicViewDelegate delegate;

    public MagicRadioButton(Context context) {
        this(context, null);
    }

    public MagicRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.radioButtonStyle);
    }

    public MagicRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (!isInEditMode()) {
            delegate = new MagicViewDelegate(this);
            delegate.setAttributes(attrs);
        }
    }

    @Override
    public void setTypeface(String typeFaceName) {
        delegate.setTypeface(typeFaceName);
    }

    @Override
    public void setCharacterSpacing(float characterSpacing) {
        delegate.setCharacterSpacing(characterSpacing);
    }
}

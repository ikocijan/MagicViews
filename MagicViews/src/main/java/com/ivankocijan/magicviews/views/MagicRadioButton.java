package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.interfaces.MagicView;
import com.ivankocijan.magicviews.utils.FontUtils;
import com.ivankocijan.magicviews.utils.AttrsUtils;

import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 23.05.15.
 */
public class MagicRadioButton extends AppCompatRadioButton implements MagicView {

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

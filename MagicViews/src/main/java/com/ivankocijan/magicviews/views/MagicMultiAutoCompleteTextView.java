package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.interfaces.MagicView;
import com.ivankocijan.magicviews.utils.FontUtils;

import android.content.Context;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.util.AttributeSet;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 23.05.15.
 */
public class MagicMultiAutoCompleteTextView extends AppCompatMultiAutoCompleteTextView implements MagicView {

    public MagicMultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public MagicMultiAutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.autoCompleteTextViewStyle);
    }

    public MagicMultiAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        AttrsUtils.setAttributes(getContext(), attrs, this);

    }

    @Override
    public void setFont(String fontName) {
        FontUtils.setTypeface(getContext(), fontName, this);

    }


}

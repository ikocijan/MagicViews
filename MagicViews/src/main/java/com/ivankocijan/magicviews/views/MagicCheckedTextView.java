package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.utils.FontUtils;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.util.AttributeSet;

/**
 * Created by ivankocijan on 19.05.2014..
 */
public class MagicCheckedTextView extends AppCompatCheckedTextView {

    public MagicCheckedTextView(Context context) {
        this(context, null);
    }

    public MagicCheckedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.checkedTextViewStyle);
    }

    public MagicCheckedTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode()) {
            init(context, attrs);
        }

    }


    private void init(Context ctx, AttributeSet attrs) {

        FontUtils.setTypeface(ctx, attrs, this);

    }

}

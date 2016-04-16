package com.ivankocijan.TestApp.views;

import com.ivankocijan.TestApp.R;
import com.ivankocijan.magicviews.views.MagicTextView;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;


public class CustomFrameLayout extends FrameLayout {

    public CustomFrameLayout(Context context) {
        super(context);
        init(context);
    }

    public CustomFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_custom_frame_layout, this, true);
        final MagicTextView magicTextView = (MagicTextView) getChildAt(0);
        // font is added dynamically through code
        // preview of this view should still be valid
        magicTextView.setTypeface("galaxyfaraway.ttf");
    }
}

package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.interfaces.MagicView;
import com.ivankocijan.magicviews.utils.FontUtils;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 11/10/15
 */
public class MagicTabLayout extends TabLayout implements MagicView {

    private String fontName;

    public MagicTabLayout(Context context) {
        this(context, null);
    }

    public MagicTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MagicTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    private void init(AttributeSet attrs) {
        // Nothing for now
    }

    @Override
    public void setFont(String fontName) {

        ViewGroup tabLayoutViewGroup = (ViewGroup) this.getChildAt(0);
        int tabsCount = tabLayoutViewGroup.getChildCount();

        for (int j = 0; j < tabsCount; j++) {

            ViewGroup tabViewGroup = (ViewGroup) tabLayoutViewGroup.getChildAt(j);
            int tabChildCount = tabViewGroup.getChildCount();

            for (int i = 0; i < tabChildCount; i++) {
                View tabViewChild = tabViewGroup.getChildAt(i);

                if (tabViewChild instanceof TextView) {
                    FontUtils.setTypeface(getContext(), fontName, (TextView) tabViewChild);
                }
            }
        }


    }
}

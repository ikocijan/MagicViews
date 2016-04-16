package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.interfaces.MagicView;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 11/10/15
 */
public class MagicTabLayout extends TabLayout implements MagicView {

    private Field tabViewField;
    private List<MagicViewDelegate> delegates = new ArrayList<>();
    private String childrenTypeFace;
    private float childrenLetterSpacing;

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
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MagicTabLayout);
            this.childrenTypeFace = a.getString(R.styleable.MagicTabLayout_childrenTypeFace);
            this.childrenLetterSpacing = a.getFloat(R.styleable.MagicTabLayout_childrenLetterSpacing, 0);
            a.recycle();
        }
    }

    private void createDelegate(TextView textView) {
        MagicViewDelegate delegate = new MagicViewDelegate(textView);
        delegate.setTypeface(this.childrenTypeFace);
        delegate.setLetterSpacing(this.childrenLetterSpacing);
        delegates.add(delegate);
    }

    @Override
    public void setTypeface(String typeFaceName) {
        for (int i = 0; i < delegates.size(); i++) {
            delegates.get(i).setTypeface(typeFaceName);
        }
    }

    @Override
    public void addTab(@NonNull Tab tab, boolean setSelected) {
        super.addTab(tab, setSelected);

        LinearLayout tabView = null;
        try {
            if (tabViewField == null) {
                tabViewField = tab.getClass().getDeclaredField("mView");
                tabViewField.setAccessible(true);
            }
            tabView = (LinearLayout) tabViewField.get(tab);
        } catch (Exception e) {
            Log.w(this.getClass().getSimpleName(),
                    "Could not reflect private tab field mView.");
        }

        if (tabView != null) {
            for (int i = 0; i < tabView.getChildCount(); i++) {
                final View child = tabView.getChildAt(i);
                if (child instanceof TextView) {
                    createDelegate((TextView) child);
                }
            }
        }
    }
}

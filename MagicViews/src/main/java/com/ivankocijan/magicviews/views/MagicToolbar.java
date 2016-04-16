package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.interfaces.MagicView;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jmarkovic on 16/04/16.
 */
public class MagicToolbar extends Toolbar implements MagicView {

    private SparseArray<MagicViewDelegate> delegates = new SparseArray<>();
    private String titleTypeFace, subtitleTypeFace;
    private float titleLetterSpacing, subtitleLetterSpacing;

    public MagicToolbar(Context context) {
        this(context, null);
    }

    public MagicToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.toolbarStyle);
    }

    public MagicToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MagicToolbar);
            this.titleTypeFace = a.getString(R.styleable.MagicToolbar_titleTypeFace);
            this.titleLetterSpacing = a.getFloat(R.styleable.MagicToolbar_titleLetterSpacing, 0);
            this.subtitleTypeFace = a.getString(R.styleable.MagicToolbar_subtitleTypeFace);
            this.subtitleLetterSpacing = a.getFloat(R.styleable.MagicToolbar_subtitleLetterSpacing, 0);
            a.recycle();
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);

        MagicViewDelegate delegate = delegates.get(R.id.tv_toolbar_title);
        if (delegate == null) {
            final int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View childView = getChildAt(i);
                if (childView instanceof TextView
                        && ((TextView) childView).getText().toString().equals(title)) {
                    childView.setId(R.id.tv_toolbar_title);
                    delegate = new MagicViewDelegate((TextView) childView);
                    delegates.put(R.id.tv_toolbar_title, delegate);
                }
            }
        }
        if (delegate != null) {
            delegate.setTypeface(this.titleTypeFace);
            delegate.setLetterSpacing(this.titleLetterSpacing);
        }
    }

    @Override
    public void setSubtitle(CharSequence subtitle) {
        super.setSubtitle(subtitle);

        MagicViewDelegate delegate = delegates.get(R.id.tv_toolbar_subtitle);
        if (delegate == null) {
            final int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View childView = getChildAt(i);
                if (childView instanceof TextView
                        && ((TextView) childView).getText().toString().equals(subtitle)) {
                    childView.setId(R.id.tv_toolbar_subtitle);
                    delegate = new MagicViewDelegate((TextView) childView);
                    delegates.put(R.id.tv_toolbar_subtitle, delegate);
                }
            }
        }
        if (delegate != null) {
            delegate.setTypeface(this.subtitleTypeFace);
            delegate.setLetterSpacing(this.subtitleLetterSpacing);
        }
    }

    @Override
    public void setTypeface(String typeFaceName) {
        setTitleTypeFace(typeFaceName);
        setSubtitleTypeFace(typeFaceName);
    }

    public void setTitleTypeFace(String titleTypeFace) {
        this.titleTypeFace = titleTypeFace;
        final MagicViewDelegate delegate = delegates.get(R.id.tv_toolbar_title);
        if (delegate != null) {
            delegate.setTypeface(titleTypeFace);
        }
    }

    public void setSubtitleTypeFace(String subtitleTypeFace) {
        this.subtitleTypeFace = subtitleTypeFace;
        final MagicViewDelegate delegate = delegates.get(R.id.tv_toolbar_subtitle);
        if (delegate != null) {
            delegate.setTypeface(subtitleTypeFace);
        }
    }

    public void setTitleLetterSpacing(float titleLetterSpacing) {
        this.titleLetterSpacing = titleLetterSpacing;
        final MagicViewDelegate delegate = delegates.get(R.id.tv_toolbar_title);
        if (delegate != null) {
            delegate.setLetterSpacing(titleLetterSpacing);
        }
    }

    public void setSubtitleLetterSpacing(float subtitleLetterSpacing) {
        this.subtitleLetterSpacing = subtitleLetterSpacing;
        final MagicViewDelegate delegate = delegates.get(R.id.tv_toolbar_subtitle);
        if (delegate != null) {
            delegate.setLetterSpacing(subtitleLetterSpacing);
        }
    }
}

package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.FontView;

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
public class MagicToolbar extends Toolbar implements FontView {

    private SparseArray<MagicViewDelegate> delegates = new SparseArray<>();
    private String titleFontName, subtitleFontName;
    private float titleCharacterSpacing, subtitleCharacterSpacing;

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
            this.titleFontName = a.getString(R.styleable.MagicToolbar_titleFont);
            this.titleCharacterSpacing = a.getFloat(R.styleable.MagicToolbar_titleCharacterSpacing, 0);
            this.subtitleFontName = a.getString(R.styleable.MagicToolbar_subtitleFont);
            this.subtitleCharacterSpacing = a.getFloat(R.styleable.MagicToolbar_subtitleCharacterSpacing, 0);
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
            delegate.setFont(this.titleFontName);
            delegate.setCharacterSpacing(this.titleCharacterSpacing);
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
            delegate.setFont(this.subtitleFontName);
            delegate.setCharacterSpacing(this.subtitleCharacterSpacing);
        }
    }

    @Override
    public void setFont(String fontName) {
        setTitleFont(fontName);
        setSubtitleFont(fontName);
    }

    @Override
    public void setCharacterSpacing(float characterSpacing) {
        setTitleCharacterSpacing(characterSpacing);
        setSubtitleCharacterSpacing(characterSpacing);
    }

    public void setTitleFont(String fontName) {
        this.titleFontName = fontName;
        final MagicViewDelegate delegate = delegates.get(R.id.tv_toolbar_title);
        if (delegate != null) {
            delegate.setFont(fontName);
        }
    }

    public void setSubtitleFont(String subtitleFont) {
        this.subtitleFontName = subtitleFont;
        final MagicViewDelegate delegate = delegates.get(R.id.tv_toolbar_subtitle);
        if (delegate != null) {
            delegate.setFont(subtitleFont);
        }
    }

    public void setTitleCharacterSpacing(float titleCharacterSpacing) {
        this.titleCharacterSpacing = titleCharacterSpacing;
        final MagicViewDelegate delegate = delegates.get(R.id.tv_toolbar_title);
        if (delegate != null) {
            delegate.setCharacterSpacing(titleCharacterSpacing);
        }
    }

    public void setSubtitleCharacterSpacing(float subtitleCharacterSpacing) {
        this.subtitleCharacterSpacing = subtitleCharacterSpacing;
        final MagicViewDelegate delegate = delegates.get(R.id.tv_toolbar_subtitle);
        if (delegate != null) {
            delegate.setCharacterSpacing(subtitleCharacterSpacing);
        }
    }
}

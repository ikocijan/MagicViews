package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.TypefaceView;

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
public class MagicToolbar extends Toolbar implements TypefaceView {

    private SparseArray<MagicViewDelegate> delegates = new SparseArray<>();
    private String titleTypeFace, subtitleTypeFace;
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
            this.titleTypeFace = a.getString(R.styleable.MagicToolbar_titleTypeFace);
            this.titleCharacterSpacing = a.getFloat(R.styleable.MagicToolbar_titleCharacterSpacing, 0);
            this.subtitleTypeFace = a.getString(R.styleable.MagicToolbar_subtitleTypeFace);
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
            delegate.setTypeface(this.titleTypeFace);
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
            delegate.setTypeface(this.subtitleTypeFace);
            delegate.setCharacterSpacing(this.subtitleCharacterSpacing);
        }
    }

    @Override
    public void setTypeface(String typeFaceName) {
        setTitleTypeFace(typeFaceName);
        setSubtitleTypeFace(typeFaceName);
    }

    @Override
    public void setCharacterSpacing(float characterSpacing) {
        setTitleCharacterSpacing(characterSpacing);
        setSubtitleCharacterSpacing(characterSpacing);
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

package com.ivankocijan.magicviews.utils;

import com.ivankocijan.magicviews.MagicFont;
import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.enums.PreferenceType;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by ivankocijan on 18.05.2014..
 */
public class FontUtils {

    /**
     * Set's typface on view
     */
    public static void setTypeface(Context ctx, AttributeSet attrs, TextView view) {

        if (attrs != null && ctx != null && view != null) {

            TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.MagicFont);
            String fontStyle = a.getString(R.styleable.MagicFont_typeFace);

            if (fontStyle != null) {
                view.setTypeface(MagicFont.getInstance(ctx).getTypeface(ctx, fontStyle));
            }

            a.recycle();

        }

    }

    /**
     * Set's font style for custom preference
     */
    public static void setPreferenceTypeface(Context ctx, String fontStyle, TextView... views) {

        if (fontStyle != null) {

            for (TextView view : views) {

                view.setTypeface(MagicFont.getInstance(ctx).getTypeface(ctx, fontStyle));

            }

        }

    }

    /**
     * Returns font style from attribute set
     */
    public static String getPrefFontStyle(Context ctx, AttributeSet attrs, PreferenceType type) {

        switch (type) {
            case SIMPLE_PREFERENCE:
                TypedArray simple = ctx.obtainStyledAttributes(attrs, R.styleable.MagicPreference);
                return simple.getString(R.styleable.MagicPreference_prefTypeface);

            case SWITCH_PREFERENCE:

                TypedArray switchPref = ctx.obtainStyledAttributes(attrs, R.styleable.MagicSwitchPreference);
                return switchPref.getString(R.styleable.MagicSwitchPreference_switchPrefTypeface);

            case CHECKBOX_PREFERENCE:
                TypedArray checkBox = ctx.obtainStyledAttributes(attrs, R.styleable.MagicCheckBoxPreference);
                return checkBox.getString(R.styleable.MagicCheckBoxPreference_checkBoxTypeface);
            case PREFERENCE_GROUP:
                TypedArray prefGroup = ctx.obtainStyledAttributes(attrs, R.styleable.MagicPreferenceGroup);
                return prefGroup.getString(R.styleable.MagicPreferenceGroup_preferenceGroupTypeface);
            case EDIT_TEXT_PREFERENCE:
                TypedArray editText = ctx.obtainStyledAttributes(attrs, R.styleable.MagicEditTextPreference);
                return editText.getString(R.styleable.MagicEditTextPreference_editTextTypeface);
            default:
                return "";
        }

    }

}

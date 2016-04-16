package com.ivankocijan.magicviews.utils;

import com.ivankocijan.magicviews.MagicTypeface;
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

    private FontUtils() {
    }

    /**
     * Set's font style for custom preference
     */
    public static void setPreferenceTypeface(Context ctx, String fontStyle, TextView... views) {

        if (fontStyle != null) {

            for (TextView view : views) {

                view.setTypeface(MagicTypeface.INSTANCE.getTypeface(fontStyle));

            }

        }

    }

    /**
     * Returns font style from attribute set
     */
    public static String getPrefFontStyle(Context ctx, AttributeSet attrs, PreferenceType type) {

        String fontStyle = "";

        if (attrs == null) {
            return fontStyle;
        }

        switch (type) {
            case SIMPLE_PREFERENCE:
                TypedArray simple = ctx.obtainStyledAttributes(attrs, R.styleable.MagicPreference);
                fontStyle = simple.getString(R.styleable.MagicPreference_prefTypeface);
                simple.recycle();
                break;

            case SWITCH_PREFERENCE:
                TypedArray switchPref = ctx.obtainStyledAttributes(attrs, R.styleable.MagicSwitchPreference);
                fontStyle = switchPref.getString(R.styleable.MagicSwitchPreference_switchPrefTypeface);
                switchPref.recycle();
                break;

            case CHECKBOX_PREFERENCE:
                TypedArray checkBox = ctx.obtainStyledAttributes(attrs, R.styleable.MagicCheckBoxPreference);
                fontStyle = checkBox.getString(R.styleable.MagicCheckBoxPreference_checkBoxTypeface);
                checkBox.recycle();
                break;

            case PREFERENCE_GROUP:
                TypedArray prefGroup = ctx.obtainStyledAttributes(attrs, R.styleable.MagicPreferenceGroup);
                fontStyle = prefGroup.getString(R.styleable.MagicPreferenceGroup_preferenceGroupTypeface);
                prefGroup.recycle();
                break;

            case EDIT_TEXT_PREFERENCE:
                TypedArray editText = ctx.obtainStyledAttributes(attrs, R.styleable.MagicEditTextPreference);
                fontStyle = editText.getString(R.styleable.MagicEditTextPreference_editTextTypeface);
                editText.recycle();
                return fontStyle;

            default:
                return fontStyle;
        }

        return fontStyle;

    }

}

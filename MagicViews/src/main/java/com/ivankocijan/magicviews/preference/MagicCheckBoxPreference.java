package com.ivankocijan.magicviews.preference;

import com.ivankocijan.magicviews.enums.PreferenceType;
import com.ivankocijan.magicviews.utils.FontUtils;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ivankocijan on 22.05.2014..
 */
public class MagicCheckBoxPreference extends CheckBoxPreference {

    private String fontStyle;

    public MagicCheckBoxPreference(Context context) {
        this(context, null);
    }

    public MagicCheckBoxPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MagicCheckBoxPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        fontStyle = FontUtils.getPrefFontStyle(getContext(), attrs, PreferenceType.CHECKBOX_PREFERENCE);

    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);

        TextView titleView = (TextView) view.findViewById(android.R.id.title);
        TextView summary = (TextView) view.findViewById(android.R.id.summary);

        if (titleView != null && getContext() != null) {
            FontUtils.setPreferenceTypeface(getContext(), fontStyle, titleView, summary);
        }


    }


}

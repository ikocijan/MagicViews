package com.ivankocijan.magicviews.preference;

import com.ivankocijan.magicviews.enums.PreferenceType;
import com.ivankocijan.magicviews.utils.FontUtils;

import android.content.Context;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ivankocijan on 23.05.2014..
 */
public class MagicEditTextPreference extends EditTextPreference {

    private String fontStyle;

    public MagicEditTextPreference(Context context) {
        this(context, null);
    }

    public MagicEditTextPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MagicEditTextPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }


    private void init(Context ctx, AttributeSet attrs) {

        fontStyle = FontUtils.getPrefFontStyle(ctx, attrs, PreferenceType.EDIT_TEXT_PREFERENCE);

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

package com.ivankocijan.magicviews.preference;

import com.ivankocijan.magicviews.enums.PreferenceType;
import com.ivankocijan.magicviews.utils.FontUtils;

import android.content.Context;
import android.preference.SwitchPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ivankocijan on 22.05.2014..
 */
public class MagicSwitchPreference extends SwitchPreference {

    private String fontStyle;

    public MagicSwitchPreference(Context context) {
        this(context, null);
    }


    public MagicSwitchPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MagicSwitchPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }


    private void init(Context ctx, AttributeSet attrs) {

        fontStyle = FontUtils.getPrefFontStyle(ctx, attrs, PreferenceType.SWITCH_PREFERENCE);

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

package com.ivankocijan.magicviews.preference;

import com.ivankocijan.magicviews.enums.PreferenceType;
import com.ivankocijan.magicviews.utils.FontUtils;

import android.content.Context;
import android.preference.PreferenceGroup;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ivankocijan on 23.05.2014..
 */
public class MagicPreferenceGroup extends PreferenceGroup {

    private String fontStyle;

    public MagicPreferenceGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MagicPreferenceGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }


    private void init(Context ctx, AttributeSet attrs) {

        fontStyle = FontUtils.getPrefFontStyle(ctx, attrs, PreferenceType.PREFERENCE_GROUP);

    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);

        TextView titleView = (TextView) view.findViewById(android.R.id.title);
        TextView summary = (TextView) view.findViewById(android.R.id.summary);

        if (titleView != null && summary != null && getContext() != null) {
            FontUtils.setPreferenceTypeface(getContext(), fontStyle, titleView, summary);
        }

    }

}

package com.ivankocijan.magicviews.preference;

import android.content.Context;
import android.preference.PreferenceGroup;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.ivankocijan.magicviews.enums.PreferenceType;
import com.ivankocijan.magicviews.utils.FontUtils;

/**
 * Created by ivankocijan on 23.05.2014..
 */
public class MagicPreferenceGroup extends PreferenceGroup {

    private Context context;
    private String fontStyle;

    public MagicPreferenceGroup (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public MagicPreferenceGroup (Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init (Context ctx, AttributeSet attrs) {

        this.context = ctx;
        fontStyle = FontUtils.getPrefFontStyle(ctx, attrs, PreferenceType.PREFERENCE_GROUP);

    }

    @Override
    protected void onBindView (View view) {
        super.onBindView(view);

        TextView titleView = (TextView) view.findViewById(android.R.id.title);
        TextView summary = (TextView) view.findViewById(android.R.id.summary);

        if (titleView != null && summary != null && context != null) {
            FontUtils.setPreferenceTypeface(context, fontStyle, titleView, summary);
        }

    }

}

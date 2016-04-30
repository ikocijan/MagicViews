package co.infinum.magicapp.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import co.infinum.magicapp.R;

/**
 * Custom Layout used to demonstrate that any MagicView
 * can be used and preview will continue to work.
 */
public class CustomView extends LinearLayout {

    public CustomView(Context context) {
        super(context);
        init(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        final int padding = context.getResources().getDimensionPixelSize(R.dimen.padding_16);
        setPadding(padding, padding, padding, padding);
        setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimaryTransparent));

        LayoutInflater.from(context).inflate(R.layout.layout_custom_view, this, true);
    }
}

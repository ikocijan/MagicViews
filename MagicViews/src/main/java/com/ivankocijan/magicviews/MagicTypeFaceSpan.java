package com.ivankocijan.magicviews;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/**
 * Changes the font of the text to which the span is attached.
 *
 * @author Josip Marković
 */
public class MagicTypeFaceSpan extends TypefaceSpan {

    public static final float ITALIC_SKEW = -0.25f;

    private final Typeface typeface;

    public MagicTypeFaceSpan(String typeface) {
        super("");
        this.typeface = MagicTypeface.INSTANCE.getTypeface(typeface);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        apply(ds);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        apply(paint);
    }

    private void apply(final Paint paint) {
        final Typeface oldTypeface = paint.getTypeface();
        final int oldStyle = oldTypeface != null ? oldTypeface.getStyle() : 0;
        final int fakeStyle = oldStyle & ~typeface.getStyle();

        if ((fakeStyle & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }

        if ((fakeStyle & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(ITALIC_SKEW);
        }

        paint.setTypeface(typeface);
    }
}

package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.MagicTypeface;
import com.ivankocijan.magicviews.MagicViews;
import com.ivankocijan.magicviews.R;

import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by jmarkovic on 15/04/16.
 */
class MagicViewDelegate {

    private static final String MATCH_ALL_CHARACTERS = "(.)";

    private static final String ADD_SPACE_TO_CHARACTER = "$1 ";

    private final TextView magicView;

    public MagicViewDelegate(@NonNull TextView magicView) {
        this.magicView = magicView;
    }

    /**
     * Set's attributes to TextView if they exist
     */
    public void setAttributes(AttributeSet attrs) {

        if (attrs != null) {
            TypedArray a = this.magicView.getContext().obtainStyledAttributes(attrs, R.styleable.MagicFont);
            String typeFace = a.getString(R.styleable.MagicFont_typeFace);
            float letterSpacing = a.getFloat(R.styleable.MagicFont_letter_spacing, 0);

            applyTypeface(typeFace);
            applyLetterSpacing(letterSpacing);

            a.recycle();
        }
    }

    public void setTypeface(@NonNull String typeFace) {
        if (TextUtils.isEmpty(typeFace)) {
            throw new RuntimeException("TypeFace must not be null or an empty string.");
        }

        this.magicView.setTypeface(MagicTypeface.INSTANCE.getTypeface(typeFace));
    }

    public void setLetterSpacing(float letterSpacing) {
        if (letterSpacing < 0) {
            throw new IllegalArgumentException("Value must be greater or equal to 0.");
        }

        applyLetterSpacing(letterSpacing);
    }

    private void applyTypeface(String typeFace) {
        if (typeFace == null) {
            typeFace = MagicViews.getDefaultTypeFace();

            if (typeFace == null) {
                return;
            }
        }

        this.magicView.setTypeface(MagicTypeface.INSTANCE.getTypeface(typeFace));
    }

    private void applyLetterSpacing(float letterSpacing) {
        if (letterSpacing != 0) {
            String originalText = this.magicView.getText().toString();

            if (originalText.length() > 1) {
                originalText = originalText.replaceAll(MATCH_ALL_CHARACTERS, ADD_SPACE_TO_CHARACTER);

                SpannableString finalText = new SpannableString(originalText);
                finalText.setSpan(new ScaleXSpan(letterSpacing), 0, originalText.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                this.magicView.setText(finalText, TextView.BufferType.SPANNABLE);
            }
        }
    }

}

package com.ivankocijan.magicviews.utils;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.widget.TextView;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 11/10/15
 */
public class MagicUtils {

    private static final String MATCH_ALL_CHARACTERS = "(.)";
    private static final String ADD_SPACE_TO_CHARACTER = "$1 ";

    public static void addLetterSpacing(float spacing, TextView textView) {

        if (textView != null) {

            String originalText = textView.getText().toString();

            if (originalText.length() > 1) {

                originalText = originalText.replaceAll(MATCH_ALL_CHARACTERS, ADD_SPACE_TO_CHARACTER);

                SpannableString finalText = new SpannableString(originalText);
                finalText.setSpan(new ScaleXSpan(spacing), 0, originalText.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                textView.setText(finalText, TextView.BufferType.SPANNABLE);

            }

        }

    }


}

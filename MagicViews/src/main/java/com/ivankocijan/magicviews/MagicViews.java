package com.ivankocijan.magicviews;

import android.content.Context;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 19.12.14.
 */
public class MagicViews {

    public static void setFontFolderPath (Context ctx, String fontFolderPath) {
        MagicFont.getInstance(ctx).setFontFolderPath(fontFolderPath);
    }

}

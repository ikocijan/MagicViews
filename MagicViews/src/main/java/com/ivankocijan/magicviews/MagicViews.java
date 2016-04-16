package com.ivankocijan.magicviews;

import android.content.res.AssetManager;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 19.12.14.
 */
public final class MagicViews {

    private static String defaultTypeFace;

    private MagicViews() {
        throw new AssertionError("Cannot be instantiated.");
    }

    public static void lazyInit(AssetManager am, String fontDirectoryPath) {
        if (am == null) {
            throw new RuntimeException("AssetManager must not be null.");
        }
        MagicTypeface.INSTANCE.setAssetManager(am);
        MagicTypeface.INSTANCE.setTypefaceDirectory(fontDirectoryPath);
    }

    public static void init(AssetManager am, String fontDirectoryPath) {

    }

    /**
     * @param typeFace a default typeface to use if no typeface is set
     */
    public static void setDefaultTypeFace(String typeFace) {
        if (MagicTypeface.INSTANCE.getTypeface(typeFace) != null) {
            defaultTypeFace = typeFace;
        } else {
            throw new RuntimeException(String.format(
                    "Could not find font %s to set as default font! Did you set the correct font folder path before setting default typeface?",
                    typeFace));
        }
    }

    public static String getDefaultTypeFace() {
        return defaultTypeFace;
    }
}

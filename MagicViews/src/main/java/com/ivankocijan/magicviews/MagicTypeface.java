package com.ivankocijan.magicviews;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by ivankocijan on 17.05.2014.
 */
public enum MagicTypeface {

    INSTANCE;

    private AssetManager assetManager;

    private final Hashtable<String, Typeface> fonts = new Hashtable<>();

    private String typefaceDirectoryPath = null;

    /**
     * Returns requested typeface. If this class is not initialized it will try to initialize it and return
     * requested font
     */
    public Typeface getTypeface(String typeface) {
        if (typefaceDirectoryPath == null || typefaceDirectoryPath.isEmpty()) {
            throw new MagicViewsNotInitializedException(
                    "Typeface directory path is empty. Please initialize MagicViews from your application class.");
        }

        if (!fonts.containsKey(typeface)) {
            MagicTypeface.INSTANCE.initializeFont(typeface);
        }

        return fonts.get(typeface);

    }

    protected void setTypefaceDirectory(String dirPath) {
        this.typefaceDirectoryPath = dirPath;
    }

    protected void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    /**
     * This method initializes font based on @typefaceDirectoryPath
     *
     * @param typeface typeface to set
     */
    private void initializeFont(String typeface) {
        String fontPath = typefaceDirectoryPath + "/" + typeface;

        //Font path can not start with / and it can not contain double slashes
        fontPath = fontPath.replaceAll("//", "/");
        if (fontPath.startsWith("/")) {
            fontPath = fontPath.substring(1, fontPath.length());
        }

        Typeface font = Typeface.createFromAsset(assetManager, fontPath);
        fonts.put(typeface, font);

    }


}

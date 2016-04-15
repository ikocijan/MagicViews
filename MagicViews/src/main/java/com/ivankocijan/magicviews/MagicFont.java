package com.ivankocijan.magicviews;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by ivankocijan on 17.05.2014.
 */
public enum MagicFont {

    INSTANCE;

    private AssetManager assetManager;

    private final Hashtable<String, Typeface> fonts = new Hashtable<>();

    private String fontDirectoryPath = null;

    /**
     * Returns requested typeface. If this class is not initialized it will try to initialize it and return
     * requested font
     */
    public Typeface getTypeface(String typeface) {

        if (fontDirectoryPath == null || fontDirectoryPath.isEmpty()) {
            throw new MagicViewsNotInitializedException(
                    "Font folder path is empty. Please call MagicViews.setFontFolderPath from your application class.");
        }

        if (!fonts.containsKey(typeface)) {
            MagicFont.INSTANCE.initializeFont(typeface);
        }

        return fonts.get(typeface);

    }

    protected void setFontDirectory(String dirPath) {
        this.fontDirectoryPath = dirPath;
    }

    protected void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    /**
     * This method initializes font based on @fontDirectoryPath
     *
     * @param typeface typeface to set
     */
    private void initializeFont(String typeface) {
        String fontPath = fontDirectoryPath + "/" + typeface;

        //Font path can not start with / and it can not contain double slashes
        fontPath = fontPath.replaceAll("//", "/");
        if (fontPath.startsWith("/")) {
            fontPath = fontPath.substring(1, fontPath.length());
        }

        Typeface font = Typeface.createFromAsset(assetManager, fontPath);
        fonts.put(typeface, font);

    }


}

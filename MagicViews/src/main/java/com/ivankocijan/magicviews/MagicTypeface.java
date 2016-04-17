package com.ivankocijan.magicviews;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;

import java.io.IOException;
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
        if (typefaceDirectoryPath == null) {
            throw new MagicViewsNotInitializedException(
                    "Typeface directory path is not set. Initialize MagicViews from your application class.");
        }

        if (!fonts.containsKey(typeface)) {
            MagicTypeface.INSTANCE.initializeFont(typeface);
        }

        return fonts.get(typeface);

    }

    protected void setTypefaceDirectory(String dirPath) {
        if (dirPath == null) {
            throw new RuntimeException("Font directory path must not be null.");
        }
        this.typefaceDirectoryPath = dirPath;
    }

    protected void setAssetManager(AssetManager assetManager) {
        if (this.assetManager != null) {
            throw new RuntimeException("MagicViews already initialized.");
        }
        this.assetManager = assetManager;
    }

    protected void initAll() throws IOException {
        String[] assets = assetManager.list(this.typefaceDirectoryPath);
        for (String asset : assets) {
            Log.d(this.getClass().getSimpleName(), "asset: -> " + asset);
            initializeFont(asset);
        }
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

package com.ivankocijan.magicviews;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;

import java.io.IOException;
import java.util.Hashtable;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 19.12.14.
 */
public enum MagicViews {

    INSTANCE;

    private AssetManager assetManager;
    private final Hashtable<String, Typeface> fonts = new Hashtable<>();
    private String typefaceDirectoryPath = null;
    private String defaultTypeFace;

    public static Initializer init(AssetManager am, String typefaceDirectoryPath) {
        if (am == null) {
            throw new RuntimeException("AssetManager must not be null.");
        }
        return new Initializer(am, typefaceDirectoryPath);
    }

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
            initializeFont(typeface);
        }

        return fonts.get(typeface);
    }

    public String getDefaultTypeFace() {
        return this.defaultTypeFace;
    }

    /**
     * @param typeFace a default typeface to use if no typeface is set
     */
    protected void setDefaultTypeFace(String typeFace) {
        if (getTypeface(typeFace) != null) {
            defaultTypeFace = typeFace;
        } else {
            throw new RuntimeException(String.format(
                    "Could not find font %s to set as default font! Did you set the correct font folder path before setting default typeface?",
                    typeFace));
        }
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

    public static class Initializer {

        Initializer(AssetManager am, String fontDirPath) {
            INSTANCE.setAssetManager(am);
            INSTANCE.setTypefaceDirectory(fontDirPath);
        }

        public Initializer all() {
            try {
                INSTANCE.initAll();
                return this;
            } catch (IOException e) {
                throw new MagicViewsNotInitializedException("MagicViews failed to initialize with IOException", e);
            }
        }

        public Initializer defaultFont(String defaultFont) {
            INSTANCE.setDefaultTypeFace(defaultFont);
            return this;
        }
    }
}

package com.ivankocijan.magicviews;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.util.ArrayMap;

import java.io.IOException;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 19.12.14.
 */
public enum MagicViews {

    INSTANCE;

    private AssetManager assetManager;
    private final ArrayMap<String, Typeface> fonts = new ArrayMap<>();
    private String fontDirectoryPath = null;
    private String defaultFontName;

    public static Initializer init(AssetManager am, String fontDirectoryPath) {
        if (am == null) {
            throw new RuntimeException("AssetManager must not be null.");
        }
        return new Initializer(am, fontDirectoryPath);
    }

    /**
     * Returns requested {@code font} as {@link Typeface}.
     */
    public Typeface getFont(String fontName) {
        if (fontDirectoryPath == null) {
            throw new MagicViewsNotInitializedException(
                    "Font directory path is not set. Initialize MagicViews from your application class.");
        }

        if (!fonts.containsKey(fontName)) {
            initializeFont(fontName);
        }

        return fonts.get(fontName);
    }

    public String getDefaultFontName() {
        return this.defaultFontName;
    }

    protected void setDefaultFontName(String fontName) {
        if (getFont(fontName) != null) {
            defaultFontName = fontName;
        } else {
            throw new RuntimeException(String.format(
                    "Could not find font %s to set as default font! Did you set the correct font folder path before setting default typeface?",
                    fontName));
        }
    }

    protected void setFontDirectory(String dirPath) {
        if (dirPath == null) {
            throw new RuntimeException("Font directory path must not be null.");
        }
        this.fontDirectoryPath = dirPath;
    }

    protected void setAssetManager(AssetManager assetManager) {
        if (this.assetManager != null) {
            throw new RuntimeException("MagicViews already initialized.");
        }
        this.assetManager = assetManager;
    }

    protected void initAll() throws IOException {
        String[] assets = assetManager.list(this.fontDirectoryPath);
        for (String asset : assets) {
            initializeFont(asset);
        }
    }

    /**
     * This method initializes font based on @fontDirectoryPath
     *
     * @param fontName fontName to set
     */
    private void initializeFont(String fontName) {
        String fontPath = fontDirectoryPath + "/" + fontName;

        //Font path can not start with / and it can not contain double slashes
        fontPath = fontPath.replaceAll("//", "/");
        if (fontPath.startsWith("/")) {
            fontPath = fontPath.substring(1, fontPath.length());
        }

        Typeface font = Typeface.createFromAsset(assetManager, fontPath);
        fonts.put(fontName, font);
    }

    public static class Initializer {

        Initializer(AssetManager am, String fontDirPath) {
            INSTANCE.setAssetManager(am);
            INSTANCE.setFontDirectory(fontDirPath);
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
            INSTANCE.setDefaultFontName(defaultFont);
            return this;
        }
    }
}

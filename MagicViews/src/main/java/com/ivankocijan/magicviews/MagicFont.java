package com.ivankocijan.magicviews;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by ivankocijan on 17.05.2014.
 */
public final class MagicFont {

    private AssetManager am;

    private String fontFolderPath = null;

    //list which contains all asset folders
    private ArrayList<String> assetFolders;

    //key = font name, value = fontPath
    private final Hashtable<String, Typeface> fonts = new Hashtable<>();

    private Context ctx;

    private static MagicFont magicFont;

    public MagicFont(Context context) {
        this.ctx = context;
    }

    public static MagicFont getInstance(Context context) {

        if (magicFont == null) {

            synchronized (MagicFont.class) {

                if (magicFont == null) {
                    magicFont = new MagicFont(context);
                }

            }

        }

        return magicFont;

    }

    private MagicFont() {
    }

    /**
     * This method initializes font based on @fontFolderPath
     *
     * @param typeface typeface to set
     */
    private void initializeFont(String typeface) {

        am = ctx.getResources().getAssets();

        String fontPath = fontFolderPath + "/" + typeface;

        //Font path can not start with / and it can not contain double slashes
        fontPath = fontPath.replaceAll("//", "/");
        if (fontPath.startsWith("/")) {
            fontPath = fontPath.substring(1, fontPath.length());
        }

        Typeface font = Typeface.createFromAsset(am, fontPath);
        fonts.put(typeface, font);

    }

    /**
     * Call this method to initialize app typefaces.
     *
     * @param typefaces typeface name. For example "cha_chicle.otf"
     * @deprecated use @initializeFont
     */
    @Deprecated
    private void initTypefaces(String... typefaces) {

        am = ctx.getResources().getAssets();

        if (assetFolders == null) {

            assetFolders = new ArrayList<>();
            assetFolders.add(""); //root folder also needs to be checked
            getAssetFolders("");

        }

        setUpFonts(typefaces);

    }


    /**
     * @deprecated not used anymore
     */
    @Deprecated
    private void setUpFonts(String... typefaces) {

        for (String typeface : typefaces) {

            boolean fontFound = findFontInAssets(typeface);

            if (!fontFound) {
                throw new FontNotFoundException("Font " + typeface + " not found");
            }

        }

    }

    /**
     * @return true if font is found
     * @deprecated not used anymore
     */
    @Deprecated
    private boolean findFontInAssets(String typeface) {

        try {

            List<String> mapList;

            for (String assetFolder : assetFolders) {

                mapList = Arrays.asList(am.list(assetFolder));

                if (mapList.contains(typeface)) {

                    String fontPath;

                    if (assetFolder.isEmpty()) {
                        fontPath = typeface;
                    } else {
                        fontPath = assetFolder + "/" + typeface;
                    }

                    Typeface font = Typeface.createFromAsset(am, fontPath);

                    fonts.put(typeface, font);

                    return true;

                }

            }


        } catch (IOException e) {

            return false;

        }

        return false;

    }

    /**
     * This method goes through all assets folders and adds them to @assetFolders object
     */
    private boolean getAssetFolders(String path) {

        String[] list;

        try {

            list = ctx.getResources().getAssets().list(path);

            if (list.length > 0) {

                // This is a folder
                for (String file : list) {
                    assetFolders.add(file);
                    if (!getAssetFolders(path + "/" + file)) {
                        return false;
                    }
                }
            }

        } catch (IOException e) {
            return false;
        }

        return true;
    }

    /**
     * Returns requested typeface. If this class is not initialized it will try to initialize it and return
     * requested font
     */
    public Typeface getTypeface(Context ctx, String typeface) {

        if (fontFolderPath == null || fontFolderPath.isEmpty()) {
            throw new MagicViewsNotInitializedException("Font folder path is empty. " +
                    "Have you called MagicViews.setFontFolderPath in your application class?");
        }

        if (!fonts.containsKey(typeface)) {
            MagicFont.getInstance(ctx).initializeFont(typeface);
        }

        return fonts.get(typeface);

    }

    public void setFontFolderPath(String path) {

        this.fontFolderPath = path;

    }


}

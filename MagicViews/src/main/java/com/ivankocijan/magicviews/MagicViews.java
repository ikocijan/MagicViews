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
public class MagicViews {


    private AssetManager am;

    //list which contains all asset folders
    private ArrayList<String> assetFolders;
    //key = font name, value = fontPath
    private static Hashtable<String, Typeface> fonts = new Hashtable<String, Typeface>();

    private static Context ctx;

    private static MagicViews magicViews;

    public static MagicViews getInstance (Context context) {

        if (magicViews == null) {
            magicViews = new MagicViews();
        }


        ctx = context;
        return magicViews;

    }

    /**
     * Call this method to initialize app typefaces.
     *
     * @param typefaces typeface name. For example "cha_chicle.otf"
     */
    public void initTypefaces (String... typefaces) {

        am = ctx.getResources().getAssets();

        if (assetFolders == null) {

            assetFolders = new ArrayList<String>();
            assetFolders.add(""); //root folder also needs to be checked
            getAssetFolders("");

        }


        setUpFonts(typefaces);

    }


    private void setUpFonts (String... typefaces) {

        for (String typeface : typefaces) {

            boolean fontFound = findFontInAssets(typeface);

            if (!fontFound) {
                throw new FontNotFoundException("Font " + typeface + " not found");
            }

        }

    }

    private boolean findFontInAssets (String typeface) {

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
     *
     * @param path
     * @return
     */
    private boolean getAssetFolders (String path) {

        String[] list;

        try {

            list = ctx.getResources().getAssets().list(path);

            if (list.length > 0) {

                // This is a folder
                for (String file : list) {
                    assetFolders.add(file);
                    if (!getAssetFolders(path + "/" + file))
                        return false;
                }
            }

        } catch (IOException e) {
            return false;
        }

        return true;
    }

    /**
     * Returns requested typeface. If this class is not initialized it will try to initialaze it and return
     * requested font
     *
     * @param ctx
     * @param typeface
     * @return
     */
    public static Typeface getTypeface (Context ctx, String typeface) {

        if (fonts == null || !fonts.containsKey(typeface)) {
            MagicViews.getInstance(ctx).initTypefaces(typeface);
        }

        return fonts.get(typeface);

    }


}

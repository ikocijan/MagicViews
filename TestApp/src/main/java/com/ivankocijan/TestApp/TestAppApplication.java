package com.ivankocijan.TestApp;

import android.app.Application;

import com.ivankocijan.magicviews.MagicViews;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 19.12.14.
 */
public class TestAppApplication extends Application {

    @Override
    public void onCreate () {
        super.onCreate();

        MagicViews.setFontFolderPath(this, "font");

    }
}

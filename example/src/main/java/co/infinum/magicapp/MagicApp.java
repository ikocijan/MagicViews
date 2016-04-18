package co.infinum.magicapp;

import com.ivankocijan.magicviews.MagicViews;

import android.app.Application;

/**
 * Created by jmarkovic on 16/04/16.
 */
public class MagicApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MagicViews.init(getAssets(), "fonts").defaultFont("Montserrat-Regular.ttf");
    }
}

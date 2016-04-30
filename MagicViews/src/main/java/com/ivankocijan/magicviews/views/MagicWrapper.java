package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.FontView;

import android.support.annotation.NonNull;
import android.widget.TextView;

/**
 * Created by jmarkovic on 20/04/16.
 */
public final class MagicWrapper {

    private MagicWrapper() {
        throw new AssertionError("Not instantiable");
    }

    @NonNull
    public static <T extends TextView> FontView wrap(@NonNull T textView) {
        return new MagicViewDelegate(textView);
    }

}

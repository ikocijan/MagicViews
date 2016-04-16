package co.infinum.magicapp.ui.adapter;

import android.support.v4.app.Fragment;

/**
 * Created by jmarkovic on 16/04/16.
 */
public interface PagerItem {
    String getTitle();
    Fragment newInstance();
}

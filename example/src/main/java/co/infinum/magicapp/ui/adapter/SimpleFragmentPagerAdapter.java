package co.infinum.magicapp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmarkovic on 16/04/16.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private final List<PagerItem> items = new ArrayList<>();

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public SimpleFragmentPagerAdapter add(@NonNull PagerItem item) {
        items.add(item);
        return this;
    }

    @Override
    public Fragment getItem(int position) {
        return items.get(position).newInstance();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return items.get(position).getTitle();
    }
}

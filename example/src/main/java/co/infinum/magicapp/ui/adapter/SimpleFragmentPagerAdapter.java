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

    private final List<Fragment> fragments = new ArrayList<>();
    private final List<String> titles = new ArrayList<>();

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public SimpleFragmentPagerAdapter add(@NonNull Fragment fragment, @NonNull String title) {
        fragments.add(fragment);
        titles.add(title);
        return this;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}

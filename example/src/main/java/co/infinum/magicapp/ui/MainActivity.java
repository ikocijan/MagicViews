package co.infinum.magicapp.ui;

import com.ivankocijan.magicviews.views.MagicTabLayout;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.infinum.magicapp.R;
import co.infinum.magicapp.ui.adapter.PagerItem;
import co.infinum.magicapp.ui.adapter.SimpleFragmentPagerAdapter;
import co.infinum.magicapp.ui.fragment.UbuntuFragment;
import co.infinum.magicapp.ui.fragment.UbuntuMonoFragment;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;

    @Bind(R.id.magic_tab_layout)
    protected MagicTabLayout tabLayout;

    @Bind(R.id.view_pager)
    protected ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager())
                .add(new PagerItem() {
                    @Override
                    public String getTitle() {
                        return "Ubuntu";
                    }

                    @Override
                    public Fragment newInstance() {
                        return UbuntuFragment.newInstance();
                    }
                })
                .add(new PagerItem() {
                    @Override
                    public String getTitle() {
                        return "Ubuntu Mono";
                    }

                    @Override
                    public Fragment newInstance() {
                        return UbuntuMonoFragment.newInstance();
                    }
                });
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @OnClick(R.id.fab)
    public void onFabClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}

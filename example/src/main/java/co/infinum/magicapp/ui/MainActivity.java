package co.infinum.magicapp.ui;

import com.ivankocijan.magicviews.views.MagicTabLayout;
import com.ivankocijan.magicviews.views.MagicToolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    protected MagicToolbar toolbar;

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
        toolbar.setSubtitle(R.string.main_subtitle);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void onFabClick(View view) {
        Intent intent = DemoActivity.buildIntent(this);
        startActivity(intent);
    }
}

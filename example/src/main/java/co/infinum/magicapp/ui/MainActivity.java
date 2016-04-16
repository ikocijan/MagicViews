package co.infinum.magicapp.ui;

import com.ivankocijan.magicviews.views.MagicTabLayout;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.infinum.magicapp.R;
import co.infinum.magicapp.ui.adapter.SimpleFragmentPagerAdapter;
import co.infinum.magicapp.ui.fragment.UbuntuFragment;
import co.infinum.magicapp.ui.fragment.UbuntuMonoFragment;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;

    protected MagicTabLayout tabLayout;
    protected ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        toolbar.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (toolbar.getHeight() > 0) {
                    toolbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    onViewReady();
                }
            }
        });
    }

    protected void onViewReady() {
        final ViewStub contentStub = ButterKnife.findById(MainActivity.this, R.id.vs_content);
        contentStub.setLayoutResource(R.layout.content_main);
        viewPager = (ViewPager) contentStub.inflate();

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager())
                .add(UbuntuFragment.newInstance(), "Ubuntu")
                .add(UbuntuMonoFragment.newInstance(), "Ubuntu Mono");
        viewPager.setAdapter(adapter);

        final ViewStub tabStub = ButterKnife.findById(MainActivity.this, R.id.vs_tab);
        tabLayout = (MagicTabLayout) tabStub.inflate();
        tabLayout.setupWithViewPager(viewPager);
    }

    @OnClick(R.id.fab)
    public void onFabClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}

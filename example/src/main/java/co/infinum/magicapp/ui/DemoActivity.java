package co.infinum.magicapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import co.infinum.magicapp.R;
import co.infinum.magicapp.ui.fragment.demo.DemoLayoutFragment;

/**
 * Created by jmarkovic on 20/04/16.
 */
public class DemoActivity extends AppCompatActivity {

    public static Intent buildIntent(Context context) {
        return new Intent(context, DemoActivity.class);
    }

    private Navigation currentNavigation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pager_holder);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            this.currentNavigation = Navigation.FROM_LAYOUT;
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_content, this.currentNavigation.newInstance())
                    .commit();
        }
    }

    @OnClick(R.id.btn_demo_next)
    public void goNext() {
        if (this.currentNavigation.next() != null) {
            final Fragment nextFragment = this.currentNavigation.next().newInstance();
            if (nextFragment != null) {
                this.currentNavigation = this.currentNavigation.next();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_content, nextFragment)
                        .commit();
            }
        }
    }

    @OnClick(R.id.btn_demo_previous)
    public void goPrevious() {
        if (this.currentNavigation.previous() != null) {
            final Fragment previousFragment = this.currentNavigation.previous().newInstance();
            if (previousFragment != null) {
                this.currentNavigation = this.currentNavigation.previous();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_content, previousFragment)
                        .commit();
            }
        }
    }

    enum Navigation {
        FROM_LAYOUT {
            @Override
            Fragment newInstance() {
                return DemoLayoutFragment.newInstance();
            }

            @Override
            Navigation next() {
                return FROM_CODE;
            }

            @Override
            Navigation previous() {
                return null;
            }
        },
        FROM_CODE {
            @Override
            Fragment newInstance() {
                return null;
            }

            @Override
            Navigation next() {
                return MAGIC_FONT_SPAN;
            }

            @Override
            Navigation previous() {
                return FROM_LAYOUT;
            }
        },
        MAGIC_FONT_SPAN {
            @Override
            Fragment newInstance() {
                return null;
            }

            @Override
            Navigation next() {
                return CUSTOM_VIEW;
            }

            @Override
            Navigation previous() {
                return FROM_CODE;
            }
        },
        CUSTOM_VIEW {
            @Override
            Fragment newInstance() {
                return null;
            }

            @Override
            Navigation next() {
                return WRAPPER;
            }

            @Override
            Navigation previous() {
                return MAGIC_FONT_SPAN;
            }
        },
        WRAPPER {
            @Override
            Fragment newInstance() {
                return null;
            }

            @Override
            Navigation next() {
                return null;
            }

            @Override
            Navigation previous() {
                return CUSTOM_VIEW;
            }
        };

        abstract Fragment newInstance();
        abstract Navigation next();
        abstract Navigation previous();
    }

}

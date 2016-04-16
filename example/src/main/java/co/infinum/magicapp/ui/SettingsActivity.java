package co.infinum.magicapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import co.infinum.magicapp.R;
import co.infinum.magicapp.ui.fragment.ExamplePreferenceFragment;

/**
 * Created by jmarkovic on 17/04/16.
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);

        if (savedInstanceState == null) {
            ExamplePreferenceFragment fragment = ExamplePreferenceFragment.newInstance();
            getFragmentManager().beginTransaction()
                    .add(R.id.fl_content, fragment, "Settings")
                    .commit();
        }
    }
}

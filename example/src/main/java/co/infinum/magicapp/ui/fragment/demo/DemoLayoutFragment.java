package co.infinum.magicapp.ui.fragment.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.infinum.magicapp.R;

/**
 * Created by jmarkovic on 20/04/16.
 */
public class DemoLayoutFragment extends Fragment {

    public static DemoLayoutFragment newInstance() {
        final DemoLayoutFragment fragment = new DemoLayoutFragment();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() == null) {
            throw new AssertionError("Fragment must be instantiated with newInstance() factory method.");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_from_layout, container, false);
    }
}

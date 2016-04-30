package co.infinum.magicapp.ui.fragment.demo;

import com.ivankocijan.magicviews.MagicFontSpan;
import com.ivankocijan.magicviews.views.MagicTextView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.infinum.magicapp.R;

/**
 * Created by jmarkovic on 30/04/16.
 */
public class DemoFontSpanFragment extends Fragment {

    @Bind(R.id.tv_demofontspan_magic_text_view)
    protected MagicTextView magicTextView;

    @Bind(R.id.tv_demofontspan_text_view)
    protected TextView textView;

    public static DemoFontSpanFragment newInstance() {
        final DemoFontSpanFragment fragment = new DemoFontSpanFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_font_span, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            return;
        }

        final String magicText = getString(R.string.demofontspan_magictextview);
        SpannableStringBuilder ssbMagicTextView = new SpannableStringBuilder(magicText);
        ssbMagicTextView.setSpan(new MagicFontSpan("Ubuntu-B.ttf"),
                magicText.indexOf("MagicTextView"),
                magicText.indexOf("MagicTextView") + "MagicTextView".length(),
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE
        );
        ssbMagicTextView.setSpan(new MagicFontSpan("Ubuntu-RI.ttf"),
                magicText.indexOf("MagicFontSpan"),
                magicText.indexOf("MagicFontSpan") + "MagicFontSpan".length(),
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE
        );

        magicTextView.setText(ssbMagicTextView);

        final String normalText = getString(R.string.demofontspan_textview);
        SpannableStringBuilder ssbTextView = new SpannableStringBuilder(normalText);
        ssbTextView.setSpan(new MagicFontSpan("Ubuntu-M.ttf"),
                normalText.indexOf("TextView"),
                normalText.indexOf("TextView") + "TextView".length(),
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE
        );
        ssbTextView.setSpan(new MagicFontSpan("Ubuntu-MI.ttf"),
                normalText.indexOf("MagicFontSpan"),
                normalText.indexOf("MagicFontSpan") + "MagicFontSpan".length(),
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE
        );

        textView.setText(ssbTextView);
    }
}

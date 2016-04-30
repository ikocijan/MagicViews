package co.infinum.magicapp.ui.fragment.demo;

import com.ivankocijan.magicviews.views.MagicWrapper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.infinum.magicapp.R;

/**
 * Created by jmarkovic on 30/04/16.
 */
public class DemoWrapperFragment extends Fragment {

    private static final String LIBRE_BASKERVILLE_ITALIC = "LibreBaskerville-Italic.ttf";

    @Bind(R.id.actv_wrapper)
    protected AutoCompleteTextView autoCompleteTextView;

    @Bind(R.id.btn_wrapper)
    protected Button button;

    @Bind(R.id.cb_wrapper)
    protected CheckBox checkBox;

    @Bind(R.id.ctw_wrapper)
    protected CheckedTextView checkedTextView;

    @Bind(R.id.et_wrapper)
    protected EditText editText;

    @Bind(R.id.mactv_wrapper)
    protected MultiAutoCompleteTextView multiAutoCompleteTextView;

    @Bind(R.id.rb_1)
    protected RadioButton radioButton1;

    @Bind(R.id.rb_2)
    protected RadioButton radioButton2;

    @Bind(R.id.tv_wrapper)
    protected TextView textView;

    public static DemoWrapperFragment newInstance() {
        final DemoWrapperFragment fragment = new DemoWrapperFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_magic_wrapper, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            return;
        }

        MagicWrapper.wrap(autoCompleteTextView).setFont(LIBRE_BASKERVILLE_ITALIC);
        MagicWrapper.wrap(button).setFont(LIBRE_BASKERVILLE_ITALIC);
        MagicWrapper.wrap(checkBox).setFont(LIBRE_BASKERVILLE_ITALIC);
        MagicWrapper.wrap(checkedTextView).setFont(LIBRE_BASKERVILLE_ITALIC);
        MagicWrapper.wrap(editText).setFont(LIBRE_BASKERVILLE_ITALIC);
        MagicWrapper.wrap(multiAutoCompleteTextView).setFont(LIBRE_BASKERVILLE_ITALIC);
        MagicWrapper.wrap(radioButton1).setFont(LIBRE_BASKERVILLE_ITALIC);
        MagicWrapper.wrap(radioButton2).setFont(LIBRE_BASKERVILLE_ITALIC);
        MagicWrapper.wrap(textView).setFont(LIBRE_BASKERVILLE_ITALIC);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

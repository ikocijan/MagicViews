package co.infinum.magicapp.ui.fragment.demo;

import com.ivankocijan.magicviews.views.MagicAutoCompleteTextView;
import com.ivankocijan.magicviews.views.MagicButton;
import com.ivankocijan.magicviews.views.MagicCheckBox;
import com.ivankocijan.magicviews.views.MagicCheckedTextView;
import com.ivankocijan.magicviews.views.MagicEditText;
import com.ivankocijan.magicviews.views.MagicMultiAutoCompleteTextView;
import com.ivankocijan.magicviews.views.MagicRadioButton;
import com.ivankocijan.magicviews.views.MagicTextView;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.Space;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.infinum.magicapp.R;

/**
 * Created by jmarkovic on 30/04/16.
 */
public class DemoFromCodeFragment extends Fragment {

    private static final String UBUNTU_REGULAR = "Ubuntu-R.ttf";

    @Bind(R.id.ll_scroll_view_holder)
    protected LinearLayout llScrollContainer;

    public static DemoFromCodeFragment newInstance() {
        final DemoFromCodeFragment fragment = new DemoFromCodeFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_from_code, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            return;
        }

        final Context context = view.getContext();

        LinearLayout.LayoutParams matchParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        LinearLayout.LayoutParams wrapParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        RadioGroup.LayoutParams radioGroupParams = new RadioGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        radioGroupParams.gravity = Gravity.CENTER_HORIZONTAL;

        // MagicViews added from the code
        MagicAutoCompleteTextView magicAutoCompleteTextView = new MagicAutoCompleteTextView(context);
        magicAutoCompleteTextView.setFont(UBUNTU_REGULAR);
        magicAutoCompleteTextView.setText(getString(R.string.demo_autocompletetextview));
        magicAutoCompleteTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        llScrollContainer.addView(magicAutoCompleteTextView, matchParams);
        llScrollContainer.addView(newSmallSpace(context));

        MagicButton magicButton = new MagicButton(context);
        magicButton.setFont(UBUNTU_REGULAR);
        magicButton.setText(getString(R.string.demo_button));
        llScrollContainer.addView(magicButton, matchParams);
        llScrollContainer.addView(newSmallSpace(context));

        MagicCheckBox magicCheckBox = new MagicCheckBox(context);
        magicCheckBox.setFont(UBUNTU_REGULAR);
        magicCheckBox.setText(getString(R.string.demo_checkbox));
        llScrollContainer.addView(magicCheckBox, wrapParams);
        llScrollContainer.addView(newSmallSpace(context));

        MagicCheckedTextView magicCheckedTextView = new MagicCheckedTextView(context);
        magicCheckedTextView.setFont(UBUNTU_REGULAR);
        magicCheckedTextView.setText(getString(R.string.demo_checkedtextview));
        llScrollContainer.addView(magicCheckedTextView, wrapParams);
        llScrollContainer.addView(newSmallSpace(context));

        MagicEditText magicEditText = new MagicEditText(context);
        magicEditText.setFont(UBUNTU_REGULAR);
        magicEditText.setText(getString(R.string.demo_edittext));
        magicEditText.setGravity(Gravity.CENTER_HORIZONTAL);
        llScrollContainer.addView(magicEditText, matchParams);
        llScrollContainer.addView(newSmallSpace(context));

        MagicMultiAutoCompleteTextView magicMultiAutoCompleteTextView = new MagicMultiAutoCompleteTextView(context);
        magicMultiAutoCompleteTextView.setFont(UBUNTU_REGULAR);
        magicMultiAutoCompleteTextView.setText(getString(R.string.demo_multiautocompletetextview));
        magicMultiAutoCompleteTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        llScrollContainer.addView(magicMultiAutoCompleteTextView, matchParams);
        llScrollContainer.addView(newSmallSpace(context));

        RadioGroup radioGroup = new RadioGroup(context);
        llScrollContainer.addView(radioGroup, matchParams);
        llScrollContainer.addView(newSmallSpace(context));

        MagicRadioButton magicRadioButton1 = new MagicRadioButton(context);
        magicRadioButton1.setFont(UBUNTU_REGULAR);
        magicRadioButton1.setText(getString(R.string.demo_radiobutton_1));
        magicRadioButton1.setChecked(true);
        radioGroup.addView(magicRadioButton1, radioGroupParams);

        MagicRadioButton magicRadioButton2 = new MagicRadioButton(context);
        magicRadioButton2.setFont(UBUNTU_REGULAR);
        magicRadioButton2.setText(getString(R.string.demo_radiobutton_2));
        magicRadioButton2.setChecked(false);
        radioGroup.addView(magicRadioButton2, radioGroupParams);

        MagicTextView magicTextView = new MagicTextView(context);
        magicTextView.setFont(UBUNTU_REGULAR);
        magicTextView.setText(getString(R.string.demo_textview));
        magicTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        llScrollContainer.addView(magicTextView, matchParams);
        llScrollContainer.addView(newSmallSpace(context));

    }

    private Space newSmallSpace(final Context context) {
        LinearLayout.LayoutParams spaceParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                context.getResources().getDimensionPixelSize(R.dimen.height_space_small)
        );

        Space smallSpace = new Space(context);
        smallSpace.setLayoutParams(spaceParams);

        return smallSpace;
    }
}

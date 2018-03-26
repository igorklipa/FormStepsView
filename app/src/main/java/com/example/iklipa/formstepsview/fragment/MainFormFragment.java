package com.example.iklipa.formstepsview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.iklipa.formstepsview.R;
import com.example.iklipa.formstepsview.model.WizardModel;
import com.example.iklipa.formstepsview.view.Wizard;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by iklipa on 3/23/2018.
 */

public class MainFormFragment extends Fragment {

    @BindView(R.id.wizard)
    Wizard wizard;

    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form_content_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        ArrayList<String> stepNames = new ArrayList<String>() {{
            add("First");
            add("Second");
        }};

        ArrayList steps = new ArrayList<LinearLayout>() {{
            add(new FirstFormView(getContext()));
            add(new SecondFormView(getContext()));
        }};

        WizardModel wizardModel = new WizardModel();
        wizardModel.setSlideLayouts(steps);
        wizardModel.setSlideTitles(stepNames);
        wizard.setData(wizardModel);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

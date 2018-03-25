package com.example.iklipa.formstepsview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iklipa.formstepsview.R;
import com.example.iklipa.formstepsview.event.FirstFormEvent;
import com.example.iklipa.formstepsview.event.SecondFormEvent;
import com.example.iklipa.formstepsview.model.DefaultSlideModel;
import com.example.iklipa.formstepsview.view.HeaderSlideView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by iklipa on 3/23/2018.
 */

public class MainFormFragment extends Fragment {

    @BindView(R.id.formFragmentContent)
    Fragment formFragmentContent;
    @BindView(R.id.headerSlideText)
    HeaderSlideView headerSlideView;

    Unbinder unbinder;

    private FirstFormEvent firstFormEvent;
    private SecondFormEvent secondFormEvent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        FirstFormEvent firstFormEvent = (FirstFormEvent) DefaultSlideModel.newInstance("First", new FirstFormFragment());
        SecondFormEvent secondFormEvent = (SecondFormEvent) DefaultSlideModel.newInstance("Second", new SecondFormFragment());

        headerSlideView.addSlide(firstFormEvent);
        headerSlideView.addSlide(secondFormEvent);
        headerSlideView.show();
    }

//    public void onMessageEvent(FirstFormEvent firstFormEvent) {
//        setActiveFragment(new FirstFormFragment());
//    }
//
//    public void onMessageEvent(SecondFormEvent secondFormEvent) {
//        setActiveFragment(new SecondFormFragment());
//    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

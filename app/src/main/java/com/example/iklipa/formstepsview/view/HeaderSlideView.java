package com.example.iklipa.formstepsview.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.iklipa.formstepsview.R;
import com.example.iklipa.formstepsview.fragment.SecondFormFragment;
import com.example.iklipa.formstepsview.model.DefaultSlideModel;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


/**
 * Created by iklipa on 3/23/2018.
 */

public class HeaderSlideView extends RelativeLayout {

    private LinearLayout headerSlideTitles;
    private FragmentManager fragmentManager;

    private Context context;
    private ArrayList<DefaultSlideModel> slides;
    private ArrayList<Fragment> fragments;
    private int activeSlide = -1;

    public HeaderSlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }

    public HeaderSlideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_header_slide_layout, this);
        headerSlideTitles = view.findViewById(R.id.headerSlideTitles);
    }

    public void addSlide(DefaultSlideModel model) {
        slides.add(model);
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    private void setActiveFragment(Fragment fragment) {

        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.formFragmentContent, new SecondFormFragment());
            ft.commit();
        }
    }

    public void setActiveSlide(int slide) {
        activeSlide = slide;
        EventBus.getDefault().post(slides.get(slide));
    }

    public void show() {
        setActiveSlide(0);
    }
}

package com.example.iklipa.formstepsview.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.iklipa.formstepsview.R;
import com.example.iklipa.formstepsview.model.DefaultSlideModel;
import com.example.iklipa.formstepsview.util.AnimateUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


/**
 * Created by iklipa on 3/23/2018.
 */

public class HeaderSlideView extends RelativeLayout {

    private LinearLayout headerSlideTitles;
    private ViewGroup contentFragment;
    private LinearLayout progressLine;

    private FragmentManager fragmentManager;
    private Context context;
    private ArrayList<DefaultSlideModel> slides;
    private int activeSlide = -1;

    public HeaderSlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public HeaderSlideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.fragment_header_slide_layout, this);
        headerSlideTitles = findViewById(R.id.headerSlideTitles);
        progressLine = findViewById(R.id.headerSlideLine);
        slides = new ArrayList<>();
    }

    public void addSlide(DefaultSlideModel model) {
        slides.add(model);
    }

    private void setupTitles() {
        for(DefaultSlideModel item : slides) {
            setTitle(item.getSlideTitle(), (getScreenWidth()/slides.size()));
        }
    }

    private void setTitle(String title, int width) {
        View view = LayoutInflater.from(context).inflate(R.layout.header_slide_text, headerSlideTitles, false);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);

        TextView titleView = view.findViewById(R.id.headerSlideText);
        titleView.setTextColor(Color.BLACK);
        titleView.setText(title);

        headerSlideTitles.addView(view);
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    private void setActiveFragment(Fragment fragment) {
        if (fragmentManager != null && fragment != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.headerSlideContentFragment, fragment);
            ft.commit();
        }
    }

    public void nextSlide() {
        int nextSlideIndex = (activeSlide + 1);
        if(nextSlideIndex <= slides.size() && slides != null) {
            setActiveSlide(nextSlideIndex);
            expandProgressLine();
        }
    }

    public void previousSlide() {
        int previousSlideIndex = (activeSlide - 1);
        if(previousSlideIndex >= 0 && slides != null) {
            setActiveSlide(previousSlideIndex);
        }
    }

    private void setActiveSlide(int slide) {
        activeSlide = slide;
        DefaultSlideModel item = slides.get(slide);
        setActiveFragment(item.getFragment());
        EventBus.getDefault().post(item);
    }

    public void show() {
        setupTitles();
        initFirstFragment();
    }

    private void expandProgressLine() {
        int titleWidth = getScreenWidth()/slides.size();
        AnimateUtil.expand(progressLine, (titleWidth*(activeSlide + 1)) - (titleWidth/2));
    }

    private void initFirstFragment() {
        Fragment fragment = slides.get(0).getFragment();
        if (fragmentManager != null && fragment != null) {
            activeSlide = 0;
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(R.id.headerSlideContentFragment, fragment);
            ft.commit();
            expandProgressLine();
        }
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}

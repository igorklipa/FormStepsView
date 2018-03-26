package com.example.iklipa.formstepsview.model;


import android.support.v4.app.Fragment;

/**
 * Created by iklipa on 3/23/2018.
 */

public class DefaultSlideModel {

    private String slideTitle;
    private Fragment fragment;

    public DefaultSlideModel(String slideTitle, Fragment fragment) {
        this.slideTitle = slideTitle;
        this.fragment = fragment;
    }

    public String getSlideTitle() {
        return slideTitle;
    }

    public void setSlideTitle(String slideTitle) {
        this.slideTitle = slideTitle;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

//    public static DefaultSlideModel newInstance(String slideTitle, Fragment fragment) {
//        DefaultSlideModel model = new DefaultSlideModel();
//        model.slideTitle = slideTitle;
//        model.fragment = fragment;
//        return model;
//    }
}

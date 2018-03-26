package com.example.iklipa.formstepsview.model;

import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by iklipa on 3/26/2018.
 */

public class WizardModel {
    ArrayList<String> slideTitles;
    ArrayList<LinearLayout> slideLayouts;

    public ArrayList<String> getSlideTitles() {
        return slideTitles;
    }

    public void setSlideTitles(ArrayList<String> slideTitles) {
        this.slideTitles = slideTitles;
    }

    public ArrayList<LinearLayout> getSlideLayouts() {
        return slideLayouts;
    }

    public void setSlideLayouts(ArrayList<LinearLayout> slideLayouts) {
        this.slideLayouts = slideLayouts;
    }
}

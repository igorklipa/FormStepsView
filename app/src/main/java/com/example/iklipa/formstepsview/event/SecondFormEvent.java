package com.example.iklipa.formstepsview.event;

import android.support.v4.app.Fragment;

import com.example.iklipa.formstepsview.model.DefaultSlideModel;

/**
 * Created by iklipa on 3/23/2018.
 */

public class SecondFormEvent extends DefaultSlideModel {
    public SecondFormEvent(String slideTitle, Fragment fragment) {
        super(slideTitle, fragment);
    }
}

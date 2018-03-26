package com.example.iklipa.formstepsview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.iklipa.formstepsview.model.WizardModel;

/**
 * Created by iklipa on 3/26/2018.
 */

public class Wizard extends LinearLayout {

    private WizardModel wizardModel;

    public Wizard(Context context) {
        super(context);
    }

    public Wizard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setData(WizardModel wizardModel) {
        this.wizardModel = wizardModel;
    }
}

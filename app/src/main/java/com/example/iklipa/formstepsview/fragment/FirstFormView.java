package com.example.iklipa.formstepsview.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.iklipa.formstepsview.R;
import com.example.iklipa.formstepsview.event.FirstFormEvent;
import com.example.iklipa.formstepsview.view.HeaderSlideView;

/**
 * Created by iklipa on 3/23/2018.
 */

public class FirstFormView extends LinearLayout {

    Button nextBtn;

    public FirstFormView(Context context) {
        super(context);
    }

    public FirstFormView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void init() {
        inflate(getContext(), R.layout.fragment_first_form_layout, this);
    }
}

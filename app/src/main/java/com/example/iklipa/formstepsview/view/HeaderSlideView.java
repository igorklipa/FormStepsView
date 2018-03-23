package com.example.iklipa.formstepsview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.iklipa.formstepsview.R;
import com.example.iklipa.formstepsview.model.DefaultSlideModel;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


/**
 * Created by iklipa on 3/23/2018.
 */

public class HeaderSlideView extends RelativeLayout {

    private ArrayList<DefaultSlideModel> slides;
    private int activeSlide = -1;

    public HeaderSlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HeaderSlideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_header_slide_layout, this);
    }

    public void addSlide(DefaultSlideModel model, String title) {
        model.setSlideTitle(title);
        slides.add(model);
    }

    public void setActiveSlide(int slide) {
        activeSlide = slide;
        EventBus.getDefault().post(slides.get(slide));
    }
}

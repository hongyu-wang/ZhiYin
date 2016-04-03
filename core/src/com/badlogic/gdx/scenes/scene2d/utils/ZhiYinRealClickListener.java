package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;

/**
 *
 * Created by Hongyu Wang on 3/28/2016.
 */
public class ZhiYinRealClickListener extends ClickListener {
    private boolean firstTime;
    private WorkingTextArea wta;

    public ZhiYinRealClickListener(WorkingTextArea wta){
        firstTime = true;
        this.wta = wta;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        if (firstTime)
            wta.setText("");
        
        firstTime = false;
    }
}

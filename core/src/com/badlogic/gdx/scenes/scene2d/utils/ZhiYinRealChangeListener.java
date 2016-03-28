package com.badlogic.gdx.scenes.scene2d.utils;

import client.stateInterfaces.Executable;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 *
 * Created by Hongyu Wang on 3/27/2016.
 */
public class ZhiYinRealChangeListener extends ChangeListener{
    private boolean change;
    private Executable executable;


    public ZhiYinRealChangeListener(Executable executable){
        change = true;
        this.executable = executable;
    }


    @Override
    public void changed(ChangeEvent event, Actor actor) {
        if (change){
            executable.execute();
        }
        change = true;
    }

    public void setChange(){
        change = false;
    }
}

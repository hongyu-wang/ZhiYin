package client.component.basicComponents;

import client.stateInterfaces.ActionMonitor;
import client.stateInterfaces.Dragable;
import client.stateInterfaces.Executable;
import client.stateInterfaces.Performable;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class DragButton implements Dragable {
    private Executable dragExecute, releaseExecute;
    private ActionMonitor monitor;
    public DragButton(ActionMonitor monitor) {
        this.monitor = monitor;
    }

    public void drag(){
    }

    public void release(){

    }

    @Override
    public Executable getDragExecutable() {
        return dragExecute;
    }

    @Override
    public Executable getReleaseExecutable() {
        return releaseExecute;
    }

    @Override
    public void setDragExecutable(Executable e) {
        dragExecute = e;
    }

    @Override
    public void setReleaseExecutable(Executable e) {
        releaseExecute = e;
    }


}

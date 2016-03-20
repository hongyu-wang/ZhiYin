package client.component.basicComponents;

import client.events.ActionEvent;
import client.stateInterfaces.ActionMonitor;
import client.stateInterfaces.Dragable;
import client.stateInterfaces.Executable;
import client.stateInterfaces.Performable;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class DragButton implements Dragable {
    private Executable dragExecute, releaseExecute, returnExecutable;
    private ActionMonitor monitor;
    public DragButton(ActionMonitor monitor) {
        this.monitor = monitor;
    }

    public void drag(){
        monitor.actionPerformed(new ActionEvent(this));
    }

    public void release(){

    }

    @Override
    public Executable getExecutable() {
        return returnExecutable;
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

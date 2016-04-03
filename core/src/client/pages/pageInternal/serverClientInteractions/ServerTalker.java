package client.pages.pageInternal.serverClientInteractions;

import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.stateInterfaces.Executable;
import server.webservices.UpdateObject;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-04-02.
 */
public class ServerTalker extends Talkers {
    private List<Long> pulledKeys;
    private int waitCounter = 0;
    private List<ExecuteUpdate> executables;

    @Deprecated
    @Override
    public void init() {

    }

    public void init(List<Long> pullKeys){
        this.pulledKeys = pullKeys;
        this.executables = Utils.newList();
    }

    public void addExecutable(ExecuteUpdate updater){
        executables.add(updater);
    }


    @Override
    public void pull() {
        repull();
    }

    @Override
    public void push() {
        //NOTHING
    }

    @Override
    public boolean isUpdated() {
        return pulledKeys.isEmpty();
    }

    @Override
    public void update(float dt) {
        if(pulledKeys == null){
            localDatabase.initServerTalker();
        }
        if(waitCounter%100 == 0) {
            if (pulledKeys.isEmpty()) {
                updatePages();
                requestUpdate();
            }
            else{
//                this.pull();
            }
        }
        waitCounter++;
    }

    private void requestUpdate(){
        UpdateObject.newInstance().update();
        waitCounter = 0;
    }

    private void updatePages(){
        for(Executable ex: executables){
            ex.execute();
        }
    }

    private void repull(){
        for(long key : pulledKeys){
            localDatabase.requestModelFromServer(key);
        }
    }
}

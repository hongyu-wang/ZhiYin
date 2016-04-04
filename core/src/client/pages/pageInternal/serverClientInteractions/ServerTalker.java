package client.pages.pageInternal.serverClientInteractions;

import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.stateInterfaces.Executable;
import server.model.social.MConversation;
import server.model.user.User;
import server.model.user.UserConversations;
import server.webservices.UpdateObject;
import tools.utilities.Utils;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Kevin Zheng on 2016-04-02.
 */
public class ServerTalker extends Talkers {
    private Set<Long> pulledKeys;
    private int waitCounter = 1;
    private List<ExecuteUpdate> executables;

    @Deprecated
    @Override
    public void init() {

    }

    public void init(Set<Long> pullKeys){
        this.pulledKeys = pullKeys;
        this.executables = new CopyOnWriteArrayList<>();
    }

    public void addExecutable(ExecuteUpdate updater){
        executables.add(updater);
    }

    @Override
    public void pull() {
        if (pulledKeys.isEmpty()) {
            this.setWaiting(true);
            requestUpdate();
        }
        else{
//                repull();
        }
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
        if(this.isWaiting()&&pulledKeys.isEmpty()){
            updatePages();
            this.setWaiting(false);
        }
        if(waitCounter%100 == 0) {
            this.pull();
        }
        waitCounter++;
    }

    public void notWaiting(){
        this.setWaiting(false);
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

    public static MConversation getConversationByFriend(String friendName){
        User user = localDatabase.getMainUser();
        UserConversations userConversations = localDatabase.getModel(user.getConversations());
        List<Long> convoList = userConversations.getConvoKeys();

        return localDatabase.getModel(convoList.get(indexByFriend(friendName)));
    }


    private static int indexByFriend(String friendName){
        int friendKey = (int) localDatabase.getUserKeyByName(friendName);

        switch((int) localDatabase.getMainUser().getKey()){
            case 1:
                if(friendKey == 2){
                    return 0;
                }
                else if(friendKey == 3){
                    return 1;
                }
                break;

            case 2:
                if(friendKey == 1){
                    return 0;
                }
                else if(friendKey == 3) {
                    return 1;
                }
                break;

            case 3:
                if(friendKey == 1) {
                    return 0;
                }
                else if(friendKey == 2) {
                    return 1;
                }
                break;
        }

        throw new IndexOutOfBoundsException("You didn't enter a correct user");
    }
}

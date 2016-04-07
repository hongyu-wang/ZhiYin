package client.events.executables.internalChanges.serverInteractions;

import client.component.basicComponents.ConfirmDialog;
import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecutePlayMSnapShot;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;
import server.model.media.MSnapShot;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.model.user.UserProfile;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-04-05.
 */
public class ExecuteUpdateSnapChatMessage extends ExecuteUpdate {
//    private List<Long> snapChats;

    public ExecuteUpdateSnapChatMessage(){

    }

    @Override
    public void execute() {
        User user = localDatabase.getMainUser();

        if(user.getSnapChat() != 0){
            MSnapShot snapShot = localDatabase.getModel(user.getSnapChat());

            User friend = localDatabase.getModel(snapShot.getCreator());

            ConfirmDialog dialog = setUpWindows(snapShot, friend);

            StateManager.getInstance().getCurrentState().getStage().addActor(dialog.getWindow());

            user.setSnapChat(0L);

            List<ServerModel> pushList = Utils.newList();

            pushList.add(user);

            localDatabase.pushModel(pushList);
        }
    }

    private ConfirmDialog setUpWindows(MSnapShot snapShot, User user){
        UserProfile profile = localDatabase.getModel(user.getProfileKey());
        String name = profile.getUsername();

        String[] options = {
                "Play",
                "Cancel"
        };

        Executable[] exs = {
                new ExecutePlayMSnapShot(snapShot),
                new TestExecutable("Cancelled")
        };

        ConfirmDialog confirmDialog = new ConfirmDialog(
                "Your friend: " + name + " has send you a Music SnapShot!",
                options
        );
        confirmDialog.setUpExecutables(
                exs
        );

        return confirmDialog;
    }
}

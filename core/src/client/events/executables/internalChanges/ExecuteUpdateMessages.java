package client.events.executables.internalChanges;

import client.pages.State;
import client.pages.friends.Friends2;
import client.pages.friends.boxes.MessageBox;
import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.stateInterfaces.Executable;
import com.android.org.conscrypt.Message;
import org.robovm.apple.mobilecoreservices.UTType;
import server.model.media.MText;
import server.model.social.MConversation;
import server.model.social.MMessage;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-24.
 */
public class ExecuteUpdateMessages implements Executable {
    private Friends2 friend2;

    public ExecuteUpdateMessages(Friends2 friend2){
        this.friend2 = friend2;
    }

    @Override
    public void execute() {
        ModelStorage ms = ModelStorageFactory.createModelStorage();

        MConversation conversation = ms.getModel(friend2.getConversation());

        ms.requestModelFromServer(MConversation.class.getName(), friend2.getConversation());

        List<Long> messageKeys = conversation.getMessageList();

        boolean updated = true;

        for(long key :messageKeys){
            if(!friend2.getMessageKeys().contains(key)){
                MMessage mMessage = ms.<MMessage>getModel(key);

                if(mMessage != null) {
                    long textKey = mMessage.getText();
                    if (ms.<MText>getModel(textKey) != null) {
                        if(updated) {
                            String text = ms.<MText>getModel(textKey).getText();

                            MessageBox box = new MessageBox(text, getWriter(ms, (int) mMessage.getCreator()));
                            friend2.addMessage(box);
                            friend2.getMessageKeys().add(mMessage.getKey());
                        }
                    }
                    else{
                        ms.requestModelFromServer(MText.class.getName(), textKey);
                        updated = false;
                    }
                }
                else{
                    ms.requestModelFromServer(MMessage.class.getName(), key);
                    updated = false;
                }
            }
        }
    }



    private int getWriter(ModelStorage ms, int user){
        if(user == ms.getMainUser().getKey()){
            return 1;
        }

        else{
            return 0;
        }
    }
}

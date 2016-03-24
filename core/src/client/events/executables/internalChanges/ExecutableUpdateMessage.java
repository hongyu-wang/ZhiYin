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
public class ExecutableUpdateMessage implements Executable {

    private long conversation;
    private Friends2 friend2;

    public ExecutableUpdateMessage(Friends2 friend2){
        this.conversation = friend2.getConversation();
        this.friend2 = friend2;
    }

    @Override
    public void execute() {
        ModelStorage ms = ModelStorageFactory.createModelStorage();

        MConversation conversation = ms.getModel(this.conversation);
        if(conversation == null){
            ms.requestModelFromServer(MConversation.class.getName(), this.conversation);
            return;
        }

        List<Long> messageKeys = conversation.getMessageList();

        for(long key :messageKeys){
            if(!messageKeys.contains(key)){
                MMessage mMessage = ms.<MMessage>getModel(key);

                if(mMessage != null) {
                    long textKey = mMessage.getText();
                    if (ms.<MText>getModel(textKey) != null) {
                        String text = ms.<MText>getModel(textKey).getText();

                        MessageBox box = new MessageBox(text, getWriter(ms, (int)mMessage.getCreator()));
                        friend2.addMessage(box);
                        friend2.getMessageKeys().add(mMessage.getKey());
                    }
                    else{
                        ms.requestModelFromServer(MText.class.getName(), textKey);
                        return;
                    }
                }
                else{
                    ms.requestModelFromServer(MMessage.class.getName(), key);
                    return;
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

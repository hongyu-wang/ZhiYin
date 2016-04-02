package client.events.executables.internalChanges.conversation;

import client.pages.friends.Friends2;
import client.pages.friends.boxes.MessageBox;
import client.pages.pageInternal.modelStorage.LocalDatabase;
import client.pages.pageInternal.modelStorage.LocalDatabaseFactory;
import client.stateInterfaces.Executable;
import server.model.media.MAudio;
import server.model.social.MConversation;
import server.model.social.MMessage;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-29.
 */
public class ExecuteSendAudioMessage implements Executable {
    private Friends2 friend2;
    private MessageBox messageBox;


    public ExecuteSendAudioMessage(Friends2 friends2, MessageBox messageBox){
        this.friend2 = friends2;
        this.messageBox = messageBox;
    }

    @Override
    public void execute() {
        LocalDatabase localDatabase = LocalDatabaseFactory.createModelStorage();

        MConversation conversation = localDatabase.getModel(friend2.getConversation());

        if(conversation == null){
            localDatabase.requestModelFromServer(friend2.getConversation());
            return;
        }

        if(friend2.getAudioKeys().contains(messageBox.getWorkingMAudio().getKey())){
            return;
        }

        List<Long> messageKeys = conversation.getMessageList();


        MAudio audio = messageBox.getWorkingMAudio();

        MMessage message = new MMessage();

        message.setKey(localDatabase.generateKey());

        message.setCreator(localDatabase.getMainUser().getKey());

        message.setAudioKey(audio.getKey());

        message.setText(-1L);

        messageKeys.add(message.getKey());

        friend2.getMessageKeys().add(message.getKey());

        localDatabase.pushModel(audio);
        localDatabase.pushModel(message);
        localDatabase.pushModel(conversation);
    }
}

package client.events.executables.internalChanges.conversation;

import client.pages.friends.Friends2;
import client.pages.friends.boxes.MessageBox;
import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.stateInterfaces.Executable;
import server.model.media.MAudio;
import server.model.media.MText;
import server.model.social.MConversation;
import server.model.social.MMessage;
import server.services.factories.MessageManagerFactory;
import server.services.factories.TextManagerFactory;

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
        if(!messageBox.hasAudio()){
            return;
        }
        ModelStorage ms = ModelStorageFactory.createModelStorage();

        MConversation conversation = ms.getModel(friend2.getConversation());

        if(conversation == null){
            ms.requestModelFromServer(friend2.getConversation());
            return;
        }

        List<Long> messageKeys = conversation.getMessageList();


        MAudio audio = messageBox.getWorkingMAudio();

        MMessage message = new MMessage();

        message.setKey(ms.generateKey());

        message.setCreator(ms.getMainUser().getKey());

        message.setAudioKey(audio.getKey());

        message.setText(-1L);

        messageKeys.add(message.getKey());

        friend2.getMessageKeys().add(message.getKey());

        ms.pushModel(audio);
        ms.pushModel(message);
        ms.pushModel(conversation);
    }
}

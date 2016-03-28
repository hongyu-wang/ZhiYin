package client.events.executables.internalChanges.conversation;

import client.pages.friends.Friends2;
import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.stateInterfaces.Executable;
import client.stateInterfaces.Pushable;
import server.model.media.MText;
import server.model.social.MConversation;
import server.model.social.MMessage;
import server.services.factories.MessageManagerFactory;
import server.services.factories.TextManagerFactory;

/**
 * Created by Kevin Zheng on 2016-03-28.
 */
public class ExecutePushMessage implements Executable, Pushable {
    private Friends2 friend2;
    public ExecutePushMessage(Friends2 friend2){
        this.friend2 = friend2;
    }

    @Override
    public void execute() {
        String userText = friend2.getMessage();

        ModelStorage ms = ModelStorageFactory.createModelStorage();

        MConversation conversation = ms.getModel(friend2.getConversation());

        MText text = TextManagerFactory.createTextManager().createText(userText, 0);

        MMessage message = MessageManagerFactory.createMessageManager().createMessage(text.getKey(), System.currentTimeMillis(), ms.getMainUser().getKey());

        conversation.getMessageList().add(message.getKey());

        friend2.getMessageKeys().add(message.getKey());

        ms.pushModel(text);
        ms.pushModel(message);
        ms.pushModel(conversation);
    }

    @Override
    public int requiredKeys() {
        return 2;
    }
}

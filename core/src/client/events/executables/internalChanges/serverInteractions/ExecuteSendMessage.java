package client.events.executables.internalChanges.serverInteractions;

import client.pages.friends.Friends2;
import server.model.media.MText;
import server.model.social.MConversation;
import server.model.social.MMessage;
import server.model.structureModels.ServerModel;
import server.services.factories.MessageManagerFactory;
import server.services.factories.TextManagerFactory;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-24.
 */
public class ExecuteSendMessage implements ExecuteServer {
    private Friends2 friend2;

    public ExecuteSendMessage(Friends2 friend2){
        this.friend2 = friend2;
    }

    @Override
    public void execute() {

        MConversation conversation = localDatabase.getModel(friend2.getConversation());

        if(conversation == null){
            localDatabase.requestModelFromServer(friend2.getConversation());
            return;
        }

        List<Long> messageKeys = conversation.getMessageList();

        String userText = friend2.getMessage();

        MText text = TextManagerFactory.createTextManager().createText(userText, 0);
        text.setKey(localDatabase.generateKey());

        MMessage message = MessageManagerFactory.createMessageManager().createMessage(text.getKey(), System.currentTimeMillis(), localDatabase.getMainUser().getKey(), -1L);
        message.setKey(localDatabase.generateKey());

        messageKeys.add(message.getKey());

        friend2.getMessageKeys().add(message.getKey());

        friend2.addTextMessage(userText, 1);

        ServerModel[] pushList = {
                text,
                message,
                conversation
        };

        localDatabase.pushModel(pushList);
    }
}

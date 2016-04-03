package client.events.executables.internalChanges.serverInteractions;

import client.pages.friends.Friends2;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.tools.Constants;
import server.model.media.MText;
import server.model.social.MConversation;
import server.model.social.MMessage;
import server.model.structureModels.ServerModel;
import server.model.user.UserConversations;
import server.services.factories.MessageManagerFactory;
import server.services.factories.TextManagerFactory;
import tools.utilities.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-24.
 */
public class ExecuteSendMessage implements ExecuteServer {
    private Friends2 friend2;
    private long conversation;
    private List<Long> messageKeys;

    public ExecuteSendMessage(Friends2 friend2){
        this.friend2 = friend2;
        UserConversations userConversations = localDatabase.getModel(localDatabase.getMainUser().getConversations());
        List<Long> convoList = userConversations.getConvoKeys();

        this.conversation = convoList.get(TalkerFactory.getMessagesTalker().indexByFriend(friend2.getFriendName()));

        this.messageKeys = friend2.getMessageKeys();
    }

    @Override
    public void execute() {
        MConversation conversation = localDatabase.getModel(this.conversation);

        List<Long> messageKeys = conversation.getMessageList();
        String userText = friend2.getMessage();
        MText text = generateText(userText);
        MMessage message = generateMMessage(text);
        messageKeys.add(message.getKey());

        friend2.getMessageKeys().add(message.getKey());
        friend2.addTextMessage(userText, 1, Constants.getCurrentTimestamp(message.getTimeStamp()));

        //------------------Pushing.
        List<ServerModel> pushList = Utils.newList();

        pushList.add(text);
        pushList.add(message);
        pushList.add(conversation);

        localDatabase.pushModel(pushList);
    }

    private MText generateText(String message){
        MText text = TextManagerFactory.createTextManager().createText(message, 0);
        text.setKey(localDatabase.generateKey());

        return text;
    }

    private MMessage generateMMessage(MText mText){
        long text = mText.getKey();
        long timestamp = System.currentTimeMillis();
        long creator = localDatabase.getMainUser().getKey();
        long audioKey = -1L;
        MMessage message = MessageManagerFactory.createMessageManager()
                .createMessage(text, timestamp, creator, audioKey);

        message.setKey(localDatabase.generateKey());

        return message;
    }
}

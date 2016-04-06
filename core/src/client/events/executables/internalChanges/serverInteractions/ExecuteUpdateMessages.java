package client.events.executables.internalChanges.serverInteractions;

import client.events.executables.internalChanges.schmoferMusicExecutable.ExecutePlayMAudio;
import client.pages.friends.Friends2;
import client.pages.friends.boxes.MessageBox;
import client.pages.pageInternal.serverClientInteractions.ServerTalker;
import client.tools.Constants;
import server.model.media.MAudio;
import server.model.media.MText;
import server.model.social.MConversation;
import server.model.social.MMessage;
import tools.utilities.Utils;

import java.util.Collections;
import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-24.
 */
public class ExecuteUpdateMessages extends ExecuteUpdate {
    private Friends2 friend2;
    private long conversation;

    public ExecuteUpdateMessages(Friends2 friend2){
        this.friend2 = friend2;
        this.conversation = ServerTalker.getConversationByFriend(friend2.getFriendName()).getKey();
    }

    @Override
    public void execute() {
        MConversation conversation = localDatabase.getModel(this.conversation);

        List<MMessage> messageList = Utils.newList();

        this.getMessages(conversation, messageList);

        Collections.sort(messageList);

        for(MMessage message: messageList){
            addMessageBox(message);
        }
    }

    private void getMessages(MConversation conversation, List<MMessage> messages){
        //New Code
        for(long key : conversation.getMessageList()){
            if(!friend2.getMessageKeys().contains(key)){
                messages.add(localDatabase.getModel(key));
            }
        }
    }


    private void addMessageBox(MMessage mMessage){
        MessageBox box;

        long textKey = mMessage.getText();

        int byUser = getWriter((int) mMessage.getCreator());

        if(mMessage.getText() != -1L) {
            String text = localDatabase.<MText>getModel(textKey).getText();
            box = new MessageBox(text, byUser, friend2.getFriendName(), Constants.getCurrentTimestamp(mMessage.getTimeStamp()));
        }
        else{
            MAudio audio = localDatabase.getModel(mMessage.getAudioKey());
            ExecutePlayMAudio epma = new ExecutePlayMAudio(audio);
            box = new MessageBox(epma, byUser, audio, friend2.getFriendName(), Constants.getCurrentTimestamp(mMessage.getTimeStamp()));
        }

        friend2.addMessage(box);
        friend2.getMessageKeys().add(mMessage.getKey());
    }


    private int getWriter(int user){
        if(user == localDatabase.getMainUser().getKey()){
            return 1;
        }

        else{
            return 0;
        }
    }
}

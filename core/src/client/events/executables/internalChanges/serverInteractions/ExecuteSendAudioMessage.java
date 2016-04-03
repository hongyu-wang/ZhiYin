package client.events.executables.internalChanges.serverInteractions;

import client.pages.friends.Friends2;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import server.model.structureModels.ServerModel;
import server.model.user.UserConversations;
import server.services.factories.AudioManagerFactory;
import server.services.factories.MessageManagerFactory;
import tools.AudioTools.AudioRecorder;
import server.model.media.MAudio;
import server.model.social.MConversation;
import server.model.social.MMessage;
import tools.utilities.Utils;

import java.util.List;

/**
 *
 * Created by Kevin Zheng on 2016-03-29.
 */
public class ExecuteSendAudioMessage implements ExecuteServer {
    private Friends2 friend2;
    private long conversation;
    private List<Long> messageKeys;


    public ExecuteSendAudioMessage(Friends2 friends2){
        UserConversations userConversations = localDatabase.getModel(localDatabase.getMainUser().getConversations());
        List<Long> convoList = userConversations.getConvoKeys();

        this.friend2 = friends2;

        this.conversation = convoList.get(TalkerFactory.getMessagesTalker().indexByFriend(friend2.getFriendName()));

        this.messageKeys = friend2.getMessageKeys();
    }




    @Override
    public void execute() {
        MAudio audio;
        if (os == MAC)
            audio = AudioRecorder.getInstance().stopRecording(); //TODO This is the MAudio that you want
        else{
            audio = AudioManagerFactory.createAudioManager().createMockAudio();
        }


        MConversation conversation = localDatabase.getModel(this.conversation);
        /*---------------------------------------------------------------------------*/

        MMessage message = generateMMessage(audio);

        conversation.getMessageList().add(message.getKey());

        friend2.getMessageKeys().add(message.getKey());
        friend2.addAudioMessage(audio, 1);

        List<ServerModel> pushList = Utils.newList();

        pushList.add(audio);
        pushList.add(message);
        pushList.add(conversation);

        localDatabase.pushModel(pushList);
    }

    private MMessage generateMMessage(MAudio audio){
        long text = -1L;
        long timestamp = System.currentTimeMillis();
        long creator = localDatabase.getMainUser().getKey();
        long audioKey = audio.getKey();
        MMessage message = MessageManagerFactory.createMessageManager()
                .createMessage(text, timestamp, creator, audioKey);

        message.setKey(localDatabase.generateKey());

        return message;
    }
}

package client.events.executables.internalChanges.serverInteractions;

import client.pages.friends.Friends2;
import client.pages.pageInternal.serverClientInteractions.ServerTalker;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.tools.Constants;
import server.model.structureModels.ServerModel;
import server.model.user.UserConversations;
import server.services.factories.AudioManagerFactory;
import server.services.factories.MessageManagerFactory;
import tools.AudioTools.AudioPlayer;
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

    public ExecuteSendAudioMessage(Friends2 friends2){
        this.friend2 = friends2;
        this.conversation = ServerTalker.getConversationByFriend(friends2.getFriendName()).getKey();
    }

    @Override
    public void execute() {
        MAudio audio;
        if (os == MAC) {
            audio = AudioRecorder.getInstance().stopRecording();
        }
        else{
            audio = AudioManagerFactory.createAudioManager().createMockAudio();
        }

        MConversation conversation = localDatabase.getModel(this.conversation);
        /*---------------------------------------------------------------------------*/

        MMessage message = generateMMessage(audio);

        conversation.getMessageList().add(message.getKey());
        friend2.getMessageKeys().add(message.getKey());
        friend2.addAudioMessage(audio, 1, Constants.getCurrentTimestamp(message.getTimeStamp()));
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

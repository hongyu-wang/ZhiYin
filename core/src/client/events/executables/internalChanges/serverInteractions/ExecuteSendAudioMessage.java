package client.events.executables.internalChanges.serverInteractions;

import client.pages.friends.Friends2;
import server.services.factories.AudioManagerFactory;
import server.services.factories.MessageManagerFactory;
import tools.AudioTools.AudioRecorder;
import server.model.media.MAudio;
import server.model.social.MConversation;
import server.model.social.MMessage;

/**
 *
 * Created by Kevin Zheng on 2016-03-29.
 */
public class ExecuteSendAudioMessage implements ExecuteServer {
    private Friends2 friend2;


    public ExecuteSendAudioMessage(Friends2 friends2){
        this.friend2 = friends2;
    }




    @Override
    public void execute() {
        MAudio audio;
        if (os == MAC)
            audio = AudioRecorder.getInstance().stopRecording(); //TODO This is the MAudio that you want
        else{
            audio = AudioManagerFactory.createAudioManager().createMockAudio();
        }


        MConversation conversation = localDatabase.getModel(friend2.getConversation());
        /*---------------------------------------------------------------------------*/


        if(conversation == null){
            localDatabase.requestModelFromServer(friend2.getConversation());
            return;
        }// FIXME: 2016-04-02

        MMessage message = generateMMessage(audio);

        conversation.getMessageList().add(message.getKey());

        friend2.getMessageKeys().add(message.getKey());
        friend2.addAudioMessage(audio, 1);

        localDatabase.pushModel(audio);
        localDatabase.pushModel(message);
        localDatabase.pushModel(conversation);
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

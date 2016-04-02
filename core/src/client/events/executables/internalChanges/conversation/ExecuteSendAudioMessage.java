package client.events.executables.internalChanges.conversation;

import client.events.executables.internalChanges.schmoferMusicExecutable.ExecutePlayMAudio;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.friends.Friends2;
import client.pages.friends.Friends4;
import client.pages.friends.boxes.MessageBox;
import tools.AudioTools.AudioRecorder;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
import client.stateInterfaces.Executable;
import server.model.media.MAudio;
import server.model.social.MConversation;
import server.model.social.MMessage;

import java.util.List;

/**
 *
 * Created by Kevin Zheng on 2016-03-29.
 */
public class ExecuteSendAudioMessage implements Executable {
    private Friends2 page;


    public ExecuteSendAudioMessage(Friends2 friends2){
        this.page = friends2;

    }


    @Override
    public void execute() {
        MAudio audio = AudioRecorder.getInstance().stopRecording(); //TODO This is the MAudio that you want
        LocalDatabase localDatabase = LocalDatabaseFactory.createModelStorage();

        localDatabase.pushModel(audio);








        //TODO replace this with the messagebox
        ExecutePlayMAudio executePlayMAudio = new ExecutePlayMAudio(audio);
        MessageBox soundBox = new MessageBox(executePlayMAudio, 1, audio);



//      MConversation conversation = localDatabase.getModel(page.getConversation());
//        if(conversation == null){
//            localDatabase.requestModelFromServer(page.getConversation());
//            return;
//        }
        //TODO push the audio message to server
//        List<Long> messageKeys = conversation.getMessageList();
//
//
//
//        MMessage message = new MMessage();
//
//        message.setKey(localDatabase.generateKey());
//
//        message.setCreator(localDatabase.getMainUser().getKey());
//
//        message.setAudioKey(mAudio.getKey());
//
//        message.setText(-1L);
//
//        messageKeys.add(message.getKey());
//
//        page.getMessageKeys().add(message.getKey());
//
//
//        localDatabase.pushModel(message);
//        localDatabase.pushModel(conversation);
    }
}

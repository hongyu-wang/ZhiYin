package client.events.executables.internalChanges.serverInteractions;

import client.events.executables.internalChanges.schmoferMusicExecutable.ExecutePlayMAudio;
import client.pages.friends.Friends2;
import client.pages.friends.boxes.MessageBox;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.pages.pageInternal.serverClientInteractions.Talkers;
import client.tools.Constants;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
import client.stateInterfaces.Executable;
import server.model.media.MAudio;
import server.model.media.MText;
import server.model.social.MConversation;
import server.model.social.MMessage;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-24.
 */
public class ExecuteUpdateMessages extends ExecuteUpdate {
    private Friends2 friend2;

    public ExecuteUpdateMessages(Friends2 friend2){
        this.friend2 = friend2;

        TalkerFactory.getServerTalker().addExecutable(this);
    }

    @Override
    public void execute() {
        MConversation conversation = localDatabase.getModel(friend2.getConversation());
        MessageBox box;

        //New Code
        for(long key : conversation.getMessageList()){
            if(!friend2.getMessageKeys().contains(key)){
                MMessage mMessage = localDatabase.<MMessage>getModel(key);
                long textKey = mMessage.getText();

                int byUser = getWriter((int) mMessage.getCreator());

                if(mMessage.getText() != -1L) {
                    String text = localDatabase.<MText>getModel(textKey).getText();
                    box = new MessageBox(text, byUser, Constants.getCurrentTimestamp(mMessage.getTimeStamp()));
                }
                else{
                    MAudio audio = localDatabase.getModel(mMessage.getAudioKey());
                    ExecutePlayMAudio epma = new ExecutePlayMAudio(audio);
                    box = new MessageBox(epma, byUser, audio, Constants.getCurrentTimestamp(mMessage.getTimeStamp()));
                }

                friend2.addMessage(box);
                friend2.getMessageKeys().add(mMessage.getKey());

                friend2.getMessageKeys().add(mMessage.getKey());
                friend2.addMessage(box);
            }
        }
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

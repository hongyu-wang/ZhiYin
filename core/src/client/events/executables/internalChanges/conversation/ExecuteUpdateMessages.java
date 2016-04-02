package client.events.executables.internalChanges.conversation;

import client.events.executables.internalChanges.schmoferMusicExecutable.ExecutePlayMAudio;
import client.pages.friends.Friends2;
import client.pages.friends.boxes.MessageBox;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
import client.stateInterfaces.Executable;
import server.model.media.MAudio;
import server.model.media.MText;
import server.model.social.MConversation;
import server.model.social.MMessage;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-24.
 */
public class ExecuteUpdateMessages implements Executable {
    private Friends2 friend2;

    public ExecuteUpdateMessages(Friends2 friend2){
        this.friend2 = friend2;
    }

    @Override
    public void execute() {
        LocalDatabase localDatabase = LocalDatabaseFactory.createModelStorage();

        MConversation conversation = localDatabase.getModel(friend2.getConversation());

        localDatabase.requestModelFromServer(friend2.getConversation());

        List<Long> messageKeys = conversation.getMessageList();

        boolean updated = true;

        for(long key :messageKeys){
            if(!friend2.getMessageKeys().contains(key)){
                MMessage mMessage = localDatabase.<MMessage>getModel(key);

                if(mMessage != null) {
                    long textKey = mMessage.getText();
                    if (mMessage.getText() != -1L) {
                        if(localDatabase.getModel(mMessage.getText()) != null){
                            if(updated) {
                                String text = localDatabase.<MText>getModel(textKey).getText();

                                MessageBox box = new MessageBox(text, getWriter(localDatabase, (int) mMessage.getCreator()));
                                friend2.addMessage(box);
                                friend2.getMessageKeys().add(mMessage.getKey());
                            }
                        }
                        else{
                            localDatabase.requestModelFromServer(textKey);
                            updated = false;
                        }
                    }
                    else{
                        if(localDatabase.getModel(mMessage.getAudioKey()) != null){
                            if(updated) {
                                MAudio audio = localDatabase.getModel(mMessage.getAudioKey());

                                ExecutePlayMAudio epma = new ExecutePlayMAudio(audio);
                                MessageBox box = new MessageBox(epma, 1, audio);

                                friend2.getMessageKeys().add(mMessage.getKey());

                                friend2.getAudioKeys().add(audio.getKey());

                                friend2.addMessage(box);
                            }
                        }
                        else{
                            localDatabase.requestModelFromServer(mMessage.getAudioKey());
                            updated = false;
                        }
                    }
                }
                else{
                    localDatabase.requestModelFromServer(key);
                    updated = false;
                }
            }
        }
    }



    private int getWriter(LocalDatabase localDatabase, int user){
        if(user == localDatabase.getMainUser().getKey()){
            return 1;
        }

        else{
            return 0;
        }
    }
}

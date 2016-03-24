package client.events.executables.internalChanges;

import client.pages.pageInternal.serverClientInteractions.ConversationTalker;
import client.pages.pageInternal.serverClientInteractions.SocialContentTalker;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.stateInterfaces.Executable;
import server.model.social.MConversation;

/**
 * Created by Kevin Zheng on 2016-03-24.
 */
public class ExecuteHardReset implements Executable {
    private String name;

    public ExecuteHardReset(String friendName){
        name = friendName;
    }


    @Override
    public void execute() {
        SocialContentTalker sctalker = TalkerFactory.getSocialContentTalker();
        ConversationTalker talker = TalkerFactory.getMessagesTalker();

        int indexOfConvo = talker.indexByFriend(name);
        sctalker.init();
        sctalker.update(0);

        MConversation convo = sctalker.getConversations().get(indexOfConvo);
        talker.init(convo);
    }
}

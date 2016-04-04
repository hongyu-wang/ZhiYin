package client.events.executables.internalChanges.serverInteractions;

import client.pages.home.Discovery;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-04-03.
 */
public class ExecuteUpdateTags extends ExecuteUpdate {
    private Discovery discovery;
    private List<String> currentHashtags;

    public ExecuteUpdateTags(Discovery discovery) {
        this.discovery = discovery;
        this.currentHashtags = Utils.newList();
    }

    @Override
    public void execute() {
        for(String hashtag: localDatabase.getHashtags()){
            if(currentHashtags.contains(hashtag)){
                continue;
            }

            discovery.addTag(hashtag);
            this.currentHashtags.add(hashtag);
        }
    }
}

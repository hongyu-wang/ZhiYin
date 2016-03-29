package client.events.executables.internalChanges.conversation;

import client.pages.other.Comment;
import client.stateInterfaces.Executable;

/**
 * Created by Kevin Zheng on 2016-03-29.
 */
public class ExecuteSendComment implements Executable {
    private Comment commentPage;
    public ExecuteSendComment(Comment commentPage){
        this.commentPage = commentPage;
    }


    @Override
    public void execute() {

    }
}

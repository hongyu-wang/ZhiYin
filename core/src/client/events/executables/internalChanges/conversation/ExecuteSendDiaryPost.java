package client.events.executables.internalChanges.conversation;

import client.pages.musicDiary.Diary2;
import client.stateInterfaces.Executable;

/**
 * Created by Kevin Zheng on 2016-03-29.
 */
public class ExecuteSendDiaryPost implements Executable {
    Diary2 diary2;

    public ExecuteSendDiaryPost(Diary2 diary2){
        this.diary2 = diary2;
    }

    @Override
    public void execute() {

    }
}

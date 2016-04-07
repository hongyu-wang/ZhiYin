package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.pages.musicDiary.Diary2;
import client.stateInterfaces.Executable;
import server.model.media.MMusic;

/**
 * Created by Kevin Zheng on 2016-04-07.
 */
public class ExecuteSetDiaryPostMusic implements Executable {
    private Diary2 diary2;
    private MMusic music;

    public ExecuteSetDiaryPostMusic(Diary2 diary2, MMusic music){
        this.diary2 = diary2;
        this.music = music;
    }

    @Override
    public void execute() {
        diary2.setMusic(music);
    }
}

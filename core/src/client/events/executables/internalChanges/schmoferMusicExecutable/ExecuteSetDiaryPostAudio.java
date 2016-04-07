package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.pages.musicDiary.Diary2;
import client.stateInterfaces.Executable;
import server.model.media.MAudio;
import server.services.factories.AudioManagerFactory;
import tools.AudioTools.AudioRecorder;

/**
 * Created by Kevin Zheng on 2016-04-07.
 */
public class ExecuteSetDiaryPostAudio implements Executable {
    private Diary2 diary2;

    public ExecuteSetDiaryPostAudio(Diary2 diary2){
        this.diary2 = diary2;
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

        this.diary2.setAudio(audio);
    }
}

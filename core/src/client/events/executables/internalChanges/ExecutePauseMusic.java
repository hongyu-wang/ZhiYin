package client.events.executables.internalChanges;

import client.stateInterfaces.Executable;
import com.badlogic.gdx.audio.Music;

/**
 * Created by Hongyu Wang on 3/15/2016.
 */
public class ExecutePauseMusic implements Executable{

    private Music music;
    public ExecutePauseMusic(Music music){
        this.music = music;
    }

    @Override
    public void execute() {

        music.pause();

    }
}

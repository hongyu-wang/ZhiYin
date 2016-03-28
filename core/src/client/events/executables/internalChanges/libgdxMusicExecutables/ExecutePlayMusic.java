package client.events.executables.internalChanges.libgdxMusicExecutables;

import client.stateInterfaces.Executable;
import com.badlogic.gdx.audio.Music;

/**
 * This class will check if
 * the current music is playing.
 *
 * Created by Hongyu Wang on 3/15/2016.
 */
@Deprecated
public class ExecutePlayMusic implements Executable{

    private Music music;
    public ExecutePlayMusic(Music music){
        this.music = music;
    }

    @Override
    public void execute() {
        if (music.isPlaying()){
            music.pause();
        }else{
            music.play();
        }
    }
}

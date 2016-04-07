package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.stateInterfaces.Executable;
import com.badlogic.gdx.Audio;
import server.model.media.MAudio;
import server.model.media.MHashtag;
import server.model.media.MMusic;
import tools.AudioTools.AudioPlayer;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;

/**
 * Created by Kevin Zheng on 2016-04-05.
 */
public class ExecutePlayHashtag implements Executable {
    private long tag;

    public ExecutePlayHashtag(String tag){
        try {
            this.tag = LocalDatabaseFactory.createLocalDatabase().getHashtagByName(tag);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("You have entered an invalid hashtag.");
        }
    }

    @Override
    public void execute() {
        MHashtag tag = LocalDatabaseFactory.createLocalDatabase().getModel(this.tag);
        if(tag == null){
            return;
        }
        if (AudioPlayer.getInstance().isPlaying()){
            AudioPlayer.getInstance().pause();
            return;
        }

        int num = (int) (Math.random()*tag.getMusicKeys().size());

        MMusic music = LocalDatabaseFactory.createLocalDatabase().getModel(tag.getMusicKeys().get(num));
        MAudio audio = LocalDatabaseFactory.createLocalDatabase().getModel(music.getMusicKey());

        new ExecutePlayMAudio(audio).execute();
    }
}

package client.events.executables.internalChanges;

import client.pageStorage.Pages;
import client.pages.other.NowPlaying;
import org.robovm.apple.foundation.NSErrorException;

/**
 * This sets the music of the player and goes there.
 *
 * Created by Hongyu Wang on 3/15/2016.
 */
public class ExecuteChangeandSetMusic extends ExecuteChangePage{
    public String musicName;
    public ExecuteChangeandSetMusic(String name) {
        super(Pages.NOWPLAYING);
        musicName = name;
    }

    public void execute(){
        super.execute();
        NowPlaying page = (NowPlaying)(Pages.NOWPLAYING.getStateReference());
        try {
            page.setMusic(musicName);
        } catch (NSErrorException e) {
            e.printStackTrace();
        }
    }
}

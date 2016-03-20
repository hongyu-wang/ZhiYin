package client.events.executables.internalChanges;

import client.pageStorage.Pages;
import client.pages.other.NowPlaying;
import client.stateInterfaces.Executable;
import org.robovm.apple.foundation.NSErrorException;

/**
 * This class will check if
 * the current music is playing.
 *
 * Created by Hongyu Wang on 3/15/2016.
 */
public class ExecutePlayMusic implements Executable{



    @Override
    public void execute() {
        try {
            NowPlaying page = (NowPlaying) Pages.NOWPLAYING.getStateReference();
            if (page.getPlayer().isPlaying()) {
                page.getPlayer().pause();
                return;
            }
            page.getPlayer().prepareToPlay();
            page.getPlayer().play();
        }catch(NSErrorException e){
            e.printStackTrace();
        }
    }
}

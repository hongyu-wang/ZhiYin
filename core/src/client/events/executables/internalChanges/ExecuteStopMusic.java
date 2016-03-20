package client.events.executables.internalChanges;

import client.pageStorage.Pages;
import client.pages.other.NowPlaying;
import client.stateInterfaces.Executable;
import org.robovm.apple.foundation.NSErrorException;

/**
 * Created by JimGuo on 3/15/16.
 */
public class ExecuteStopMusic implements Executable {


    @Override
    public void execute() {
        NowPlaying page = (NowPlaying)(Pages.NOWPLAYING.getStateReference());

        try {
            page.getPlayer().stop();
        } catch (NSErrorException e) {
            e.printStackTrace();
        }
    }
}


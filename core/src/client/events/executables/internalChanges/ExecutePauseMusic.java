package client.events.executables.internalChanges;

import client.pageStorage.Pages;
import client.pages.other.NowPlaying;
import client.stateInterfaces.Executable;

/**
 * Created by Hongyu Wang on 3/15/2016.
 */
public class ExecutePauseMusic implements Executable{


    @Override
    public void execute() {
        NowPlaying page = (NowPlaying)(Pages.NOWPLAYING.getStateReference());

        page.getMusic().pause();
    }
}

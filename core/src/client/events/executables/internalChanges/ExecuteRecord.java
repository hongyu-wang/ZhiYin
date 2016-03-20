package client.events.executables.internalChanges;

import client.pageStorage.Pages;
import client.pages.other.NowPlaying;
import client.stateInterfaces.Executable;
import org.robovm.apple.foundation.NSErrorException;
import server.model.media.MAudio;

/**
 * Created by JimGuo on 3/15/16.
 */
public class ExecuteRecord implements Executable {

    @Override
    public void execute() {
        NowPlaying page = (NowPlaying) Pages.NOWPLAYING.getStateReference();
        try {
            if (page.getr().isRecording()) {
                MAudio s = page.getr().stopRecording();
                page.setMusic2(s);
                System.out.println("record end music set");
                return;
            }
            page.getr().prepareToRecord();
            page.getr().startRecording();
            System.out.println("record start");
        }catch(NSErrorException e){
            e.printStackTrace();
        }


    }
}

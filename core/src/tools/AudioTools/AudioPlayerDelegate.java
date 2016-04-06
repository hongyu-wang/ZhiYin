package tools.AudioTools;

import client.pages.State;
import client.singletons.StateManager;
import client.stateInterfaces.HasPlayButtons;
import org.robovm.apple.avfoundation.AVAudioPlayer;
import org.robovm.apple.avfoundation.AVAudioPlayerDelegate;
import org.robovm.apple.foundation.NSError;
import org.robovm.rt.bro.annotation.MachineSizedUInt;

/**
 * Created by Kevin Zheng on 2016-04-06.
 */
public class AudioPlayerDelegate implements AVAudioPlayerDelegate{
    private Runnable runnable = () -> {
        State current = StateManager.getInstance().getCurrentState();
        if (current instanceof HasPlayButtons)
            ((HasPlayButtons)current).resetPlayButtons();


    };
    @Override
    public void didFinishPlaying(AVAudioPlayer avAudioPlayer, boolean b) {
        runnable.run();
        if(!AudioPlayer.getInstance().isPlayingSnapShot())
            AudioPlayer.getInstance().stop();

    }

    @Override
    public void decodeErrorDidOccur(AVAudioPlayer avAudioPlayer, NSError nsError) {

    }

    @Override
    public void beginInterruption(AVAudioPlayer avAudioPlayer) {
        return;
    }

    @Override
    public void endInterruption(AVAudioPlayer avAudioPlayer, @MachineSizedUInt long l) {
        return;
    }
}

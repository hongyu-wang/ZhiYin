package server.model.media;

import org.robovm.apple.foundation.NSData;
import server.model.structureModels.ServerModel;
import java.util.Vector;


/**A piece of audio that has not been identified as a piece of music yet.
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MAudio extends ServerModel {

    private int trackMinutes;

    private int trackSeconds;

    private int sampleRate;

    private NSData mData;

    public NSData getmData() {
        return mData;
    }

    public void setmData(NSData mData) {this.mData = mData;
    }


    public int getTrackMinutes() {return trackMinutes;
    }

    public void setTrackMinutes(int trackMinutes) {this.trackMinutes = trackMinutes;
    }

    public int getTrackSeconds() {return trackSeconds;
    }

    public void setTrackSeconds(int trackSeconds) {this.trackSeconds = trackSeconds;
    }

    public int getSampleRate() {return sampleRate;
    }

    public void setSampleRate(int sampleRate) {this.sampleRate = sampleRate;
    }

}
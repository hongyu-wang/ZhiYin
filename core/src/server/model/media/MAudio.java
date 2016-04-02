package server.model.media;

import org.robovm.apple.foundation.NSData;
import server.model.structureModels.ServerModel;
import java.util.Vector;


/**A piece of audio that has not been identified as a piece of music yet.
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MAudio extends ServerModel {

    /**
     * Track length in seconds.
     */
    private double trackLength;

    private int sampleRate;

    private byte[] mData;


    public MAudio(){

    }


    public byte[] getmData() {
        return mData;
    }

    public void setmData(byte[] mData) {this.mData = mData;
    }


    public double getTrackLength(){
        return trackLength;
    }

    public void setTrackLength(double time){
        trackLength = time;
    }

    public int getSampleRate() {return sampleRate;
    }

    public void setSampleRate(int sampleRate) {this.sampleRate = sampleRate;
    }

}
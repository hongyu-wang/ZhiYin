package server.model.media;

import org.robovm.apple.foundation.NSData;
import server.model.structureModels.ServerModel;

/**
 * Created by Kevin Zheng on 2016-03-13.
 */
public class MSnapShot extends ServerModel {

    private MAudio message;

    private MMusic song;

    private int startTime;

    private int endTime;


    public MAudio getMessage() {
        return message;
    }

    public void setMessage(MAudio message) {
        this.message = message;
    }

    public MMusic getSong() {
        return song;
    }

    public void setSong(MMusic song) {
        this.song = song;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }



}

package server.model.media;

import org.robovm.apple.foundation.NSData;
import server.model.structureModels.ServerModel;

/**
 * Created by Kevin Zheng on 2016-03-13.
 */
public class MSnapShot extends ServerModel {

    private long message;

    private long song;

    private int startTime;

    private int endTime;

    private long creator;

    public long getMessage() {
        return message;
    }

    public void setMessage(long message) {
        this.message = message;
    }

    public long getSong() {
        return song;
    }

    public void setSong(long song) {
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

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }
}

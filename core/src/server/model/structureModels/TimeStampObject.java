package server.model.structureModels;

/**
 * Created by Kevin Zheng on 2016-04-04.
 */
public abstract class TimeStampObject extends ServerModel implements Comparable<TimeStampObject>{
    /**
     * Long representation of the timestamp of when the post was created
     */
    protected long timeStamp;

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public int compareTo(TimeStampObject o) {
        if(this.timeStamp > o.timeStamp){
            return 1;
        }
        else if(this.timeStamp < o.timeStamp){
            return -1;
        }
        else{
            return 0;
        }
    }
}

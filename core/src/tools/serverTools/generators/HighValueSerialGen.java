package tools.serverTools.generators;

/**
 * Created by Kevin Zheng on 2016-03-21.
 */
public class HighValueSerialGen implements SerialGenerator {
    private long t = 1;

    public HighValueSerialGen(long start){
        t = start + t;
    }


    @Override
    public long generateSerial() {
        return t++;
    }
}

package tools.serverTools.generators;

/**
 * Created by Kevin Zheng on 2016-03-10.
 */
public class IncrementSerialGen implements SerialGenerator{
    private long t = 1;

    @Override
    public long generateSerial() {
        return t++;
    }
}

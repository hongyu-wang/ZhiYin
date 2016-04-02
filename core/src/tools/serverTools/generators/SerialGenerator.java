package tools.serverTools.generators;

/**
 * Created by Kevin Zheng on 2016-03-10.
 */
public interface SerialGenerator {
    /**
     * Generates a unique serial id.
     *
     * @return  The new serial id long.
     */
    long generateSerial();

    /**Returns a general type.
     *
     * @return  IncrementalSerialGen
     */
    static SerialGenerator getGenerator(){
        return new IncrementSerialGen();
    }


    static SerialGenerator getHGenerator(long start) {
        return new HighValueSerialGen(start);
    }
}
